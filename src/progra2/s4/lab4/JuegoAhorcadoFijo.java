package progra2.s4.lab4;


public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{
    
    public JuegoAhorcadoFijo(String palabra){
        super();
        inicializarPalabraSecreta(palabra);
        
        if (figuraAhorcado == null || figuraAhorcado.isEmpty()) {
            figuraAhorcado = crearFiguraBase();
        }
        
    }

    public boolean verificarLetra(char letra) throws AhorcadoExceptions.EntradaInvalidaException{
        if (!Character.isLetter(letra)) {
            throw new AhorcadoExceptions.EntradaInvalidaException("Debe ingresar una letra.");
        }
        letra = Character.toUpperCase(letra);
        boolean contiene = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                contiene = true;
            }
        }
        if (contiene) {
            actualizarPalabraActual(letra);
        }
        return contiene;
    }
    
    public void actualizarPalabraActual(char letra){
        
        StringBuilder sb = new StringBuilder(palabraActual);
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            
            if (palabraSecreta.charAt(i) == letra) {
                sb.setCharAt(i, letra);
            }
        }
        palabraActual = sb.toString();
    }
    
    public boolean hasGanado() {
        return palabraActual != null && palabraActual.equals(palabraSecreta);
    }
    
    public void jugar() {
        throw new UnsupportedOperationException("Use la GUI para jugar (VentanaAhorcado).");
    }
    
    public void actualizarFigura(){}
    
}
