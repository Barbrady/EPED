import Biblioteca.Listas.*;
import Biblioteca.Iterator.*;
import java.io.*;
/**
 * Clase Controlador. Define un objeto que recibe tres parámetros tipo String.
 * Crea un objeto tipo QueryDepot, 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
    // instance variables - replace the example below with your own
    //private QueryDepotList deposito;
    private ListIF<Query> queries;
    private Query consulta;
    private QueryDepot deposito;
    private int rep = 1000;
    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {

    }
    
    public Controlador(String tipo, String consultas, String operaciones)
    {
        if(tipo.equals("L"))  {
            deposito = new QueryDepotList();
        }
        
        else if(tipo.equals("T"))  {
            deposito  = new QueryDepotTree();
        }  
        
        else {
            System.out.println("El tipo de depóstio indicado no es válido.");
            return;
        }
        iniciarPrograma(consultas,operaciones);
    }
    
    public void iniciarPrograma(String consultas, String operaciones)
    {
        readQueries(consultas);
        exeOperations(operaciones);
    }
    
    private void readQueries(String file)
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
            deposito.incFreqQuery("sinConsultas");
        }
        
    }
    
    private void exeOperations(String file)
    {
        System.out.println("Consultas almacenadas: "+ deposito.numQueries());
        long tInicial,tFinal;
        double duracion;
        int frecuencia = 0;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String response = reader.readLine();
            while(response != null)  {
                
                if(response.startsWith("F "))  {
                    String consulta = response.substring(2);
                    tInicial = System.currentTimeMillis();
                    for(int i=0; i < rep; i++)  {
                        frecuencia = deposito.getFreqQuery(consulta);
                    }
                    tFinal = System.currentTimeMillis();
                    duracion = ( (double)tFinal - (double)tInicial)/(double)rep;
                    System.out.println("La frecuencia de \""+ consulta + "\" es "+ frecuencia +".");
                    System.out.println("-Tiempo:"+duracion);
                }
                
                if(response.startsWith("S "))  {
                    String sugerencia = response.substring(2);
                    tInicial = System.currentTimeMillis();
                    for(int i=0; i < rep; i++)  {
                        queries = deposito.listOfQueries(sugerencia);
                    }
                    tFinal = System.currentTimeMillis();
                    duracion = ( (double)tFinal - (double)tInicial)/(double)rep;
                    System.out.println("La lista de sugerencias para \"" + sugerencia +"\" es:");
                    imprimirSugerencias();
                    System.out.println("-Tiempo:"+duracion);
                }
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
    }
    
    public void imprimirSugerencias()
    {
        IteratorIF<Query> itr = queries.getIterator();
        while(itr.hasNext())  {
            Query q = itr.getNext();
            System.out.println("    \"" +q.getText() +"\" con frecuencia "+ q.getFreq() +".");
        }
    }
}
