package progra2.s4.lab4;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{
    
    public JuegoAhorcadoFijo(String palabra){
        super (palabra);
    }

    protected boolean verificarLetra(){
        return palabraSecreta.contains(String.valueOf(letter));
    }
    
    protected void actualizarPalabraActual(char letra){
        for (int i = 0 ; i < palabraSecreta.length(); i ++){
            if (palabraSecreta.charAt(i) == letra){
                
                palabraActual.setCharAt(i, letra); 
            }
        }
    }
    
    public boolean hasGanado(){
        return !palabraActual.toString().contains("   ");
    }
    
    
}
