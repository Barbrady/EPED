package Biblioteca.Clases;


/**
 * Write a description of class Caracter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caracter
{
    // instance variables - replace the example below with your own
    private char x;

    /**
     * Constructor for objects of class Caracter
     */
    public Caracter()
    {
        // initialise instance variables
        
    }
    
    public Caracter(char y)
    {
        x = y;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public char getCaracter()
    {
        // put your code here
        return x;
    }
    
    public void setCaracter(char y)
    {
        x = y;
    }
    
    public void imprimirCaracter()
    {
        System.out.println("" + x);
    }
        
}
