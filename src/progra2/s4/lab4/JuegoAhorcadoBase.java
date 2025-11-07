/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.s4.lab4;

/**
 *
 * @author ashley
 */

import java.util.ArrayList;

public abstract class JuegoAhorcadoBase {
    
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected int limiteIntentos;
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;
    
    public JuegoAhorcadoBase(){
        
        this.letrasUsadas = new ArrayList<>();
        this.figuraAhorcado = crearFiguraBase();
        this.intentos = this.limiteIntentos;
    }
    
    
    
    
    
    // actualizarPalabraActual verificarLetra(char letra) hasGanado()
}
