import Biblioteca.Arboles.*;
import Biblioteca.Listas.*;
import Biblioteca.Iterator.*;


/**
 * Clase implementadora de QueryDepot y que desarrolla la práctica usando árboles generales dinámicos.
 * 
 * @author (Aitor Alkorta Puente) 
 * @version (1.0)
 */
public class QueryDepotTree implements QueryDepot
{
    // Declaración de variables de instancia
    private TreeIF<Object> consultas;

    /**
     * Constructor para objetos de la clase QueryDepotTree
     */
    public QueryDepotTree()
    {
        // Inicio variables de instancia y se asigna valor char(0) a la raiz del árbol
        Character nodo = 0;
        consultas = new TreeDynamic<Object> (nodo);
    }
    
    @Override
    /**
     * Devuelve el núemero de consultas diferentes del depósito
     * @return el número de consultas diferentes almacenadas
     */
    public int numQueries ()
    {
        int n=0;
        n = numeroConsultas(consultas,n);
        return n;
    }
    
    @Override
    /**
     * Consulta la frecuencia de una consulta en el depósito.
     * @return la frecuencia de la consulta. Si no está, devuelve 0.
     * @param el texto de la consulta
     */
    public int getFreqQuery (String q)
    {
       TreeIF<Object> arbol = obtenerArbol(q);
       if(arbol == null)  return 0;
       
       ListIF<TreeIF<Object>> hijos = arbol.getChildren();
       while(!hijos.isEmpty())  {
           Object o = hijos.getFirst().getRoot();
           if(o instanceof Integer)  {
               return (int) o;
           }
           hijos = hijos.getTail();
        }
       return 0; 
    }
    
    @Override
    /**
     * Devuelve una lista ordenada de mayor a menor, de todas la consultas almacenadas en
     * el depósito que comiencen por un prefijo dado.
     * @param el prefijo.
     * @return lista de consultas ordenada por frecuencia y orden lexicográfico en caso de
     * coincidencia de frecuencia.
     * 
     */
    public ListIF<Query> listOfQueries (String prefix)
    {
        TreeIF<Object> arbol = obtenerArbol(prefix);
        ListIF<Query> lista = new ListDynamic<Query>();
        if (arbol == null) return new ListDynamic<Query>();
        lista = generarConsultas(arbol, prefix, lista);
        lista = lista.sort(new ComparatorText()).sort(new ComparatorFreq());
        return lista;
    }
    
    @Override
    /**
     * Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existe, se añade
     * @param el String de la consulta
     */
    public void incFreqQuery (String q)
    {
            insertQuery(consultas,q);
    }
    
    @Override
    /**
     * Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia a decrementar fuera 1, se eliminará rama que contiene dicha consulta.
     * @param el texto de la consulta
     */
    public void decFreqQuery (String q)
    {
        int i = 0;
        decfQuery(consultas,q,i);
    }
    
    
    /**
     * Método privado y recursivo que decrementa la frecuencia de una consulta o la elimina si fuera 1
     * @param el arbol, un String y un entero que indicará el nodo a eliminar
     * 
     */
    private void decfQuery (TreeIF<Object> arbol, String q, int i)  
    {
        ListIF<TreeIF<Object>> hijos = arbol.getChildren();
        i++;
        while(!hijos.isEmpty())  {
            TreeIF<Object> subArbol = hijos.getFirst();
            if(subArbol.getRoot() instanceof Integer)  {
                if(subArbol.getRoot().equals(1))  {
                    consultas.removeChild(i);
                }
                else  {
                    subArbol.setRoot((Integer) subArbol.getRoot() - 1);
                }
            }
            else  {
                if(subArbol.isLeaf())  {
                    consultas.removeChild(i);
                }
                else{
                    if(subArbol.getRoot().equals(q.charAt(0)))  {
                        decfQuery(subArbol,q.substring(1),i);
                    }
                }
            }
            hijos = hijos.getTail();
            i++;
        }       
    }
    
