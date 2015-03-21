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
    private Persona Aitor, Noelia, Maya, Mikel, Adrian;
    private Animal animal;
    private ListDynamic<Persona> personas1, personas2;
    private Persona p;
    /**
     * Constructor for objects of class Ejemplo
     */
    public Ejemplo()
    {
        personas1 = new ListDynamic<Persona> ();
        // initialise instance variables
        Aitor = new Persona("Aitor",35);
        personas1.insert(Aitor);
        Noelia = new Persona("Noelia",32);
        personas1.insert(Noelia);
        Maya = new Persona("Maya",2);
        personas1.insert(Maya);
        Mikel = new Persona("Mikel",0);
        personas1.insert(Mikel);
        
        Adrian = new Persona("Adrian",27);
        
        personas2 = new ListDynamic<Persona> (personas1);
        
        personas2.insert(Adrian);
    
        
    }
    
    public void Informacion()
    {
        //Aitor.getDatos();
        IteratorIF<Persona> itr = personas1.getIterator();
        while(itr.hasNext()){
            p = itr.getNext();
            //p.getDatos();
            System.out.println("" + p.toString());
        }
        System.out.println("El numero de objetos en lista es: "+ nElementos(personas1));
            
    }
    
    /* Devuelve el número de elementos de una lista */
    public int nElementos (ListIF lista)
    {
        if(!lista.isEmpty())  {
            return 1 + (nElementos(lista.getTail()));
        }
        return 0;
    }
    
    public void comparaCaracteres()
    {
        ListDynamic<Character> l1 = new ListDynamic<Character>();
        ListDynamic<Character> l2 = new ListDynamic<Character>();
        Character c1 = new Character('a');
        Character c2 = new Character('b');
        l1.insert(c1);
        l2.insert(c2);
        System.out.println("" + l1.toString() + l2.toString()); 
        if(compararListaCarac(l1,l2)){ System.out.println("Son iguales.");}
        else {System.out.println("Son diferentes.");}
        
        
    }
    
    private boolean compararListaCarac(ListIF l1, ListIF l2)
    {
        if(l1.isEmpty() && l2.isEmpty()) return true;
        else{
            return l1.getFirst().equals(l2.getFirst()) && compararListaCarac(l1.getTail(), l2.getTail());
        }
    }
    
    public void ListaEsSublista()
    {
        if(subLista(personas1,personas2) ) {
            System.out.println("Es sublista.");
        }
        else{
            System.out.println("No es sublista.");
        }
    }
    
    public void SubListaN()
    {
        ListDynamic<Integer> l1 = new ListDynamic<>();
        ListDynamic<Integer> l2 = new ListDynamic<>();
        
        l1.insert(new Integer(0));
        l1.insert(new Integer(1));
        //l1.insert(new Integer(0));
        l1.insert(new Integer(2));
        l1.insert(new Integer(3));
        //l1.insert(new Integer(2));
        //l1.insert(new Integer(3));
        
        l2.insert(new Integer(0));
        l2.insert(new Integer(2));
        l2.insert(new Integer(3));
        
        if(subLista2(l1,l2) ) {
            System.out.println("Es sublista.");
        }
        else{
            System.out.println("No es sublista.");
        }
    }
    
    private boolean subLista(ListIF l1, ListIF l2)
    {
        if(l2.isEmpty()) return true;
        else{
            return(l1.contains(l2.getFirst()) && subLista(l1,l2.getTail()));  
        }
    }
    
    
 
    private boolean subLista2(ListIF l1, ListIF l2)
    {
       ListDynamic lista = new ListDynamic<> (l2);
       boolean match = false;
       while(l1.getLength() > l2.getLength())  {
           if(l1.getFirst().equals(l2.getFirst()))  {
               l1 = l1.getTail();
               l2 = l2.getTail();
            }
           else  {
               l1 = l1.getTail();
               l2 = lista;
               match = false;
            }
            
           if(l2.isEmpty())  {
               return true;
            }
        }
       return match;
    }
}
