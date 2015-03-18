import Biblioteca.Listas.*;
import Biblioteca.Clases.*;
import Biblioteca.Iterator.*;

/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejemplo
{
    // instance variables - replace the example below with your own
    private Persona Aitor, Noelia, Maya, Mikel;
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
        Mikel = new Persona("Mikel",0);
        personas.insert(Mikel);
    
        
    }
    
    public void Informacion()
    {
        //Aitor.getDatos();
        IteratorIF<Persona> itr = personas.getIterator();
        while(itr.hasNext()){
            p = itr.getNext();
            //p.getDatos();
            System.out.println("" + p.toString());
        }
        System.out.println("El numero de objetos en lista es: "+ nElementos(personas));
            
    }
    
    /* Devuelve el número de elementos de una lista */
    public int nElementos (ListIF lista)
    {
        if(!lista.isEmpty())  {
            return 1 + (nElementos(lista.getTail()));
        }
        return 0;
    }
  
}
