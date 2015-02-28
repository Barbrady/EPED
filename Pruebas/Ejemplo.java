import Biblioteca.*;
/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejemplo
{
    // instance variables - replace the example below with your own
    private Persona Aitor;
    private Animal animal;
    /**
     * Constructor for objects of class Ejemplo
     */
    public Ejemplo()
    {
        // initialise instance variables
        Aitor = new Persona("Aitor",35);
        animal = new Animal("Perro","Cis");
    }
    
    public void Informacion()
    {
        //Aitor.getDatos();
        animal.getDatos();
    }
  
}
