import Biblioteca.Colas.*;
import Biblioteca.Listas.*;
import Biblioteca.Pilas.*;

/**
 * Write a description of class EjerciciosColas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjerciciosColas
{
    // instance variables - replace the example below with your own
    private QueueIF<Object> cola;
    private QueueIF<Object> cola2;
    private QueueIF<Object> cola3;
    private QueueIF<Object> cola4;
    
    private QueueIF<Integer> colaN;
    private QueueIF<Integer> cola2N;
    private QueueIF<Integer> cola3N;
    
    private StackIF<Object> pila;
    private ListIF<Object> lista;
    /**
     * Constructor for objects of class EjerciciosColas
     */
    public EjerciciosColas()
    {
        // initialise instance variables
        cola = new QueueDynamic<>();
        cola.add(new Character('a'));
        cola.add(new Character('b'));
        cola.add(new Character('c'));
        cola.add(new Character('d'));
        cola.add(new Character('e'));
        cola.add(new Character('c'));
        cola.add(new Character('f'));
        cola.add(new Character('c'));
        //cola.add(new Character('x'));
        
        cola3 = new QueueDynamic<>(cola);
        
        //cola2 = new QueueDynamic<>();
        //cola2.add(new Character('x'));
        //cola2.add(new Character('y'));
        //cola2.add(new Character('z'));
        //cola2.add(new Character('c'));
        //cola2.add(new Character('d'));
        //cola2.add(new Character('e'));
        //cola2.add(new Character('f'));
        
        
        pila = new StackDynamic<>();
        /**
        pila.push(new Character('a'));
        pila.push(new Character('b'));
        pila.push(new Character('c'));
        pila.push(new Character('d'));
        pila.push(new Character('e'));
        pila.push(new Character('f'));
        **/
        
        colaN = new QueueDynamic<>();
        colaN.add(new Integer(1));
        colaN.add(new Integer(3));
        colaN.add(new Integer(9));
        colaN.add(new Integer(10));
        colaN.add(new Integer(15));
        colaN.add(new Integer(16));
        colaN.add(new Integer(27));
        colaN.add(new Integer(38));
        colaN.add(new Integer(90));
        
        
        /**
        lista = new ListDynamic<>();
        lista.insert(new Character('a'));
        lista.insert(new Character('b'));
        lista.insert(new Character('c'));
        lista.insert(new Character('d'));
        lista.insert(new Character('e'));
        lista.insert(new Character('f'));
        
        //cola2N = extraePosicionPar(colaN);
        
        //cola2 = new QueueDynamic<>(cola);
        //System.out.println("La cola tiene "+elementos(cola)+" elementos");
        //System.out.println("La cabeza de la lista es "+lista.getFirst());
        //lista = pasaraLista(cola);
        
        if(esSubcola(cola,cola2))  {
            System.out.println("cola es subcola de cola2");
        }
        else  {
            System.out.println("No es subcola.");
        }
        
        cola2N = new QueueDynamic<>();
        Integer i = new Integer(12);
        insertarOrden(colaN,i,cola2N);
        
        Object o = new Character('e');
        cola2 = sufijo(cola,o);
        **/
        cola2N = new QueueDynamic<>();
        Integer i = new Integer(12);
        cola3N = mayores(colaN,i,cola2N);
    }

    /**
     * I. Diseñe una función que calcule el número de elementos que contiene una cola
     */
    public int elementos(QueueIF<Object> c)
    {
        int i=0;
        while(!c.isEmpty())  {
            i++;
            c = c.remove();
        }
        return i;
    }
    
    /**
     * II. Devolver una lista con los elementos de una cola según aparecen en ésta desde el primero al ultimo
     */
    public ListIF<Object> pasaraLista (QueueIF<Object> c)
    {
        ListIF<Object> l = new ListDynamic<>();
        while(!c.isEmpty())  {
            l.insert(c.getFirst());
            c = c.remove();
        }
        return l;
    }
    
    /**
     * III. Diseñe una función que dada una cola determine si es subcola de otra dada de mayor tamaño
     */
    public boolean esSubcola (QueueIF<Object> c1, QueueIF<Object> c2)
    {
        QueueIF<Object> cAux = new QueueDynamic<> (c2);
        boolean match;
        while(!c1.isEmpty())  {
            match = false;
            Object o = c1.getFirst();
            while(!c2.isEmpty())  {
                if(c2.getFirst().equals(o))  {
                    match = true;
                }
                c2 = c2.remove();
            }
            if(!match)  {
                return false;
            }
            c2 = new QueueDynamic<>(cAux);
            c1 = c1.remove();
        }
        return true;
    }
    
    /**
     * IV. Función que extrae los números pares de una cola de enteros. 
     */
    public QueueIF<Integer> extraePares (QueueIF<Integer> c)
    {
        QueueIF<Integer> cAux = new QueueDynamic<>();
        while(!c.isEmpty())  {
            Integer i = c.getFirst();
            if(i%2 == 0)  {
                cAux.add(i);
            }
            c = c.remove();
        }
        return cAux;
    }
            
    /**
     * IV. Función que extrae los números de posición par en la cola. 
     */
    public QueueIF<Integer> extraePosicionPar (QueueIF<Integer> c)
    {
        QueueIF<Integer> cAux = new QueueDynamic<>();
        int i = 0;
        while(!c.isEmpty())  {
            //Integer i = c.getFirst();
            if(i%2 == 0)  {
                cAux.add(c.getFirst());
            }
            i++;
            c = c.remove();
        }
        return cAux;
    }    
    
    /**
     * V. Diseñe una función que inserte en una cola de enteros los elementos de forma ordenada crecientemente
     */
    public void insertarOrden (QueueIF<Integer> c1, Integer i, QueueIF<Integer> cAux)
    {
        //QueueIF<Integer> cAux = new QueueDynamic<>();
        
        while(!c1.isEmpty())  {
            Integer iAux = c1.getFirst();
            if(iAux<i)  {
                cAux.add(iAux);
            }
            else  {
                cAux.add(i);
                cAux.add(iAux);
            }
            c1 = c1.remove();
        }
        c1 = cAux;
    }
    
    /**
     * Diseñe una función recursiva que devuelve la cola resultante de concatenar dos colas
     */
    public QueueIF<Object> concatenar (QueueIF<Object> c1, QueueIF<Object> c2)
    {
        if(c1.isEmpty())  {
            return c2;
        }
        else {
            c2.add(c1.getFirst());
            return concatenar(c1.remove(),c2);
        }
    }
    
    /**
     * VII. Diseñe una función recursiva que devuelva una cola con los elementos colocados de forma inversa a otra
     */
    public QueueIF<Object> invertirCola (QueueIF<Object> c1, StackIF<Object> pila)
    {
        if(c1.isEmpty())  {
            while(!pila.isEmpty())  {
                c1.add(pila.getTop());
                pila.pop();
            }
            return c1;
        }
        else {
            pila.push(c1.getFirst());
            return invertirCola(c1.remove(),pila);
        }
    }
    
    /**
     * VIII. Diseñe una función que devuelva una cola que elimine la primera aparición de un elemento
     */
    public QueueIF<Object> erase (QueueIF<Object> c, Object o)
    {
        boolean match = false;
        QueueIF<Object> cAux = new QueueDynamic<>();
        while(!c.isEmpty())  {
            if(c.getFirst().equals(o) && !match)  {
                match = true;
            }
            else  {
                cAux.add(c.getFirst());
            }
            c = c.remove();
        }
        return cAux;
    }
    
    /**
     * IX. Diseñe una función que devuelva una cola donde se hayan eliminado todas las apariciones de un elemento
     */
    public QueueIF<Object> eraseAll (QueueIF<Object> c, Object o)
    {
        //boolean match = false;
        QueueIF<Object> cAux = new QueueDynamic<>();
        while(!c.isEmpty())  {
            if(!c.getFirst().equals(o))  {
                cAux.add(c.getFirst());
            }
            c = c.remove();
        }
        return cAux;
    }
            
    /**
     * X. Diseñe una función que devuelva una cola con los elementos que preceden a un elemento dado
     */        
    public QueueIF<Object> prefijo (QueueIF<Object> c, Object o)
    {
        QueueIF<Object> cAux = new QueueDynamic<>();
        boolean match = false;
        while(!c.isEmpty() && !match)  {
            if(c.getFirst().equals(o))  {
                match = true;
                //return cAux;
            }
            else  {
                cAux.add(c.getFirst());
                c=c.remove();
            }
        }
        return cAux;
    }
    
    /**
     * XI. Diseñe una función que devuelva la cola sufijo que sucede a un elemento dado
     */
    public QueueIF<Object> sufijo (QueueIF<Object> c, Object o)
    {
        QueueIF<Object> cAux = new QueueDynamic<>();
        boolean match = false;
        while(!c.isEmpty())  {            
            if(match)  {
                cAux.add(c.getFirst());
            }
            
            if(c.getFirst().equals(o) && !match)  {
                match = true;
            }                      
            c=c.remove();
        }
        return cAux;
    }
            
    /**
     * XII. Diseñe una función recursiva que devuelva una cola con todos los elementos mayores a uno dado
     */            
    public QueueIF<Integer> mayores (QueueIF<Integer> c, Integer i, QueueIF<Integer> c2)
    {
        if(c.isEmpty())  {
            return c2;
        }
        else  {
            if(c.getFirst()>i)  {
                c2.add(c.getFirst());
                return mayores(c.remove(),i,c2);
            }
            else  {
                return mayores(c.remove(),i,c2);
            }
        }
    }
        
                
            
            
            
            
            
}
