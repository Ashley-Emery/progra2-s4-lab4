/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.s4.lab4;

/**
 *
 * @author gaat1
 */
import java.util.ArrayList;
import java.util.Random;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
    private final AdminPalabrasSecretas admin;

    public JuegoAhorcadoAzar(AdminPalabrasSecretas admin) {
        super();
        this.admin = admin;
        
        if (figuraAhorcado == null || figuraAhorcado.isEmpty()) {
            figuraAhorcado = crearFiguraBase();
        }
        
        String palabra = admin.obtenerPalabraAlAzar();
        
        if (palabra != null)
            inicializarPalabraSecreta(palabra);
    }

    public void seleccionarNuevaPalabra() {
        String p = admin.obtenerPalabraAlAzar();
        
        if (p != null) {
            inicializarPalabraSecreta(p);
        }
    }
    
    public boolean verificarLetra(char letra) throws AhorcadoExceptions.EntradaInvalidaException {
        if (!Character.isLetter(letra)) {
            throw new AhorcadoExceptions.EntradaInvalidaException("Debe ingresar una letra.");
        }
        letra = Character.toUpperCase(letra);
        boolean contiene = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                contiene = true;
            }
        }
        if (contiene) actualizarPalabraActual(letra);
        return contiene;
    }

    public void actualizarPalabraActual(char letra) {
        
        StringBuilder sb = new StringBuilder(palabraActual);
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            
            if (palabraSecreta.charAt(i) == letra) {
                sb.setCharAt(i, letra);
            }
            
        }
        palabraActual = sb.toString();
    }
    
    public boolean hasGanado() {
        return palabraActual != null && palabraActual.equals(palabraSecreta);
    }
    
    public void jugar() {
        throw new UnsupportedOperationException("Use la GUI para jugar (VentanaAhorcado).");
    }

}
