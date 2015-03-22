import Biblioteca.Listas.*;
import Biblioteca.Clases.*;
import Biblioteca.Iterator.*;

/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebasListas
{
    // instance variables - replace the example below with your own
    private Persona Aitor, Noelia, Maya, Mikel, Adrian, Miguel;
    private Animal animal;
    private ListDynamic<Persona> personas1, personas2, personas3;
    private Persona p;
    /**
     * Constructor for objects of class Ejemplo
     */
    public PruebasListas()
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
        Miguel = new Persona("Miguel",27);
        
        //personas2 = new ListDynamic<Persona> (personas1);
        
        //personas2.insert(Adrian);
        //personas2.insert(Miguel);
        //insertarPersonaUltima(personas1, Adrian);
        //personas3 = new ListDynamic<Persona>();
        //personas3 = ConcatenarListas(personas1, personas2);
        //personas3 = new ListDynamic<Persona>();
        //personas1 = (ListDynamic) invertirLista(personas1,personas3);
        p = UltimoElemento(personas1);
    
        
    }
    
    public void Informacion()
    {
        //Aitor.getDatos();
        /**IteratorIF<Persona> itr = personas1.getIterator();
        while(itr.hasNext()){
            p = itr.getNext();
            //p.getDatos();
            System.out.println("" + p.toString());
        }
        System.out.println("El numero de objetos en lista es: "+ nElementos(personas1));
         **/
        Persona persona = ultimaPersona(personas1);
        System.out.println("La ultima perona es:" + persona.toString());
            
    }
    

    
    //LONGITUD Nº1
    public int nElementos (ListIF lista)
    {
        if(!lista.isEmpty())  {
            return 1 + (nElementos(lista.getTail()));
        }
        return 0;
    }
    
    //COMPARAR DOS LISTAS Nº2
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
        
    //COMPROBAR SI ES SUBLISTA Nº3
    public void ListaEsSublista()
    {
        if(subLista(personas1,personas2) ) {
            System.out.println("Es sublista.");
        }
        else{
            System.out.println("No es sublista.");
        }
    }
    
    //Métodos para comprobar si una lista dada es una sublista de otra
    public void SubListaN()
    {
        ListDynamic<Integer> l1 = new ListDynamic<>();
        ListDynamic<Integer> l2 = new ListDynamic<>();
        
        l1.insert(new Integer(0));
        l1.insert(new Integer(1));
        l1.insert(new Integer(0));
        l1.insert(new Integer(2));
        l1.insert(new Integer(3));
        l1.insert(new Integer(2));
        l1.insert(new Integer(3));
        
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
           
           if(l2.isEmpty())  {
               return true;
            }
           
           if(l1.getFirst().equals(l2.getFirst()))  {
               l1 = l1.getTail();
               l2 = l2.getTail();
            }
           else  {
               l2 = new ListDynamic<>(lista);
               if(!l1.getFirst().equals(lista.getFirst()))  {
                   l1 = l1.getTail();
                }
            }
        }
       return match;
    }
    
    
    //ULTIMO ELEMENTO Nº4
    //Método que devuele el útimo elemento de una lista, en este caso de tipo persona.
    public Persona ultimaPersona(ListIF<Persona> lista)  {
        if(lista.getTail().isEmpty()) {
            return lista.getFirst();
        }
        else  {
            return ultimaPersona(lista.getTail());
        }
    }
    
    //INSERTAR ELEMENTO AL FINAL DE LA LISTA Nº5
    public void insertarPersonaUltima(ListIF lista, Persona p)
    {
        if(lista.isEmpty())  {
            lista.insert(p);
        }
        else{
            insertarPersonaUltima(lista.getTail(),p);
        }
    }
    
    
    //CONCATENAR DOS LISTAS Nº6
    public ListDynamic ConcatenarListas (ListIF l1, ListIF l2)
    {
        if(l2.isEmpty())  {
            return new ListDynamic<Persona>(l1);
        }
        else{
            l1.insert(l2.getFirst());
            return ConcatenarListas(l1,l2.getTail());
        }
            
        
    }
    
    
    
    //LISTA INVERSA Nº7   ---- ERROR
    public ListIF invertirLista (ListIF l1, ListIF l2)
    {
        if(l1.getTail().isEmpty())  {
            return l2.insert(l1.getFirst());
        }
        else
        {
            return l2.insert(invertirLista(l1.getTail(),l2));
        }
    }
            
    
    //ULTIMO ELEMENTO DE UNA LISTA --REPETIDO DEL 4
    public Persona UltimoElemento(ListIF l1)
    {
        if(l1.getTail().isEmpty())  {
            return (Persona) l1.getFirst();
        }
        else
        {
            return UltimoElemento(l1.getTail());
        }
    }
    
    //BORRAR UN ELEMENTO DADO (PERSONA EN ESTE CASO) DEVUELVE UNA LISTA
    public ListDynamic<Persona> BorrarElemento (Persona p, ListDynamic l)
    {
        if(l.getTail().getFirst().equals(p))  {
            //l.getTail() = l.getTail().getTail();
            return l;
        }
        else {
            return null; //BorrarElemento(l.getTail(),p);
        }
    }
            
    
    
    
    
    
    
}
