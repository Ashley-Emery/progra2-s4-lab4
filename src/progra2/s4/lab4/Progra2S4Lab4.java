/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progra2.s4.lab4;

/**
 *
 * @author ashley
 */
import javax.swing.SwingUtilities;

public class Progra2S4Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(() -> {
            
            AdminPalabrasSecretas admin = new AdminPalabrasSecretas();
            
            JuegoAhorcadoBase juegoFijo = new JuegoAhorcadoFijo("PROGRAMACION");
            
            JuegoAhorcadoBase juegoAzar = new JuegoAhorcadoAzar(admin);
            
            VentanaJuegoAhorcado ventana = new VentanaJuegoAhorcado(admin, juegoFijo, juegoAzar);
            ventana.setVisible(true);
        });
    }    
}
