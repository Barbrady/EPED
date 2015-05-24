import Biblioteca.Pilas.*;
import Biblioteca.Listas.*;

/**
 * Write a description of class EjerciciosPilas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjerciciosPilas
{
    // instance variables - replace the example below with your own
    private StackIF<Object> pila;
    private StackIF<Object> pila2;
    private StackIF<Object> pila3;
    
    private StackIF<Integer> pilaN;
    private StackIF<Integer> pilaN2;
    private StackIF<Integer> pilaN3;
    
    private ListIF<Integer> lista;
    /**
     * Constructor for objects of class EjerciciosPilas
     */
    public EjerciciosPilas()
    {
        // initialise instance variables
        pila = new StackDynamic<>();
        pila.push(new Character ('a'));
        pila.push(new Character ('b'));
        pila.push(new Character ('c'));
        pila.push(new Character ('d'));
        pila.push(new Character ('e'));
        pila.push(new Character ('x'));
        pila.push(new Character ('f'));
        pila.push(new Character ('g'));
        
        pila2 = new StackDynamic<>(pila);
        //ila2.push(new Character ('x'));
        //pila2.push(new Character ('x'));
        
        lista = new ListDynamic<>();
        //lista.insert(new Character ('a'));
        //lista.insert(new Character ('b'));
        Object o = new Character('x');
        
        pilaN = new StackDynamic<>();
        pilaN.push(new Integer (1));
        pilaN.push(new Integer (8));
        pilaN.push(new Integer (5));
        pilaN.push(new Integer (9));
        pilaN.push(new Integer (2));
        pilaN.push(new Integer (3));
        pilaN.push(new Integer (6));
        pilaN.push(new Integer (3));
        pilaN.push(new Integer (7));
        
        Integer i = new Integer(5);
        
        pilaN2 = new StackDynamic<>(pilaN);
        pilaN3 = mayores(pilaN,i,lista);
        
        
        
        
        
        
    }
    
    /**
     * I. Longitud de una pila
     * Diseñe una función que calcule el número de elementos que contiene una pila
     */
    public int elementosPila(StackIF<Object> p)
    {
        if(p == null) return 0;
        
        int i=0;
        while(!p.isEmpty())  {
            i++;
            p.pop();
        }
        return i;
    }
    
    /**
     * II. Pasar a lista
     * Devolver una lista con los elementos de una pila según aparecen en ésta desde la cima hasta la base
     */
    public ListIF<Object> pasarLista (StackIF<Object> p, ListIF<Object> l)
    {
        while(!p.isEmpty())  {
            l.insert(p.getTop());
            p.pop();
        }
        return l;
    }
    
    /**
     * III. Subpila
     * Diseñe una función que dada una lista determine si ésta está contenida en una pila como subpila
     */
    public boolean esSubpila(StackIF<Object> p, ListIF<Object> l)
    {
        boolean match = false;
        StackIF<Object> pAux = new StackDynamic<>(p);
        while(!l.isEmpty())  {
            match = false;
            Object o = l.getFirst();
            while(!p.isEmpty())  {
                if(o.equals(p.getTop()))  {
                    match = true;
                }
                p.pop();
            }
            p = pAux;
            if(!match)  {
                return false;
            }
            l = l.getTail();
        }
        return match;
    }     
    
    /**
     * IV. Elemento base
     * Diseñe una función que devuelva el elemento base de una pila
     */
    public Object elementoBase(StackIF<Object> p)
    {
        Object o = new Character('@');
        while(!p.isEmpty())  {
            o = p.getTop();
            p.pop();
        }
        return o;
    }
    
    /**
     * V. Insertar en la base
     * Diseñe una función que inserte un dato como elemento en la base de una pila
     */
    public StackIF<Object> inserBase(StackIF<Object> p, Object o)
    {
        StackIF<Object> pAux = new StackDynamic<>();
        
        while(!p.isEmpty())  {
            pAux.push(p.getTop());
            p.pop();
        }
        pAux.push(o);
        return pAux;
    }
    
    /**
     * VI. Concatenar dos pilas
     * Diseñe una función recursiva que devuelva la pila resultante de concatenar dos pilas
     */
    public StackIF<Object> concatenar (StackIF<Object> p1, StackIF<Object> p2) 
    {
        if(p1.isEmpty())  {
            return p2;
        }
        else  {
            p2.push(p1.getTop());
            return concatenar(p1.pop(),p2);
        }
    }
    
    /**
     * VII. Diseñe una función recursiva que devuelva una pila con los elementos colocados de forma inversa a otra
     */
    public StackIF<Object> invertir(StackIF<Object> p1, StackIF<Object> p2)
    {
        if(p1.isEmpty())  {
            return p2;
        }
        else  {
            p2.push(p1.getTop());
            return invertir(p1.pop(),p2);
        }
    }
    
    /**
     * VIII. Diseñe una función que devuelva una pila que elimine la primera aparición de un elemento
     */
    public StackIF<Object> erase (StackIF<Object> p, Object o)
    {
        ListIF<Object> listaAux = new ListDynamic<>();
        StackIF<Object> pAux = new StackDynamic<>();
        boolean match = false;
        while(!p.isEmpty())  {
            if(p.getTop().equals(o) && !match)  {
                match = true;
            }
            else {
                listaAux.insert(p.getTop());
            }
            p.pop();
        }    
        while(!listaAux.isEmpty())  {
            pAux.push(listaAux.getFirst());
            listaAux = listaAux.getTail();
        }
        return pAux;       
    }
    
    /**
     * IX. Diseñe una función que devuelva una pila donde se hayan eliminado todas las apariciones de un elemento
     */
    public StackIF<Object> eraseAll (StackIF<Object> p, Object o)
    {
        ListIF<Object> listaAux = new ListDynamic<>();
        StackIF<Object> pAux = new StackDynamic<>();
        while(!p.isEmpty())  {
            if(!p.getTop().equals(o))  {
                listaAux.insert(p.getTop());
            }
            p.pop();
        }    
        while(!listaAux.isEmpty())  {
            pAux.push(listaAux.getFirst());
            listaAux = listaAux.getTail();
        }
        return pAux;       
    }
    
    /**
     * X. Diseñe una función que devuela una pila con los elementos que preceden a un elemento dado
     */
    public StackIF<Object> prefijo (StackIF<Object> p, Object o)
    {
        ListIF<Object> listaAux = new ListDynamic<>();
        StackIF<Object> pAux = new StackDynamic<>();
        boolean match = false;
        while(!p.isEmpty() && !match)  {
            if(p.getTop().equals(o))  {
                match = true;
            }
            else  {
                listaAux.insert(p.getTop());
            }
            p.pop();
        }    
        while(!listaAux.isEmpty())  {
            pAux.push(listaAux.getFirst());
            listaAux = listaAux.getTail();
        }
        return pAux;
    }
    
    /**
     * XI. Diseñe una función que devuelva la pila conlos elementos que suceden a un elemento dado
     */
    public StackIF<Object> sufijo (StackIF<Object> p, Object o)
    {
        ListIF<Object> listaAux = new ListDynamic<>();
        StackIF<Object> pAux = new StackDynamic<>();
        boolean match = false;
        while(!p.isEmpty())  {
            if(match)  {
                listaAux.insert(p.getTop());
            }
            
            if(p.getTop().equals(o))  {
                match = true;
            }
            p.pop();
        }    
        while(!listaAux.isEmpty())  {
            pAux.push(listaAux.getFirst());
            listaAux = listaAux.getTail();
        }
        return pAux;
    }
    
    /**
     * XII. Diseñe una función recursiva que devuelva una pila con todos los elemtnos mayores a uno dado
     */
    public StackIF<Integer> mayores(StackIF<Integer> p, Integer o, ListIF<Integer> l)  
    {
        if(p.isEmpty())  {
            while(!l.isEmpty())  {
                p.push(l.getFirst());
                l = l.getTail();
            }
            return p;
        }
        else  {
            if(p.getTop()>o)  {
                l.insert(p.getTop());
                return mayores(p.pop(),o,l);
            }
            else  {
                return mayores(p.pop(),o,l);
            }
        }
    }
        
              
        
            
            
            
            
            
            
            
            

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
