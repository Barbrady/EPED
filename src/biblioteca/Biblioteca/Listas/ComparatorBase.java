package Biblioteca.Listas;

/**
 * Abstract class ComparatorBase - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class ComparatorBase<T> implements ComparatorIF<T>
{
    @Override
    public abstract int compare (T e1, T e2);
    
    @Override
    public boolean isLess (T e1, T e2)
    {
        return compare(e1,e2) == ComparatorIF.LESS;
    }
    
    @Override
    public boolean isEqual(T e1, T e2) 
    {
        return compare(e1, e2) == ComparatorIF.EQUAL;
    }

    @Override
    public boolean isGreater(T e1, T e2) 
    {
        return compare(e1, e2) == ComparatorIF.GREATER;
    }
}
