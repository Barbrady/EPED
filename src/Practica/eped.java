/**
 * Write a description of class eped2015 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class eped
{
    private static String tipo, file, prefix;
    
    public static void main (String [ ] args) {
        tipo = args[0];
        file = args[1];
        prefix = args[2];
        new Controlador(tipo,file,prefix);
    }
    
    /**
     * Constructor for objects of class eped2015
     */
    public eped()
    {
        
    }
}
