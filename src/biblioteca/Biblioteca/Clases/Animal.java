package Biblioteca.Clases;


/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal
{
    // instance variables - replace the example below with your own
    private String raza;
    private String nombre;

    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        // initialise instance variables
       
    }
    
    public Animal(String raza, String nombre)
    {
        this.raza = raza;
        this.nombre = nombre;
    }
    
    public void getDatos()
    {
        System.out.println("Raza: "+ raza + " .Nombre: " + nombre + ".");
    }
}
