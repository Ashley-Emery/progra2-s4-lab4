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
    private Random random = new Random();

    public JuegoAhorcadoAzar(AdminPalabrasSecretas adminPalabras) {
        super(6); // límite de 6 intentos
        this.adminPalabras = adminPalabras;
    }

    public void inicializarPalabraSecreta() {
        String palabra = adminPalabras.obtenerPalabraAzar();
        if (palabra == null || palabra.isEmpty()) {
            throw new IllegalStateException("No hay palabras disponibles para seleccionar.");
        }
        super.inicializarPalabraSecreta(palabra);
    }

    @Override
    public void jugar() {
        
    }

    @Override
    public boolean verificarLetra(char letra) {
        letra = Character.toUpperCase(letra);

        if (letrasUsadas.contains(letra)) {
            System.out.println("Letra repetida: " + letra);
            return false;
        }

        letrasUsadas.add(letra);

        if (palabraSecreta.indexOf(letra) >= 0) {
            actualizarPalabraActual(letra);
            return true;
        } else {
            intentos--;
            actualizarFigura();
            return false;
        }
    }

    @Override
    public void actualizarPalabraActual(char letra) {
        StringBuilder nueva = new StringBuilder(palabraActual);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nueva.setCharAt(i, letra);
            }
        }
        palabraActual = nueva.toString();
    }

    @Override
    public boolean hasGanado() {
        return !palabraActual.contains("_");
    }

    public void actualizarFigura() {
        int errores = limiteIntentos - intentos;
        if (errores >= 0 && errores < figuraAhorcado.size()) {
            System.out.println(figuraAhorcado.get(errores));
        }
    }
    

}
