package Biblioteca.Listas;


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
       if(isEmpty()) return false;
       return first.equals (element) || tail.contains (element);
    }
    
    @Override
    public ListIF<T> sort (ComparatorIF<T> comparator)
    {
        if (isEmpty()) return this;
        else return ((ListDynamic<T>) tail.sort (comparator)).sortInsert (first, comparator);
    }
    
    private ListIF<T> sortInsert (T element, ComparatorIF<T> comparator)
    {
        if (isEmpty()) return this.insert (element);
        else if(comparator.isLess (element, first))
            return this.insert (element);
            else return ((ListDynamic<T>) tail).sortInsert (element, comparator).insert (first);
    }
    
    //@Override
    public int hashcode ()
    {
        return 31 * ((first == null) ? 0 : first.hashCode ()) + ((tail == null) ? 0 : tail.hashCode ());
    }
    
    @Override
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null) return false;
        
        if(!(o instanceof ListDynamic)) return false;
        else {
            ListDynamic<T> l = (ListDynamic<T>) o;
            return l.first.equals (first) && l.tail.equals (tail);
        }
    }
    
    @Override
    public String toString ()
    {
        StringBuffer buff = new StringBuffer ();
        buff.append("ListDynamic -[");
        
        IteratorIF<T> listIt = getIterator ();
        while (listIt.hasNext ())
        {
            T element = listIt.getNext ();
            buff.append (element);
            if (listIt.hasNext ())
                buff.append(",");
        }
        
        buff.append("]");
        return buff.toString ();
    }
}
