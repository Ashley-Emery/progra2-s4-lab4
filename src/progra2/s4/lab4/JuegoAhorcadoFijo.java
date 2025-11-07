package progra2.s4.lab4;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{
    
    public JuegoAhorcadoFijo(String palabra){
        super (6);
        inicializarPalabraSecreta(palabra);
    }

    @Override
    public boolean verificarLetra(char letra){
        return palabraSecreta.contains(String.valueOf(letra));
    }
    
    @Override
    public void actualizarPalabraActual(char letra){
        
        StringBuilder sb = new StringBuilder(palabraActual);
                
        for (int i = 0 ; i < palabraSecreta.length(); i ++){
            if (palabraSecreta.charAt(i) == letra){
                
                sb.setCharAt(i, letra); 
            }
        }
        palabraActual = sb.toString();
    }
    
    @Override
    public boolean hasGanado(){
        return !palabraActual.contains("");
    }
    
    @Override
    public void jugar(){
        
    }
    
}
