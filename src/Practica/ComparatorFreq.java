import Biblioteca.Comparator.*;
/**
 * Write a description of class ComparatorFreq here.
 * 
 * @author (Aitor Alkorta) 
 * @version (1.0)
 */
public class ComparatorFreq extends ComparatorBase<Query>
{
    /**
     * Metodo compare, recibe dos query y devuelve un entero en función de la comparación
     * @param las dos Query a comparar
     * @return entero en función de la comparación
     */
    @Override
    public int compare(Query q1, Query q2)
    {
        int value = 0;
        if(q1 != null && q2 != null)
        {
            if(q1.getFreq() < q2.getFreq()) value = LESS;
            if(q1.getFreq() > q2.getFreq()) value = GREATER;
            if(q1.getFreq() == q2.getFreq()) value = EQUAL;
        }
        return value;
    }
}
