package Biblioteca.Colas;
import Biblioteca.Iterator.*;
import Biblioteca.Listas.*;

/**
 * Write a description of class QueueStatic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueueStatic<T> implements QueueIF<T>
{
    private Object[] elements;
    private int capacity;
    private int first;
    private int last;
   
    public QueueStatic (int capacity)
    {
       this.elements = new Object[capacity + 1];
       this.capacity = capacity + 1;
       this.first = 0;
       this.last = 0;
    }
    
    public QueueStatic (QueueIF<T> queue)
    {
        if (queue != null)  {
            this.capacity = queue.getLength () + 1;
            this.elements = new Object [this.capacity + 1];
            this.first = 0;
            this.last = 0;
            
            for (int i = 0; i < queue.getLength (); i++)  {
                T element = queue.getFirst ();
                add (element);
                queue.remove ();
                queue.add (element);
            }
        }
    }
    
    public QueueStatic (ListIF<T> list)
    {
        if (list != null)  {
            this.capacity = list.getLength () + 1;
            this.elements = new Object [this.capacity + 1];
            this.first = 0;
            this.last = 0;
            
            ListIF<T> l = list;
            while (!l.isEmpty())  {
                add (l.getFirst ());
                l = l.getTail();
            }
        }
    }
    
    public T getFirst ()
    {
        if (isEmpty ()) return null;
        return (T) elements [first];
    }
    
    @Override
    public QueueStatic<T> add (T element)
    {
        if (element != null)  {
            if (!isFull ())  {
                elements [last] = element;
                last = next (last);
            }
        }
        return this;
    }
    
    @Override
    public QueueStatic<T> remove ()
    {
        if (!isEmpty ())  {
            first = next (first);
        }
        return this;
    }
    
    @Override
    public boolean isEmpty ()
    {
        return next(last) == first;
    }
    
    @Override
    public boolean isFull ()
    {
        return next(last) == first;
    }
    
    @Override
    public int getLength ()
    {
        if (first <= last) return last - first;
        else return capacity - (first - last);
    }
    
    private int next (int index)
    {
        return (index + 1) % capacity;
    }
    
    @Override
    public boolean contains (T element)
    {
        boolean found = false;
        int index = first;
        while (!found && Math.abs (last - index) > 0)  {
            found = elements [index].equals (element);
            index = next (index);
        }
        return found;
    }
    
    @Override
    public IteratorIF<T> getIterator ()
    {
        QueueIF<T> handler = new QueueStatic<T> (this);
        return new QueueIterator<T> (handler);
    }
    
    //FALTA IMPLEMENTAR
    @Override 
    public int hashCode ()
    {
        return -1;
    }
    
    @SuppressWarnings("unchecked")
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
