package Biblioteca.Listas;


/**
 * Write a description of class ListIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListIterator<T> implements IteratorIF<T>
{
    private ListIF<T> handler;
    private ListIF<T> restart;
    
    public ListIterator (ListIF<T> handler)
    {
        this.handler = handler;
        this.restart = handler;
    }
    
    @Override
    public T getNext ()
    {
        T next = handler.getFirst ();
        handler = handler.getTail ();
        return next;
    }
    
    @Override
    public boolean hasNext ()
    {
        return !handler.isEmpty();
    }
    
    @Override
    public void reset ()
    {
        handler = restart;
    }
    
}
