package Biblioteca.Arboles;
import Biblioteca.Iterator.*;

/**
 * Write a description of interface BTreeIF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface BTreeIF<T>
{
    public int PREORDER = 0;
    public int INORDER = 1;
    public int POSTORDER = 2;
    public int LRBREADTH = 3;
    public int RLBREADTH = 4;
    
    public T getRoot ();
    
    public BTreeIF<T> getLeftChild ();
    
    public BTreeIF<T> getRightChild ();
    
    public void setRoot (T element);
    
    public void setLeftChild (BTreeIF<T> tree);
    
    public void setRightChild (BTreeIF<T> tree);
    
    public void removeLeftChild ();
    
    public void removeRightChild ();
    
    public boolean isLeaf ();
    
    public boolean isEmpty ();
    
    public boolean contains (T element);
    
    public IteratorIF<T> getIterator (int traversalType);
    
}
