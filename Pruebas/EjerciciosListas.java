import Biblioteca.Listas.*;
/**
 * Write a description of class EjerciciosListas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjerciciosListas
{
    // instance variables - replace the example below with your own
    ListIF<Character> lista;
    ListIF<Integer> lista2, lista3;
    
    Character a;
    /**
     * Constructor for objects of class EjerciciosListas
     */
    public EjerciciosListas()
    {
        // initialise instance variables
        lista = new ListDynamic<> ();
        lista.insert(new Character('a'));
        lista.insert(new Character('b'));
        lista.insert(new Character('c'));
        lista.insert(new Character('d'));
        lista.insert(new Character('e'));
        lista.insert(new Character('f'));
        lista.insert(new Character('g'));
        lista.insert(new Character('h'));
        lista.insert(new Character('i'));
        lista.insert(new Character('j'));
        lista.insert(new Character('k'));
        lista.insert(new Character('l'));
        lista.insert(new Character('m'));
        lista.insert(new Character('n'));
        
        
        lista2 = new ListDynamic<> ();
        lista2.insert(new Integer(1));
        lista2.insert(new Integer(2));
        lista2.insert(new Integer(3));
        
        /**
        System.out.println("La lista tiene "+longitudLista(lista)+" elementos.");
        if(comparaListas(lista,lista2))  {
            System.out.println("Las listas son iguales.");
        }
        else  {
            System.out.println("Las listas son diferentes.");
        }
        
        if(esSublista(lista,lista2))  {
            System.out.println("lista1 es subLista de lista2.");
        }
        else  {
            System.out.println("lista1 NO es subLista de lista2.");
        }
        Object o1 = new Character('q');
        insertFinal(lista,o1);
        
        Object o2 = ultimoElemento(lista);
        System.out.println("El ultimo elemento es: "+o2);
        **/
        
        lista3 = getReverse(lista2);
    }

    /**
     * I. Longitud de la lista
     * Diseñe una función recursiva que calcule el número de elemntos que contiene una lista
     */
    public int longitudLista (ListIF<Object> l)
    {
        if(l.isEmpty())  {
            return 0;
        }
        else
        {
            return 1+longitudLista(l.getTail());
        }
    }
    
    /**
     * II. Comparar dos listas
     * Diseñe una función recursiva quecompare lexicográficamente 2 listas de caracteres.
     */
    public boolean comparaListas(ListIF<Object> l1, ListIF<Object> l2)  {
        if(l1 == null || l2 == null)  {
            return false;
        }
        
        if(l1.isEmpty() && l2.isEmpty())  {
            return true;
        }
        else {
            if(l1.getFirst().equals(l2.getFirst()))  {
                return comparaListas(l1.getTail(),l2.getTail());
            }
            else  {
                return false;
            }
        }
        
    }
    
    /**
     * III. Sublista
     * Diseñe una función que dad una lista determine si unalista es sublista de otra dad de mayor tamaño
     */
    public boolean esSublista(ListIF<Object> l1, ListIF<Object> l2) 
    {
        ListIF<Object> lista = new ListDynamic<Object>(l2);
        if(l1 == null || l2 == null)  {
            return false;
        }
        boolean match = false;
        
        while(!l1.isEmpty())  {
            Object o = l1.getFirst();
            match = false;
            while(!lista.isEmpty())  {
                if(lista.getFirst().equals(o))  {
                    match = true;
                }
                lista = lista.getTail();
            }
            if(!match)  {
                return false;
            }
            lista = l2;
            l1 = l1.getTail();
        }
        return match;
    }
    
    /**
     * IV. Último elemento
     * Diseñe una función recursiva que devuelve el último elemento de una lista
     */
    public Object ultimoElemento(ListIF<Object> l1)  
    {
        if(l1.getTail().isEmpty())  {
            return l1.getFirst();
        }
        else  {
            return ultimoElemento(l1.getTail());
        }
    }
    
    /**
     * V. Insertar al final
     * Diseñe una función recursiva que inserte un dato como último elemento de una lista
     */
    public ListIF<Object> insertFinal(ListIF<Object> l1, Object o) 
    {
        if(l1.isEmpty())  {
            l1.insert(o);
            return l1;
        }
        else  {
            return insertFinal(l1.getTail(),o)         ;
        }
    }
    
    /**
     * VI. Concatenar dos listas
     * Diseñe una función recursiva que devuelve la lista resultante de concatenar dos listas
     */
    public ListIF<Object> concatenarListas (ListIF<Object> l1, ListIF<Object> l2)
    {
        if(l1.isEmpty())  {
            l1 = l2;
            //l1.getTail() = l2.getTail();
            return l1;
        }
        else  {
            return concatenarListas(l1.getTail(),l2).insert(l1.getFirst()) ;
        }
    }
    
    /**
     * VII. Lista inversa
     * Diseñe una función recursiva que devuelva una lista con los elementos colocados de forma inversa
     */
    public ListIF<Object> invierteLista (ListIF<Object> l)
    {
        if(l.isEmpty())  {
            return l;
        }
        else  {
            return l.insert(invierteLista(l.getTail()).getFirst());
        }
    }
    
    /**
     * VIII. Borrado de un elemento
     * Diseñe una función recursiva que devuelva una lista que elimine la primera aparición de un elemento
     */
    public ListIF<Object> erase (ListIF<Object> l, Object o)
    {
        if(l.getFirst().equals(o) ) {
            return l.getTail();
        }
        else
        {
            return erase(l.getTail(),o).insert(l.getFirst());
        }
    }
    
    /**
     * IX. Borrar todos
     * Diseñe una función que devuelva una lista donde se hayan eliminado todas las apariciones de un elemento
     */
    public ListIF<Object> eraseAll (ListIF<Object> l, Object o)  
    {
        if(o == null)  return l;
        ListIF<Object> l1 = new ListDynamic<>();
        
        while(!l.isEmpty())  {
            if(! (l.getFirst().equals(o))) {
                l1.insert(l.getFirst());
            }
            l = l.getTail();
        }
        return l1;
    }
    
    /**
     * X. Lista prefijo
     * Diseñe una función recursiva que devuelva una sublista prefijo que precede a un elemento dado
     */
    public ListIF<Object> prefijo (ListIF<Object> l, Object o)
    {
        if(l.getFirst().equals(o))  {
            return new ListDynamic<>();
        }
        else  {
            return prefijo(l.getTail(),o).insert(l.getFirst());
        }
    }
    
    /**
     * XI. Lista sufijo
     */
    public ListIF<Object> sufijo (ListIF<Object> l, Object o)
    {
        if(l.getFirst().equals(o))  {
            return l.getTail();
        }
        else  {
            return sufijo(l.getTail(),o);
        }
    }
    
    /**
     * XII. Lista mayores
     * Diseñe una función recursiva que devuelva una lista con todos los elementos mayores a uno dado
     */
    public ListIF<Integer> mayores (ListIF<Integer> l, ListIF<Integer> aux, Integer i)
    {
        if(i == null) return l;
        
        if(l.isEmpty())  {
            return l;
        }
        
        
        if(l.getFirst() > i)  {
            return aux = mayores(l.getTail(),aux,i).insert(l.getFirst());
        }
        else  {
            return mayores(l.getTail(),aux,i);
        }
    }
    
    
    
    
    public ListIF<Integer> getReverse(ListIF<Integer> lista)
    {
        return reverse(lista, new ListDynamic<Integer> ());
    }
    
    private ListIF<Integer> reverse (ListIF<Integer> lista1, ListIF<Integer> lista2)
    {
        if(lista1.isEmpty()) return lista2;
        
        else{
            lista2.insert(lista1.getFirst());
            lista1 = lista1.getTail();
            return reverse(lista1,lista2);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
