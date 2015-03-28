import Biblioteca.Listas.*;
import Biblioteca.Iterator.*;
import java.io.*;
/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
    // instance variables - replace the example below with your own
    private QueryDepotList deposito;
    private ListIF<Query> consultas;
    private Query consulta;
    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {
        // initialise instance variables
        //x = 0;
    }
    
    public Controlador(String file, String prefix)
    {
        deposito = new QueryDepotList();
        readFile(deposito,file);
        consultas = deposito.listOfQueries(prefix);
        imprimirConsultas();
    }
      
    public void imprimirConsultas()
    {
        IteratorIF<Query> itr = consultas.getIterator();
        while(itr.hasNext())  {
            Query q = itr.getNext();
            System.out.println("" +q.getText() +" se repite: "+ q.getFreq() +" veces.");
        }
    }
    
    private void readFile(QueryDepotList deposito, String file)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String response = reader.readLine();
            while(response != null)  {
                deposito.incFreqQuery(response);
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
        
        if(deposito.numQueries() == 0)  {
            //consulta = new Query("sinConsultas");
            deposito.incFreqQuery("sinConsultas");
        }
        
    }  
}
