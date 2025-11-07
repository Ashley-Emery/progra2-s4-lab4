/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.s4.lab4;

/**
 *
 * @author ashley
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;


public class VentanaJuegoAhorcado extends JFrame {
    
    private final AdminPalabrasSecretas admin;
    private JuegoAhorcadoBase juegoFijoExample;
    private JuegoAhorcadoBase juegoAzarExample;
    private JuegoAhorcadoBase juegoActual;
    
    private final JComboBox<String> modoCombo;
    private final JButton btnNuevaPartida;
    private final JLabel lblPalabra;
    private final JLabel lblIntentos;
    private final JTextArea txtFigura;
    private final JLabel lblLetrasCorrectas;
    private final JLabel lblLetrasErradas;
    private final JTextField tfLetra;
    private final JButton btnEnviar;
    private final JTextField tfAgregarPalabra;
    private final JButton btnAgregarPalabra;
    
    public VentanaJuegoAhorcado(AdminPalabrasSecretas admin,
                               JuegoAhorcadoBase ejemploFijo,
                               JuegoAhorcadoBase ejemploAzar) {
        
        super("Ahorcado - Progra2 Lab");
        this.admin = admin;
        this.juegoFijoExample = ejemploFijo;
        this.juegoAzarExample = ejemploAzar;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));
        
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        modoCombo = new JComboBox<>(new String[] {"AZAR", "FIJO"});
        btnNuevaPartida = new JButton("Nueva Partida");
        tfAgregarPalabra = new JTextField(12);
        btnAgregarPalabra = new JButton("Agregar palabra (Admin)");
        
        top.add(new JLabel("Modo:"));
        top.add(modoCombo);
        top.add(btnNuevaPartida);
        top.add(new JLabel("Agregar palabra:"));
        top.add(tfAgregarPalabra);
        top.add(btnAgregarPalabra);
        
        add(top, BorderLayout.NORTH);
        
        JPanel center = new JPanel(new GridLayout(1, 2, 8, 8));
        
        txtFigura = new JTextArea();
        txtFigura.setEditable(false);
        txtFigura.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        txtFigura.setBorder(BorderFactory.createTitledBorder("Figura"));
        
        JPanel estado = new JPanel();
        estado.setLayout(new BoxLayout(estado, BoxLayout.Y_AXIS));
        lblPalabra = new JLabel("Palabra: ");
        lblPalabra.setFont(new Font(Font.MONOSPACED, Font.BOLD, 26));
        lblIntentos = new JLabel("Intentos: 0 / 6");
        lblIntentos.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        lblLetrasCorrectas = new JLabel("Correctas: []");
        lblLetrasErradas = new JLabel("Erradas: []");
        
        estado.add(lblPalabra);
        estado.add(Box.createVerticalStrut(16));
        estado.add(lblIntentos);
        estado.add(Box.createVerticalStrut(10));
        estado.add(lblLetrasCorrectas);
        estado.add(Box.createVerticalStrut(6));
        estado.add(lblLetrasErradas);
        
        center.add(new JScrollPane(txtFigura));
        center.add(estado);
        
        add(center, BorderLayout.CENTER);
        
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        tfLetra = new JTextField(3);
        btnEnviar = new JButton("Enviar letra");
        bottom.add(new JLabel("Ingrese letra:"));
        bottom.add(tfLetra);
        bottom.add(btnEnviar);
        
        add(bottom, BorderLayout.SOUTH);
        
        btnAgregarPalabra.addActionListener(e -> {
            String p = tfAgregarPalabra.getText();
            if (p == null || p.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una palabra válida para agregar.");
                return;
            }
            boolean ok = admin.agregarPalabra(p);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Palabra agregada: " + p.toUpperCase());
                tfAgregarPalabra.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se agregó (duplicada o inválida).");
            }
        });
        
        btnNuevaPartida.addActionListener(e -> crearNuevaPartida());
        
        btnEnviar.addActionListener(e -> {
            procesarLetraIngresada();
        });
        
        setInputEnabled(false);
    }

    private void crearNuevaPartida() {
        
        String modo = (String) modoCombo.getSelectedItem();
        
        if ("FIJO".equalsIgnoreCase(modo)) {
            
            if (juegoFijoExample != null) {
                juegoActual = new JuegoAhorcadoFijo(juegoFijoExample.getPalabraSecreta());
            } else {
                String p = JOptionPane.showInputDialog(this, "Ingrese palabra secreta para modo FIJO:");
                if (p == null || p.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Operación cancelada: palabra no ingresada.");
                    return;
                }
                juegoActual = new JuegoAhorcadoFijo(p.trim().toUpperCase());
            }
        } else {

            
            if (admin.listarPalabras().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay palabras en Admin. Agregue palabras primero.");
                return;
            }
            juegoActual = new JuegoAhorcadoAzar(admin);
            
            if (juegoActual.getFiguraAhorcado() == null || juegoActual.getFiguraAhorcado().isEmpty()) {
                juegoActual.figuraAhorcado = juegoActual.crearFiguraBase();
            }
        }
        
        if (juegoActual.getFiguraAhorcado() == null || juegoActual.getFiguraAhorcado().isEmpty()) {
            juegoActual.figuraAhorcado = juegoActual.crearFiguraBase();
        }

        actualizarVista();
        setInputEnabled(true);
        tfLetra.requestFocusInWindow();
    }

    private void procesarLetraIngresada() {
        if (juegoActual == null)
            return;
        
        String entrada = tfLetra.getText();
        
        if (entrada == null || entrada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una letra.");
            return;
        }
        char letra = entrada.charAt(0);
        
        try {
            
            boolean acerto = juegoActual.intentarLetra(letra);
            if (acerto) {
                
                actualizarVista();
                
                if (juegoActual.hasGanado()) {
                    actualizarVista();
                    JOptionPane.showMessageDialog(this, "¡Ganaste! Palabra: " + juegoActual.getPalabraSecreta());
                    setInputEnabled(false);
                }
            } else {
                actualizarVista();
                
                if (juegoActual.getIntentos() <= 0) {
                    JOptionPane.showMessageDialog(this, "Perdiste. La palabra era: " + juegoActual.getPalabraSecreta());
                    setInputEnabled(false);
                }
                
            }
        } catch (AhorcadoExceptions.LetraRepetidaException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Letra repetida", JOptionPane.WARNING_MESSAGE);
        
        } catch (AhorcadoExceptions.EntradaInvalidaException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        
        } catch (AhorcadoExceptions.IntentosAgotadosException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Intentos agotados", JOptionPane.ERROR_MESSAGE);
            setInputEnabled(false);
        
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
        } finally {
            
            tfLetra.setText("");
            tfLetra.requestFocusInWindow();
            
        }
    }

    private void actualizarVista() {
        
        if (juegoActual == null)
            return;
        lblPalabra.setText("Palabra: " + spaced(juegoActual.getPalabraActual()));
        lblIntentos.setText("Intentos: " + juegoActual.getIntentos() + " / " + juegoActual.getLimiteIntentos());
        
        List<Character> usadas = juegoActual.getLetrasUsadas();
        List<Character> correctas = usadas.stream().filter(c -> juegoActual.getPalabraSecreta().indexOf(c) >= 0).collect(Collectors.toList());
        List<Character> erradas = usadas.stream().filter(c -> juegoActual.getPalabraSecreta().indexOf(c) < 0).collect(Collectors.toList());

        lblLetrasCorrectas.setText("Correctas: " + correctas.toString());
        lblLetrasErradas.setText("Erradas: " + erradas.toString());

        txtFigura.setText(juegoActual.obtenerFigura());
    }

    private String spaced(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(' ');
        }
        return sb.toString().trim();
    }

    private void setInputEnabled(boolean enabled) {
        
        tfLetra.setEnabled(enabled);
        btnEnviar.setEnabled(enabled);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            
            AdminPalabrasSecretas admin = new AdminPalabrasSecretas();

            JuegoAhorcadoBase ejemploFijo = new JuegoAhorcadoFijo("PROGRAMACION");
            JuegoAhorcadoBase ejemploAzar = new JuegoAhorcadoAzar(admin);

            VentanaJuegoAhorcado v = new VentanaJuegoAhorcado(admin, ejemploFijo, ejemploAzar);
            v.setVisible(true);
        });
    }
    
}

