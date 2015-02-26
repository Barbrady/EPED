
/**
 * Write a description of class Ejemplo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejemplo1
{
    // instance variables - replace the example below with your own
    private EjemploPila pila;

    /**
     * Constructor for objects of class Ejemplo1
     */
    public Ejemplo1()
    {
        // initialise instance variables
        pila = new EjemploPila(10);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        pila.Introducir(5);
        pila.Sacar();
        return 0;
    }
}
