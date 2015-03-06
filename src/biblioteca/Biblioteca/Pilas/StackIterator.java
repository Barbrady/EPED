package Biblioteca.Pilas;
import Biblioteca.Listas.IteratorIF;
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
    public void 
    
}
