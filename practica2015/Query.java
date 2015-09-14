
/**
 * Clase que implementa la consulta (Query).
 * 
 * @author (Aitor Alkorta Puente) 
 * @version (1.0)
 */
public class Query
{
    // variables de instancia.
    private int frequency;
    private String text;

    /**
     * Constructor vacío de la query.
     */
    public Query()
    {

    }

    /**
     * Constructor de una nueva query con el texto pasado como parámetro.
     * 
     * @param Cadena de caracteres (String)
     */
    public Query (String text)
    {
        this.text = text;
        frequency = 1;
    }
    
    /**
     * Modifica la frecuencia de la query.
     */
    public void setFreq(int freq)
    {
        if(freq >= 0) frequency = freq;
        else  {
            System.out.println("La frecuencia asignada es negativa.");
        }
    }
    
    /**
     * Devuelve el texto de una query.
     * @return String con el texto.
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * Devuelve la frecuencia de una query.
     * @return frecuencia.
     */
    public int getFreq()
    {
        return frequency;
    }
    
}
