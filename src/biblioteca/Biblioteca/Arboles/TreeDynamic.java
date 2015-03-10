package Biblioteca.Arboles;
import Biblioteca.Colas.*;
import Biblioteca.Listas.*;
import Biblioteca.Pilas.*;
import Biblioteca.Iterator.*;



/**
 * Write a description of class TreeDynamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreeDynamic<T> implements TreeIF<T>
{
    private T root;
    private QueueIF<TreeIF <T>> children;
    
    public TreeDynamic ()
    {
        this.root = null;
        this.children = new QueueDynamic <TreeIF<T>> ();
    }
    
    public TreeDynamic (T element)
    {
        this ();
        this.root = element;
    }
    
    public TreeDynamic (TreeIF<T> tree)
    {
        this.root = tree.getRoot ();
        this.children = new QueueDynamic <TreeIF<T>> ();
        
        ListIF <TreeIF<T>> tChildren = tree.getChildren ();
        while (!tChildren.isEmpty ())  {
            TreeIF<T> aChild = tChildren.getFirst ();
            TreeIF<T> cChild = new TreeDynamic<T> (aChild);
            children.add (cChild);
            tChildren = tChildren.getTail ();
        }
    }
    
    @Override
    public T getRoot ()
    {
        return this.root;
    }
    
    @Override
    public ListIF <TreeIF<T>> getChildren ()
    {
        ListIF <TreeIF<T>> lChildren = new ListDynamic<TreeIF<T>> ();
        StackIF <TreeIF<T>> sChildren = new StackDynamic<TreeIF<T>> ();
        IteratorIF<TreeIF<T>> childrenIt = children.getIterator ();
        while (childrenIt.hasNext ())  {
            TreeIF<T> aChild = childrenIt.getNext ();
            sChildren.push (aChild);
        }
        while (!sChildren.isEmpty ())  {
            TreeIF<T> aChild = sChildren.getTop ();
            lChildren.insert (aChild);
            sChildren.pop ();
        }
        return lChildren;
    }
    
    @Override
    public void setRoot (T element)
    {
        if (element != null) this.root = element;
    }
    
    @Override
    public void addChild (TreeIF<T> child)
    {
        if (this.root != null) children.add (child);
    }
    
    @Override
    public void removeChild (int index)
    {
        QueueIF<TreeIF<T>> aux = new QueueDynamic <TreeIF<T>> ();
        for (int i = 0; i<children.getLength (); i++)  {
            TreeIF<T> aChild = children.getFirst ();
            if (i != index) aux.add (aChild);
            children.remove ();
        }
        children = aux;
    }
    
    @Override
    public boolean isLeaf ()
    {
        return children.isEmpty ();
    }
    
    @Override
    public boolean isEmpty ()
    {
        return this.root == null && children.isEmpty ();
    }
    
    @Override
    public boolean contains (T element)
    {
        if (this.root.equals (element)) return true;
        else  {
            IteratorIF<TreeIF<T>> childrenIt = children.getIterator ();
            boolean found = false;
            while (!found && childrenIt.hasNext ())  {
                TreeIF<T> aChild = childrenIt.getNext ();
                found = aChild.contains (element);
            }
            return found;
        }
    }
    
    @Override
    public IteratorIF<T> getIterator (int type)
    {
        TreeIF<T> handler = new TreeDynamic<T> (this);
        return new TreeIterator<T> (handler,type);
    }
    
    //FALTA IMPLEMENTAR
    @Override
    public int hashCode ()
    {
        return -1;
    }
    
    @Override
    public boolean equals ()
    {
        return false;
    }
    
    @Override
    public String toString ()
    {
        return null;
    }
}
