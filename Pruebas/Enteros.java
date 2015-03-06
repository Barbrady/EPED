
/**
 * Write a description of class Enteros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enteros
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Enteros
     */
    public Enteros()
    {
        // initialise instance variables
        x = 0;
    }
    
    public Enteros(int i)
    {
        x = i;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setEntero(int i)
    {
        // put your code here
        x = i;
    }
    
    public void sumaEntero (int i)
    {
        x = x+i;
    }
    
    public int getEntero ()
    {
        return x;
    }
    
    public void mostrar()
    {
        System.out.println("" + x);
    }
}
