package Biblioteca.Pilas;
import Biblioteca.Listas.*;

/**
 * Write a description of class StackList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackList<T> implements StackIF<T>
{
    private ListIF<T> list;
    
    public StackList ()
    {
        this.list = new ListDynamic<T> ();
    }
    
    //IMPLEMENTACIÖN PROPIA
    public StackList (StackIF<T> stack)
    {
        this.list = new ListDynamic<T> ();
        IteratorIF<T> itr = stack.getIterator();
        while(itr.hasNext())
        {
            T element = itr.getNext();
            list.insert(element);
        }
    }
    
    public StackList (ListIF<T> list) 
    {
        this.list = new ListDynamic<T> (list);
    }
    
    @Override
    public T getTop ()
    {
        return list.getFirst ();
    }
    
    @Override
    public StackIF<T> push (T element)
    {
        list.insert (element);
        return this;
    }
    
    @Override
    public StackIF<T> pop ()
    {
        list = list.getTail ();
        return this;
    }
    
    @Override
    public boolean isEmpty ()
    {
        return list.isEmpty();
    }
    
    @Override
    public boolean isFull ()
    {
        return list.isFull();
    }
    
    @Override
    public int getLength ()
    {
        return list.getLength();
    }
    
    @Override
    public boolean contains (T element)
    {
        return list.contains(element);
    }
    
    @Override
    public IteratorIF<T> getIterator ()
    {
        StackIF<T> handler = new StackList<T> (list);
        return new StackIterator<T> (handler);
    }
    
    @Override
    public int hashCode ()
    {
        return 31* ((list == null) ? 0 : list.hashCode ());
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null) return false;
        
        if (o.getClass() != this.getClass()) return false;
        else {
            StackList<T> s = (StackList<T>) o;
            return s.list.equals(list);
        }
    }
    
    @Override
    public String toString ()
    {
        StringBuffer buff = new StringBuffer ();
        buff.append("StackList - [");
        
        IteratorIF<T> stackIt = getIterator();
        while (stackIt.hasNext())  {
            T element = stackIt.getNext ();
            buff.append (element);
            if (stackIt.hasNext ())
                buff.append(", ");
        }
        buff.append("]");
        return buff.toString ();
        
    }
}
