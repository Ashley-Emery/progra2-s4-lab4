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
    
    private AdminPalabrasSecretas adminPalabras;

    
    public JuegoAhorcadoAzar(AdminPalabrasSecretas adminPalabras){
        this.adminPalabras = adminPalabras;
        this.limiteIntentos = 6;
        this.intentos = limiteIntentos;
        this.letrasUsadas = new ArrayList<>();
        this.figuraAhorcado = new ArrayList<>();
        inicializarFigura();
    }
    public void inicializarPalabraSecreta() {
        this.palabraSecreta = adminPalabras.obtenerPalabraAzar().toUpperCase();
        this.palabraActual = "_".repeat(palabraSecreta.length());
    }
   
}
