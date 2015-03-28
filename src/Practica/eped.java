/**
 * Write a description of class eped2015 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class eped
{
    private static String file, prefix;
    public static void main (String [ ] args) {
        file = args[0];
        prefix = args[1];
        new Controlador(file,prefix);
    }
    
    /**
     * Constructor for objects of class eped2015
     */
    public eped()
    {
        
    }
}
