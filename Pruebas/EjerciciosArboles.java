import Biblioteca.Arboles.*;
import Biblioteca.Iterator.*;
import Biblioteca.Listas.*;
import Biblioteca.Colas.*;
import Biblioteca.Pilas.*;

/**
 * Write a description of class EjerciciosArboles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjerciciosArboles
{
    private TreeIF<Object> arbol,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    private TreeIF<Integer> arbolN, arbolN2, arbolN3;
    private ListIF<Integer> lista;
    
    /**
     * Constructor for objects of class EjerciciosArboles
     */
    public EjerciciosArboles()
    {
       
        arbol = new TreeDynamic<>();
        arbol.setRoot(new Character('@'));
        a1 = new TreeDynamic<>();
        a1.setRoot(new Character('a'));
        a2 = new TreeDynamic<>();
        a2.setRoot(new Character('b'));
        a3 = new TreeDynamic<>();
        a3.setRoot(new Character('c'));
        a4 = new TreeDynamic<>();
        a4.setRoot(new Character('d'));
        a5 = new TreeDynamic<>();
        a5.setRoot(new Character('e'));
        a6 = new TreeDynamic<>();
        a6.setRoot(new Character('f'));
        a7 = new TreeDynamic<>();
        a7.setRoot(new Character('g'));
        a8 = new TreeDynamic<>();
        a8.setRoot(new Character('h'));
        a9 = new TreeDynamic<>();
        a9.setRoot(new Character('i'));
        a10 = new TreeDynamic<>();
        a10.setRoot(new Character('j'));
        a1.addChild(a4);
        a1.addChild(a5);
        a2.addChild(a6);
        a2.addChild(a7);
        a3.addChild(a8);
        a3.addChild(a9);
        arbol.addChild(a1);
        arbol.addChild(a2);
        arbol.addChild(a3);
        
        arbolN = arbolEnteros();
        lista = new ListDynamic<>();
        //lista = elementosPares(arbolN,lista);
        int i = 0;
        //System.out.println("La suma de elementos del árbol es: "+sumaElementos(arbolN,i));
        
        arbolN2 = new TreeDynamic<>();
        arbolN2.setRoot(new Integer(0));
        arbolN3 = eliminarImpares(arbolN,arbolN2);
    }

    /**
     * Método iterativo para contar los elementos de un arbol
     * 
     * @param el arbol de trabajo
     * @return int con el número de elementos 
     */
    public int numeroIterativo(TreeIF arbol)
    {
        // código
        int n = 0;
        IteratorIF itr = arbol.getIterator(0);
        while(itr.hasNext())  {
            n++;
            itr.getNext();
        }
        return n;
    }
       
    /**
     * Método iterativo para sumar el contenido "int" de los elementos
     * 
     * @param el arbol de trabajo
     * @return int con el número de la suma de los elementos 
     */
    public int sumaIterativo(TreeIF arbol)
    {
        // código
        int n = 0;
        IteratorIF<Integer> itr = arbol.getIterator(0);
        while(itr.hasNext())  {
            Integer i = itr.getNext();
            n=n+i;
        }
        return n;
    }
   
    /**
     * I. Diseñe una funcion que devuelva el número de elementos que contiene un árbol general
     */
    public int numeroElementos(TreeIF<Object> tree, int i)
    {
        ListIF<TreeIF<Object>> hijos = tree.getChildren();
        while(!hijos.isEmpty())  {
            TreeIF<Object> auxTree = hijos.getFirst();
            if(auxTree.isLeaf())  {
                i++;
            }
            else  {
                i = 1+numeroElementos(auxTree,i);

            }
            hijos = hijos.getTail();
        }
        return i;
    }
    
    /**
     * II. Diseñe una función que devuelve la suma de todos los elementos de un árbol general de enteros
     */
    public int sumaElementos(TreeIF<Integer> tree, int i)
    {
        ListIF<TreeIF<Integer>> hijos = tree.getChildren();
            while(!hijos.isEmpty())  {
                TreeIF<Integer> auxTree = hijos.getFirst();
                i = auxTree.getRoot()+sumaElementos(auxTree,i);
                hijos= hijos.getTail();
            }
        return i;
    }
    
    /**
     * III. Diseñe una función recursiva que devuelva una lista con todos los elementos pares de un árbols de enteros
     */
    public ListIF<Integer> elementosPares (TreeIF<Integer> arbol, ListIF<Integer> lista)  
    {
        ListIF<TreeIF<Integer>> hijos = arbol.getChildren();
        while(!hijos.isEmpty())  {
            if(hijos.getFirst().getRoot()%2 == 0)  {
                lista.insert(hijos.getFirst().getRoot());
                }
            
            if(!hijos.getFirst().isLeaf())  {
                lista = elementosPares(hijos.getFirst(),lista);
            }
            hijos = hijos.getTail();
        }
        return lista;
    }
    
    /**
     * IV. Diseñe una función recursiva que dadu un árbol de enteros devuelva otro árbol con los elementos pares
     */
    public TreeIF<Integer> eliminarImpares(TreeIF<Integer> arbol, TreeIF<Integer> arbol2)
    {
        ListIF<TreeIF<Integer>> hijos = arbol.getChildren();
        while(!hijos.isEmpty())  {
            if(hijos.getFirst().getRoot()%2 == 0)  {
                arbol2.addChild(hijos.getFirst());
            }
            if(!hijos.getFirst().isLeaf())  {
                eliminarImpares(hijos.getFirst(),arbol2);
            }
            hijos = hijos.getTail();
        }
        return arbol2;
    }
    
    /**
     * V. Diseñe una función dado un árbol de enteros que multiplique el valor en cada nodo por su altura
     */
    public void alturaArbol(TreeIF<Integer> arbol, int i)
    {
        ListIF<TreeIF<Integer>> hijos = arbol.getChildren();
        i++;
        while(!hijos.isEmpty())  {
            hijos.getFirst().setRoot(hijos.getFirst().getRoot()*i);
            if(!hijos.getFirst().isLeaf()) {
                alturaArbol(hijos.getFirst(),i);
            }
            hijos = hijos.getTail();
        }
    }
    
    /**
     * VI. Diseñe una función recursiva que determine si dos árboles generales son estructuralmente idénticos
     */
    public boolean comparacion (TreeIF<Integer> arbol, TreeIF<Integer> arbol2)
    {
        ListIF<TreeIF<Integer>> lista1 = arbol.getChildren();
        ListIF<TreeIF<Integer>> lista2 = arbol2.getChildren();
        boolean match = false;
        
        while(!lista.isEmpty())  {
            if(lista2.getFirst() == null)  {
                match = false;
            }
            
            if(!lista1.getFirst().isLeaf())  {
                match = comparacion (lista1.getFirst(),lista2.getFirst());
                if (!match)  return false;
            }
            lista1=lista1.getTail();
            lista2=lista2.getTail();
            if(lista1.isEmpty() && lista2.isEmpty())  {
                match = true;
            }
        }
        return match;
    }
    
    /**
     * VII. Diseñe una función recursiva que indique si dos árboles son la imagen especular el uno del otro
     */
    public boolean espejo (TreeIF<Object> arbol1, TreeIF<Object> arbol2)  
    {
        ListIF<TreeIF<Object>> hijos1 = arbol1.getChildren();
        ListIF<TreeIF<Object>> hijos2 = arbol2.getChildren();
        StackIF<TreeIF<Object>> pila = new StackDynamic<>();
        boolean match = false;
        while(!hijos2.isEmpty())  {
                pila.push(hijos1.getFirst());
        }
        
        while(!hijos1.isEmpty())  {
            if(!hijos1.getFirst().isLeaf())  {
                match = espejo (hijos1.getFirst(),pila.getTop());
            }
            else  {    
                if(hijos1.getFirst().getRoot().equals(pila.getTop()))  {
                    match = true;
                }
                if(!match)   {
                    return false;
                }
            hijos1 = hijos1.getTail();
            pila.pop();
            }
        }
        return match;
    }
    
       
    
                
                
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public TreeIF<Integer> arbolEnteros() 
    {
        TreeIF<Integer> ar,aN1,aN2,aN3,aN4,aN5,aN6,aN7,aN8,aN9,aN10;
        ar = new TreeDynamic<>();
        ar.setRoot(new Integer(0));
        aN1 = new TreeDynamic<>();
        aN1.setRoot(new Integer(1));
        aN2 = new TreeDynamic<>();
        aN2.setRoot(new Integer(2));
        aN3 = new TreeDynamic<>();
        aN3.setRoot(new Integer(3));
        aN4 = new TreeDynamic<>();
        aN4.setRoot(new Integer(4));
        aN5 = new TreeDynamic<>();
        aN5.setRoot(new Integer(5));
        aN6 = new TreeDynamic<>();
        aN6.setRoot(new Integer(6));
        aN7 = new TreeDynamic<>();
        aN7.setRoot(new Integer(7));
        aN8 = new TreeDynamic<>();
        aN8.setRoot(new Integer(8));
        aN9 = new TreeDynamic<>();
        aN9.setRoot(new Integer(9));
        aN10 = new TreeDynamic<>();
        aN10.setRoot(new Integer(10));
        aN1.addChild(aN4);
        aN1.addChild(aN5);
        aN2.addChild(aN6);
        aN2.addChild(aN7);
        aN3.addChild(aN8);
        aN3.addChild(aN9);
        ar.addChild(aN1);
        ar.addChild(aN2);
        ar.addChild(aN3);
        return ar;
    }
}            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

