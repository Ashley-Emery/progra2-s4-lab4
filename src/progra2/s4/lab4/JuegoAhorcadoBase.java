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
import java.util.Arrays;

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
    
    public JuegoAhorcadoBase(int limiteIntentos){
        this();
        if( limiteIntentos>0 ){
            this.limiteIntentos = limiteIntentos;
            this.intentos = limiteIntentos;
        }
    }
    
    public ArrayList<String> crearFiguraBase(){
        return new ArrayList<>(Arrays.asList(
                "",
                "  O  ",
                "  O  \\n  |  ",
                "  O  \\n /|  ",
                "  O  \\n /|\\\\ ",
                "  O  \\n /|\\\\ \\n /   ",
                "  O  \\n /|\\\\ \\n / \\\\ "
        ));
    }
    
    
    
    
    
    // actualizarPalabraActual verificarLetra(char letra) hasGanado()
}
