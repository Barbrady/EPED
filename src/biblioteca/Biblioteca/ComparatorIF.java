package Biblioteca;


/**
 * Write a description of interface ComparatorIF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface ComparatorIF<T>
{
    public static int LESS = -1;
    public static int EQUAL = 0;
    public static int GREATER = 1;
    
    public int compare (T e1, T e2);
    
    public boolean isLess (T e1, T e2);
    
    public boolean isEqual (T e1, T e2);
    
    public boolean isGreater (T e1, T e2);
    
}
