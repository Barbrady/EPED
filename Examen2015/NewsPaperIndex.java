import Biblioteca.Arboles.*;
import Biblioteca.Listas.*;
import Biblioteca.Iterator.*;

/**
 * Write a description of class NewsPaperIndex here.
 * 
 * @author Aitor Alkorta 
 * @version 0.1
 */
public class NewsPaperIndex
{
    // instance variables - replace the example below with your own
    private TreeIF<Object> etiquetas;
    private int index;
    private ListIF<ArticuloIndex> articulos;

    /**
     * Constructor for objects of class NewsPaperIndex
     */
    public NewsPaperIndex()
    {
       articulos = null;
       etiquetas = null;
       index = -1;
    }
    
    public NewsPaperIndex(ListIF<Article> listaArticulos )
    {
       index = 0;
       articulos = new ListDynamic<>();
       Character nodo = new Character('@');
       etiquetas = new TreeDynamic<Object> (nodo);
       while(!listaArticulos.isEmpty())  {
           Article a = listaArticulos.getFirst();
           insertArticle(a.getContent(),a.getSection(), index);
           IteratorIF<String> itr = a.getTags().getIterator();
           while(itr.hasNext())  {
               String s = itr.getNext();
               insertTag(etiquetas, s, index);
           }
           listaArticulos = listaArticulos.getTail();
           index++;
        }
    }
    
    private void insertArticle(String contenido, String seccion, int i) 
    {
        ArticuloIndex a = new ArticuloIndex(contenido, seccion, i);
        this.articulos.insert(a);
    }
             
            
    private void insertTag(TreeIF arbol, String c, int i)  
    {
        ListIF<TreeIF<Object>> hijos = arbol.getChildren();
        boolean match = false;
        
        if(c.isEmpty())  {
            while(!hijos.isEmpty() && !match)  {
                if(hijos.getFirst().isLeaf())  {
                    ListIF<Integer> lista = (ListIF<Integer>) hijos.getFirst();
                    lista.insert(new Integer(i));
                    match = true;
                }
                else  {
                    hijos = hijos.getTail();
                }
            }
            if(!match)  {
                Integer integer = new Integer(i);
                ListIF<Integer> lista = new ListDynamic<>();
                lista.insert(integer);
                TreeIF<ListIF<Integer>> arbolAux = new TreeDynamic<>(lista);
                arbol.addChild(arbolAux);
            }
        }
        else  {
            while(!hijos.isEmpty() && !match)  {
                if(hijos.getFirst().getRoot().equals(c.charAt(0)))  {
                    match = true;
                    insertTag(hijos.getFirst(), c.substring(1), i);
                }
                else  {
                    hijos = hijos.getTail();
                }
            }
            if(!match)  {
                Character a = new Character (c.charAt(0));
                TreeIF<Object> arbolAux = new TreeDynamic<Object>(a);
                arbol.addChild(arbolAux);
                c = c.substring(1);
                insertTag(arbolAux, c, i);
            }
        }
    }
    
    
                     
   
}
