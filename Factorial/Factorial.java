
/**
 * Write a description of class Factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factorial
{
    int n;
    int f;
    
    public Factorial() 
    {
        
    }
    
    /**
     * Constructor for objects of class Factorial
     */
    public Factorial(int n)
    {
        int resultado = CalcularFactorial(n);
        System.out.println("El factorial de: "+ n +" es: " + resultado);
    }

    public int CalcularFactorial(int f) 
    {
        if (f <= 1)
        {
            return 1;
        }
        else
        {
            return f*(CalcularFactorial(f-1));
        }
    }
}
