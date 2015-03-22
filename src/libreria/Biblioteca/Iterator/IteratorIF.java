package Biblioteca.Iterator;


/**
 * Write a description of interface IteratorIF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IteratorIF<T>
{
    public T getNext ();
    
    public boolean hasNext ();
    
    public void reset ();
}
