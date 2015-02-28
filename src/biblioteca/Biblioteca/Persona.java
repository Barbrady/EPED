package Biblioteca;
/**
 * Write a description of class Persona here.
 * 
 * @author (Aitor Alcorta) 
 * @version (0.1)
 */
public class Persona
{
    // instance variables - replace the example below with your own
    private int edad;
    private String nombre;
    private int ref;
    private static int referencia = 0;

    /**
     * Constructor for objects of class Persona
     */
    public Persona()
    {
        // initialise instance variables
        ref = referencia;
        referencia++;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Persona (String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
        referencia++;
        ref = referencia;
    }
    
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setEdad (int edad)
    {
        this.edad = edad;
    }
    
    public void getDatos()
    {
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("Referencia: "+ ref);
    }
}
