import Biblioteca.Clases.*;
import Biblioteca.Pilas.*;
import Biblioteca.Listas.*;

/**
 * Write a description of class PruebasPilas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebasPilas
{
    // instance variables - replace the example below with your own
    private Persona Aitor, Noelia, Maya, Mikel, Adrian, Miguel;
    private StackDynamic<Persona> pila1;
    private ListDynamic<Persona> lista1, lista2;
    /**
     * Constructor for objects of class PruebasPilas
     */
    public PruebasPilas()
    {
        // Incializo objetos persona
        Aitor = new Persona("Aitor",35);
        Noelia = new Persona("Noelia",32);
        Maya = new Persona("Maya",2);
        Mikel = new Persona("Mikel",0);
        Adrian = new Persona("Adrian",27);
        Miguel = new Persona("Miguel",27);
        pila1 = new StackDynamic<> ();
        lista1 = new ListDynamic<> ();
        
        pila1.push(Aitor);
        pila1.push(Noelia);
        pila1.push(Maya);
        pila1.push(Mikel);
        
        //int i = CalcularNumero(pila1);
        //System.out.println("El número de elementos es: "+i);
        lista1 = PasarPilaaLista(pila1);
        
    }

    //CALCULA NUMERO DE ELEMENTOS DE UNA PILA
    public int CalcularNumero(StackDynamic pila)
    {
        if(pila.isEmpty())
        {
            return 0;
        }
        else
        {
            return 1+(CalcularNumero ((StackDynamic)pila.pop()));
        }
    }
    
    public ListDynamic PasarPilaaLista (StackDynamic<Persona> pila)
    {
        ListDynamic<Persona> l = new ListDynamic<> ();
        
        while(!pila.isEmpty())  {
            l.insert(pila.getTop());
            pila.pop();
        }
        return (ListDynamic) l;
    }
    }

