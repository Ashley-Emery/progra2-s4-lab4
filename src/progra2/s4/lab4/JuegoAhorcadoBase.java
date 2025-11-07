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

public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    
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
    public String getPalabraSecreta(){
        return palabraSecreta;
    }
    
    public String getPalabraActual(){
        return palabraActual;
    }
    
    public int getIntentos(){
        return intentos;
    }
    
    public int getLimiteIntentos(){
        return limiteIntentos;
    }
    
    public ArrayList<Character> getLetrasUsadas(){
        return letrasUsadas;
    }
    
    public ArrayList<String> getFiguraAhorcado(){
        return figuraAhorcado;
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
    
    public void inicializarPalabraSecreta(String palabra){
        
        if( palabra == null || palabra.trim().isEmpty() ){
            throw new IllegalArgumentException("La palabra secreta no puede ser nula o vacia");
        }
        
        palabraSecreta = palabra.trim().toUpperCase();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            
            char c = palabraSecreta.charAt(i);
            
            if(Character.isLetter(c)){
                sb.append("_");
            } else {
                sb.append(c);
            }
            
            palabraActual = sb.toString();
            letrasUsadas.clear();
            intentos = limiteIntentos;
        }
    }
    
    
    
    
    
    
    
    // actualizarPalabraActual verificarLetra(char letra) hasGanado()
}
