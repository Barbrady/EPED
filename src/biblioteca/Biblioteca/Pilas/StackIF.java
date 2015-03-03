package Biblioteca.Pilas;
import Biblioteca.Listas.IteratorIF;

/**
 * Write a description of interface StackIF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface StackIF <T>
{
    public T getTop ();
    
    public StackIF<T> push (T element);
    
    public StackIF<T> pop ();
    
    public boolean isEmpty ();
    
    public boolean isFull ();
    
    public int getLength ();
    
    public boolean contains (T element);
    
    public IteratorIF<T> getIterator();
}
