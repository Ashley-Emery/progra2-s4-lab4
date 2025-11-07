//Clase AdminPalabrasSecretas 
package progra2.s4.lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 *
 * @author axelr
 */
public class AdminPalabrasSecretas {
    
    public ArrayList<String> listaPalabras= new ArrayList<>();
    public Random rnd;
    
    public AdminPalabrasSecretas(){
        this.listaPalabras= listaPalabras;
        this.rnd = new Random();
        
        Collections.addAll(this.listaPalabras, "JAVA", "PROGRAMACION", "AHORCADO", "NETBEANS", "UNIVERSIDAD", "ASHLEY", "AXEL", "CARLOS", "GUILLERMO");
    }
    
        public boolean agregarPalabra(String palabra) {
            
        if (palabra == null)
            return false;
        
        String p = palabra.trim();
        
        if (p.isEmpty())
            return false;
        
        for (String existente : listaPalabras) {
            if (existente.equalsIgnoreCase(p)) {
                return false;
            }
        }
        
        listaPalabras.add(p.toUpperCase());
        return true;
    }
    
    public String obtenerPalabraAlAzar() {
        
        if (listaPalabras.isEmpty())
            return null;
        return listaPalabras.get(rnd.nextInt(listaPalabras.size()));
    }
    
    public ArrayList<String> listarPalabras() {
        
        return new ArrayList<>(listaPalabras);
    }

    public boolean removerPalabra(String palabra) {
        
        if (palabra == null)
            return false;
        
        for (int i = 0; i < listaPalabras.size(); i++) {
            
            if (listaPalabras.get(i).equalsIgnoreCase(palabra.trim())) {
                
                listaPalabras.remove(i);
                return true;
            }
        }
        return false;
    }
    
}