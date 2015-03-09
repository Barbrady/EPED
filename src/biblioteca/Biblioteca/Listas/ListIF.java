package Biblioteca.Listas;
import Biblioteca.Iterator.*;

public interface ListIF<T>
{
    public T getFirst ();
    
    public ListIF<T> getTail ();
    
    public ListIF<T> insert (T element);
    
    public boolean isEmpty ();
    
    public boolean isFull ();
    
    public int getLength ();
    
    public IteratorIF<T> getIterator ();
    
    public boolean contains (T element);
    
    public ListIF<T> sort (ComparatorIF<T> comparator);
    
}
