import Biblioteca.Listas.*;
/**
 * Interface para la práctica de la asignatura EPED de 2015.
 * 
 * @author (Aitor Alkorta Puente) 
 * @version (0.1)
 */

public interface QueryDepot
{
    /**
     * Devuelve el núemero de consultas diferentes (sin repeticiones) que hay almacenadas en
     * el depósito.
     * @return el número de consultas diferentes almacenadas
     */
    public int numQueries ();
    
    /**
     * Consulta la frecuencia de una consulta en el depósito.
     * @return la frecuencia de la consulta. Si no está, devuelve 0.
     * @param el texto de la consulta
     */
    public int getFreqQuery (String q);
    
    /**
     * Devuelve una lista ordenada de mayor a menor, de todas la consultas almacenadas en
     * el depósito que comiencen por un prefijo dado.
     * @return lista de consultas ordenada por frecuencia y orden lexicográfico en caso de
     * coincidencia de frecuencia.
     * @param el prefijo.
     */
    public ListIF<Query> listOfQueries (String prefix);
    
    /**
     * Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta
     */
    public void incFreqQuery (String q);
    
    /**
     * Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia modificada llega a 0, se eliminará la información referente a esa consulta.
     * @precondición la consulta debe estar ya en el depósito.
     * @param el texto de la consulta
     */
    public void decFreqQuery (String q);
    
}