    /**
     * Método privado y recursivo que devuelve un entero con el número de consultas insertadas en el árbol
     * @param el arbol a consultas y un entero donde se guarda el número de consultas
     * @return el número de consultas individuales del árbol
     */
    private int numeroConsultas (TreeIF<Object> arbol, int i)  
    {
        ListIF<TreeIF<Object>> hijos = arbol.getChildren();
        while(!hijos.isEmpty())  {
            TreeIF<Object> subArbol = hijos.getFirst();
            if(subArbol.getRoot() instanceof Integer)  {
                i++;
            }
            else  {
                i = numeroConsultas (subArbol,i);
            }
            hijos = hijos.getTail();
        }
        return i;
    }
             

    /**
     * Método privado que inserta, de manera recursiva, un String en un arbol.
     * Conforme baja de nivel, comprueba si ya existe el caracter en el árbol.
     * Al finalizar, si el String ya se encontraba insertado, aumenta la frecuencia en 1.
     * @param el arbol donde insertar el String y el propio String.
     */
    private void insertQuery (TreeIF<Object> arbol, String q)
    {
        ListIF<TreeIF<Object>> hijos = arbol.getChildren();
        boolean match = false;
        if(q.isEmpty())  {
            while(!hijos.isEmpty() && !match)  {
                if(hijos.getFirst().isLeaf())  {
                    Integer n = (Integer) hijos.getFirst().getRoot();
                    hijos.getFirst().setRoot(n+1);
                    match = true;
                }
                else  {
                    hijos = hijos.getTail();
                }
            }
            if(!match)  {
                    TreeIF<Object> arbolFrec = new TreeDynamic<Object>(new Integer(1));
                    arbol.addChild(arbolFrec);
            }
        }
        else  {
            while(!hijos.isEmpty() && !match)  {
                if(hijos.getFirst().getRoot().equals(q.charAt(0)))  {
                    match = true;
                    q = q.substring(1);
                    insertQuery(hijos.getFirst(),q);
                }
                else  {
                    hijos = hijos.getTail();
                }
            }
            if(hijos.isEmpty() || !match)  {
                TreeIF<Object> arbolChar = new TreeDynamic<Object>(new Character(q.charAt(0)));
                arbol.addChild(arbolChar);
                q = q.substring(1);
                insertQuery(arbolChar,q);
            }
        }     
    }
   
    /**
     * Método privado que devuelve un arbol del que cuelga un String determinado
     * Si no existe el String, se devuelve null.
     */
    private TreeIF<Object> obtenerArbol (String q)  {
        TreeIF<Object> arbol = consultas;       
        while(!q.isEmpty())  {
            boolean match = false;
            ListIF<TreeIF<Object>> hijos = arbol.getChildren();
            IteratorIF<TreeIF<Object>> itr = hijos.getIterator();
            while(itr.hasNext() && !match)  {
                TreeIF<Object> arbolAux = itr.getNext();
                if(arbolAux.getRoot().equals(q.charAt(0)))  {
                    match = true;
                    q = q.substring(1);
                    arbol = arbolAux;
                }
            }
            if(q.isEmpty())  {
                return arbol;
            }
            if(!match)  {
                return null;
            }
        }
        return null;
    }
    
    /**
     * Método privado y recursivo que devuelve una lista de consultas que coinciden con un prefijo pasado
     * @param un arbol a examinar, un String y una lista donde insertar las consultas
     * @return la lista con las consultas
     */
    private ListIF<Query> generarConsultas (TreeIF<Object> arbol, String q, ListIF<Query> lista)  {
        ListIF<TreeIF<Object>> hijos = arbol.getChildren();
        if(arbol.isLeaf())  {
            Query consulta = new Query(q);
            consulta.setFreq ((int)arbol.getRoot());
            return lista.insert(consulta);
        }
        else  {
            while(!hijos.isEmpty())  {
                TreeIF<Object> subArbol = hijos.getFirst();
                if(subArbol.isLeaf())  {
                    Query consulta = new Query(q);
                    consulta.setFreq ((int)subArbol.getRoot());
                    lista.insert(consulta);
                }
                else {
                    String s = subArbol.getRoot().toString();
                    generarConsultas(subArbol,q.concat(s),lista);
                }
                hijos = hijos.getTail();
            }
        }
        return lista;
    } 
}
        
    
    
    
    
    
    
    
    
    

