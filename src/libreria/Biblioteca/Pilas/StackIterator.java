package Biblioteca.Pilas;
import Biblioteca.Iterator.*;
/**
 * Write a description of class StackIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackIterator <T> implements IteratorIF <T>
{
    private StackIF<T> handler;
    private StackIF<T> restart;
    
    public StackIterator (StackIF<T> handler)
    {
        this.handler = handler;
        this. restart = new StackDynamic<T> (handler);
    }
    
    @Override
    public T getNext ()
    {
        T top = handler.getTop ();
        handler.pop ();
        return top;
    }
    
    @Override
    public boolean hasNext ()
    {
        return !handler.isEmpty();
    }
    
    @Override
    public void reset ()
    {
        handler = new StackDynamic<T> (restart);
    }
    
    //FALTA DE IMPLEMENTAR
    @Override
    public int hashCode ()
    {
        return -1;
    }
    
    @Override
    public boolean equals (Object o)
    {
        return false;
    }
    
    @Override
    public String toString ()
    {
        return null;
    }
    
    
}
