import Biblioteca.Listas.*;
import Biblioteca.Iterator.*;
import Biblioteca.Comparator.*;
/**
 * Clase implementadora de QueryDepot y que desarrolla la práctica usando listas dinámicas.
 * 
 * @author (Aitor Alkorta Puente) 
 * @version (1.0)
 */
public class QueryDepotList implements QueryDepot
{
    // Variables de instancia
    private ListIF<Query> consultas;
    private ComparatorIF comparadorTexto;
    /**
     * Constructor vacío
     */
    public QueryDepotList()
    {
        // initialise instance variables
        consultas = new ListDynamic<Query> ();
        comparadorTexto = new ComparatorText();
    }
    
    /**
     * Constructor que recibe una lista de querys
     */
    public QueryDepotList(ListIF consultas)
    {
        this.consultas = consultas;
    }
    
    //COMPLETO - COMPROBADO N1
    @Override
    /**
     * Devuelve el núemero de consultas diferentes (sin repeticiones) que hay almacenadas en
     * el depósito.
     * @return el número de consultas diferentes almacenadas
     */
    public int numQueries ()
    {
        return consultas.getLength();
    }
    
    //COMPLETO -- COMPROBADO N1
    @Override
    /**
     * Consulta la frecuencia de una consulta en el depósito.
     * @return la frecuencia de la consulta. Si no está, devuelve 0.
     * @param el texto de la consulta
     */
    public int getFreqQuery (String q)
    {
        int n = 0;
        Query query = searchQuery(q);
        if(query != null)  {
            n = query.getFreq();
        }
        return n;
    }
       
    
    //VACÍO
    @Override
    /**
     * Devuelve una lista ordenada de mayor a menor, de todas la consultas almacenadas en
     * el depósito que comiencen por un prefijo dado.
     * @return lista de consultas ordenada por frecuencia y orden lexicográfico en caso de
     * coincidencia de frecuencia.
     * @param el prefijo.
     */
    public ListIF<Query> listOfQueries (String prefix)
    {
        return null;
    }
    
    
    //COMPLETO -- COMPROBADO N1
    @Override
    /**
     * Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta
     */
    public void incFreqQuery (String q)
    {
        //boolean match = false;
        Query query = searchQuery(q);
        if(query!= null && query.getText().equals(q))  {
            //match = true;
            incrementFreq(query);                   //Incremento de frecuencia mediante método privado
        }
        //Inserta una nueva consulta si no la ha encontrado en la lista
        else  {
            Query newQuery = new Query(q);
            consultas.insert(newQuery);
        }
        consultas = consultas.sort(comparadorTexto);
    }
    
    
    //COMPLETO -- COMPROBADO N1
    @Override
    /**
     * Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia modificada llega a 0, se eliminará la información referente a esa consulta.
     * @precondición la consulta debe estar ya en el depósito.
     * @param el texto de la consulta
     */
    public void decFreqQuery (String q)
    {
        Query query = searchQuery(q);
        if(query.getFreq() == 1)  {
            consultas = remove(consultas,query);
        }
        else  {
            query.setFreq(query.getFreq()-1);
        }
    }
    
    
    //Métodos privados fuera de la implementación de la interface
    /**
     * Método que devuelve un objeto tipo Quey del depósito de consultas en caso de que exista.
     * @param String de la consulta
     * @return Query buscado
     */
    public Query searchQuery (String q)
    {
        if(consultas != null) {
            IteratorIF<Query> itr = consultas.getIterator();
            while(itr.hasNext())  {
                Query query= itr.getNext();
                if(query.getText().equals(q))  {
                    return query;
                }
            }
        }
        return null;
    }
    
    /**
     * Método para incrementar la frecuencia de una query
     * @param el query a incrementar
     */
    private void incrementFreq(Query q)
    {
        q.setFreq(q.getFreq()+1);
    }
    
    /**
     * Método que elimina una query de la lista consultas
     * @param la query a eliminar
     */
    private ListIF remove(ListIF l, Query q)
    {
        if(q == null) return l;
        
        if(l.getFirst().equals(q))  {
            return l.getTail();
        }
        else  {
            return remove(l.getTail(),q).insert(l.getFirst());
        }
    }
   

    //Métodos para pruebas y test unitarios

}
