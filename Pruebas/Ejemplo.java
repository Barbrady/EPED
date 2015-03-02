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
    private Persona Aitor, Noelia, Maya;
    private Animal animal;
    private ListDynamic<Persona> personas;
    private Persona p;
    /**
     * Constructor for objects of class Ejemplo
     */
    public Ejemplo()
    {
        personas = new ListDynamic<Persona> ();
        // initialise instance variables
        Aitor = new Persona("Aitor",35);
        personas.insert(Aitor);
        Noelia = new Persona("Noelia",32);
        personas.insert(Noelia);
        Maya = new Persona("Maya",2);
        personas.insert(Maya);
        animal = new Animal("Perro","Cis");
        
    }
    
    public void Informacion()
    {
        //Aitor.getDatos();
        IteratorIF<Persona> itr = personas.getIterator();
        while(itr.hasNext()){
            p = itr.getNext();
            p.getDatos();
        }
        if(!personas.contains(Aitor)) 
            System.out.println("Aitor es una persona.");
            else
            System.out.println("No es un animal");
            
    }
  
}
