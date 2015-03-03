package Biblioteca.Pilas;
import Biblioteca.Listas.ListIF;

/**
 * Write a description of class StackDynamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackDynamic <T> implements StackIF <T>
{
    private T   element;
    private StackDynamic<T> next;
    
    public StackDynamic ()
    {
        element = null;
        next = null;
    }
    
    public StackDynamic (StackIF<T> stack)
    {
        this ();
        if (stack != null)
            if (!stack.isEmpty ())
            {
                element = stack.getTop ();
                next = new StackDynamic<T> (stack.pop ());
                stack.push (element);
            }
        }
       
    public StackDynamic (ListIF<T> list)
    {
        this ();
        if (list != null)
            if (!list.empty ())
            {
                element = list.getFirst();
                next = new StackDynamic<T> (list.getTail());
            }
    }
    
    @Override
    public T getTop()
    {
        return element;
    }
    
    @Override
    public StackIF<T> push (T element)
    {
        if(element != null)
        {
            StackDynamic<T> stack = new StackDynamic<T> ();
            stack.element = this.element;
            stack.next = this.next;
            this.elemnt = element;
            this.next = stack;
        }
    }
     
   
}
