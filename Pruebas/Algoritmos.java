
/**
 * Write a description of class Algoritmos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Algoritmos
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Algoritmos
     */
    public Algoritmos()
    {

    }
    
    /* FACTORIAL */
    
    public void factorial(int i)
    {
        int factorial = calcularFactorial(i);
        System.out.println("El factorial de: " + i + " es: " + factorial);
    }
    
    private int calcularFactorial(int i)
    {
        if(i == 0) return 1;
        return i*calcularFactorial(i-1);
    }
    
    /* FIBONACCI */
    public void fibonacci(int i)
    {
        int fibonacci;
        for(int j=0; j<i; j++)
        {
            fibonacci = calcularFibonacci(j);
            System.out.println("" + fibonacci);
        }
    }
    
    private int calcularFibonacci(int i)
    {
        if(i == 0 || i==1) return 1;
        return calcularFibonacci(i-1) + calcularFibonacci(i-2);
    }
    
    /* POTENCIA */
    public void potencia(int i, int j)
    {
        int resultado = calcularPotencia(i,j);
        System.out.println("El numero " + i + " elevado a " + j + " es:" + resultado);
    }
    
    private int calcularPotencia(int i, int j)
    {
        if(j == 1) return i;
        return i*calcularPotencia(i,j-1);
    }
    
    /* SUMA N NUMEROS */
    public void suma(int n)
    {
        int resultado = calcularSuma(n);
        System.out.println("La suma de 1 a " + n + " es: " + resultado);
    }
    
    private int calcularSuma(int n)
    {
        if(n == 1) return 1;
        return n+calcularSuma(n-1);
    }
}
