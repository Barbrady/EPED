
/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjemploPila
{
    // instance variables - replace the example below with your own
    private int[] pila;
    private int x;

    /**
     * Constructor for objects of class Ejemplo
     */
    public EjemploPila()
    {
        // initialise instance variables
        x = 0;
    }
    
    public EjemploPila(int dimension)
    {
        pila = new int[dimension];
    }
    
    public void Introducir(int numero)
    {
        pila[x] = numero;
        x++;
    }
    
    public void Sacar() 
    {
        x--;
        System.out.println("El número es: "+ pila[x]);
    }
}
