package Biblioteca.Arboles;
import Biblioteca.Iterator.*;
import Biblioteca.Colas.*;
import Biblioteca.Pilas.*;

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
    
    @Override
    public boolean hasNext ()
    {
        return iterator.hasNext ();
    }
    
    @Override
    public void reset ()
    {
        iterator.reset ();
    }
    
    private QueueIF<T> preorder (TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T> ();
        T element = tree.getRoot ();
        traverse.add (element);
        IteratorIF<TreeIF<T>> childrenIt = tree.getChildren().getIterator();
        while (childrenIt.hasNext ())  {
            TreeIF<T> aChild = childrenIt.getNext ();
            QueueIF<T> aTraverse = preorder (aChild);
            addAll (traverse, aTraverse);
        }
        return traverse;
    }
    
    private QueueIF<T> postorder (TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T> ();
        T element = tree.getRoot ();
        IteratorIF <TreeIF<T>> childrenIt = tree.getChildren ().getIterator ();
        while (childrenIt.hasNext ())  {
            TreeIF<T> aChild = childrenIt.getNext ();
            QueueIF<T> aTraverse = postorder (aChild);
            addAll (traverse, aTraverse);
        }
        traverse.add (element);
        return traverse;
    }
    
    private QueueIF<T> lrBreadth (TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T> ();
        QueueIF<TreeIF<T>> aux = new QueueDynamic<TreeIF<T>> ();
        
        aux.add (tree);
        while (!aux.isEmpty ())  {
            TreeIF<T> aTree = aux.getFirst ();
            T element = aTree.getRoot ();
            IteratorIF<TreeIF<T>> childrenIt = aTree.getChildren().getIterator();
            while (childrenIt.hasNext ())
            {
                TreeIF<T> aChild = childrenIt.getNext ();
                aux.add (aChild);
            }
            traverse.add(element);
            aux.remove();
        }
        return traverse;
    }
    
    private QueueIF<T> rlBreadth (TreeIF<T> tree)
    {
        QueueIF<T> traverse = lrBreadth (tree);
        StackIF<T> aux = new StackDynamic<T> ();
        while (!traverse.isEmpty ())  {
            T element = traverse.getFirst ();
            aux.push (element);
            traverse.remove ();
        }
        while (!aux.isEmpty ())  {
            T element = aux.getTop ();
            traverse.add (element);
            aux.pop ();
        }
        return traverse;
    }
    
    private void addAll (QueueIF<T> q, QueueIF<T> p)
    {
        while (!p.isEmpty ())  {
            T element = p.getFirst ();
            q.add (element);
            p.remove ();
        }
    }
}

