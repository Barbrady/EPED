import Biblioteca.Comparator.*;
/**
 * Write a description of class ComparatorText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorText extends ComparatorBase<Query>
{
    @Override
    public int compare(Query q1, Query q2)
    {
        int value = 0;
        if(q1 != null && q2 != null)  {
            if(q1.getText().compareTo(q2.getText()) > 0) value = LESS;
            if(q1.getText().compareTo(q2.getText()) < 0) value = GREATER;
            if(q1.getText().compareTo(q2.getText()) == 0) value = EQUAL;
        }
        return value;
    }
}
