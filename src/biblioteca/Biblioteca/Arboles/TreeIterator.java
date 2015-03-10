package Biblioteca.Arboles;
import Biblioteca.Iterator.*;

/**
 * Write a description of class TreeIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreeIterator<T> implements IteratorIF<T>
{
    private IteratorIF<T> iterator;
    
    public TreeIterator (TreeIF<T> handler, int type)
    {
        QueueIF<T> traverse = null;
        switch (type)  {
            case TreeIF.PREORDER: traverse = preorder (handler); break;
            case TreeIF.POSTORDER: traverse = postorder (handler); break;
            case TreeIF.LRBREADTH: traverse = lrBreadth (handler); break;
            case TreeIF.RLBREADTH: traverse = rlBreadth (handler); break;
        }
        this.iterator = new QueueIterator<T> (traverse);
    }
    
    @Override
    public T getNext ()
    {
        return iterator.getNext ();
    }
    
    
}
