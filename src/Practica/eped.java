/**
 * Archivo "main"  eped2015.
 * 
 * @author (Aitor Alkorta) 
 * @version (1.0)
 */

public class eped
{
    private static String tipo, consultas, operaciones;
    
    public static void main (String [ ] args) {
        tipo = args[0];
        consultas = args[1];
        operaciones = args[2];
        new Controlador(tipo,consultas,operaciones);
    }
    
    /**
     * Constructor for objects of class eped2015
     */
    public eped()
    {
        
    }
}
