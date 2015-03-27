import java.io.*;

/**
 * Write a description of class eped2015 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class eped
{
    private QueryDepotList lista;
    private Query consulta;
    private static final String file = "texto.txt"; 
    public static void main (String [ ] args) {
        
    }
    
    /**
     * Constructor for objects of class eped2015
     */
    public eped()
    {
        // initialise instance variables
        lista = new QueryDepotList();
        readFile(lista);
    }
    
    public int numeroConsulas()
    {
        return lista.numQueries();
    }
    
    public void imprimirConsultas()
    {
        
    }
    
    private void readFile(QueryDepotList lista)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String response = reader.readLine();
            while(response != null)  {
                lista.incFreqQuery(response);
                response = reader.readLine();
            }
            reader.close();
        }
        catch(FileNotFoundException e)  {
            System.err.println("No se puede abrir " + file);
        }
        catch(IOException e)  {
            System.err.println("Hubo un error al leer " + file);
        }
        
        if(lista.numQueries() == 0)  {
            //consulta = new Query("sinConsultas");
            lista.incFreqQuery("sinConsultas");
        }
    }  
}
