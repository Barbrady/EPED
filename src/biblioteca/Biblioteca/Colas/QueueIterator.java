package Biblioteca.Colas;
import Biblioteca.Iterator.*;

/**
 * Write a description of class QueueIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueueIterator<T> implements IteratorIF<T>
{
   private QueueIF<T> handler;
   private QueueIF<T> restart;
   
   public QueueIterator (QueueIF<T> handler)
   {
       this.handler = handler;
       this.restart = new QueueDynamic<T> (handler);
    }
    
   @Override
   public T getNext ()
   {
       T element = handler.getFirst ();
       handler.remove ();
       return element;
    }
    
   @Override
   public boolean hasNext ()
   {
       return !handler.isEmpty ();
   }
   
   @Override
   public void reset ()
   {
       handler = new QueueDynamic<T> (restart);
   }
}