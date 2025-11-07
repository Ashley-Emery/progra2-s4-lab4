/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.s4.lab4;

/**
 *
 * @author ashley
 */
public class AhorcadoExceptions {
    
    public static class LetraRepetidaException extends Exception{
        public LetraRepetidaException(String mensaje){
            super(mensaje);
        }
    }
    
    public static class IntentosAgotadosException extends Exception{
        public IntentosAgotadosException(String mensaje){
            super(mensaje);
        }
    }
    
    public static class EntradaInvalidaException extends Exception{
        public EntradaInvalidaException(String mensaje){
            super(mensaje);
        }
    }
}
