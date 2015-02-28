package Biblioteca;


/**
 * Write a description of class ListDynamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListDynamic<T> implements ListIF<T>
{
    private T   first;
    private ListIF<T>   tail;
    
    public ListDynamic ()
    {
        first = null;
        tail = null;
    }
    
    public ListDynamic (ListIF<T> list)
    {
        this ();
        if (list != null)
          if (!list.isEmpty ())
          {
              first = list.getFirst ();
              tail = new ListDynamic<T> (list.getTail ());
          }
    }
    
    @Override
    public T getFirst ()
    {
        return first;
    }
    
    @Override
    public ListIF<T> getTail ()
    {
        if (isEmpty ()) return this;
        return tail;
    }
    
    @Override
    public ListIF<T> insert (T element)
    {
        if (element != null) {
            ListDynamic<T> next = new ListDynamic<T>();
            next.first = first;
            next.tail = tail;
            first = element;
            tail = next;
        }
        return this;
    }
    
    @Override
    public boolean isEmpty ()
    {
        return first == null && tail == null;
    }
    
    @Override
    public boolean isFull () {
        return false;
    }
    
    @Override
    public int getLength ()
    {
        if (isEmpty ()) return 0;
        else return 1 + tail.getLength ();
    }
    
    @Override
    public IteratorIF<T> getIterator ()
    {
        ListIF<T> handler = new ListDynamic<T> (this);
        return new ListIterator<T> (handler);
    }
    
    @Override
    public boolean contains (T element)
    {
        return true;
    }
    
    @Override
    public ListIF<T> sort (ComparatorIF<T> comparator)
    {
        return new ListDynamic<T> ();
    }
    
    
}
