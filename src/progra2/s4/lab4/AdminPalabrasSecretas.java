//Clase AdminPalabrasSecretas 
package progra2.s4.lab4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author axelr
 */
public class AdminPalabrasSecretas {
    ArrayList<String> listaPalabras= new ArrayList<>();
    
    AdminPalabrasSecretas(ArrayList<String> listaPalabras){
        this.listaPalabras= listaPalabras;
    }
    
    public void agregarPalabras(String nuevaPalabra){
        for( String palabra : listaPalabras){
            if(nuevaPalabra.equals(palabra)==false)
                listaPalabras.add(nuevaPalabra);
        }
    }
    
    public String obtenerPalabraFija(int indice){
        return listaPalabras.get(indice-1);
    }
    
    public String obtenerPalabraAzar(){
        Random indice= new Random();
        return listaPalabras.get(indice.nextInt(0, listaPalabras.size()));
    }
    
}