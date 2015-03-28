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
    //private QueryDepotList deposito;
    private ListIF<Query> consultas;
    private Query consulta;
    private QueryDepot deposito;
    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {
        // initialise instance variables
        //x = 0;
    }
    
    public Controlador(String tipo, String file1, String file2)
    {
        if(tipo.equals("L"))  {
            deposito = new QueryDepotList();
        }
        
        if(tipo.equals("T"))  {
            //QueryDepotTree deposito  = new QueryDepotTree();
        }
        
            
        
        iniciarPrograma(deposito,file1,file2);
    }
    
    public void iniciarPrograma(QueryDepot deposito, String file1, String file2)
    {
        long tInicial = System.currentTimeMillis();
        //Lee el archivo pasado por parámetro y crea un depósito de consultas
        readQueries(deposito,file1);
        //Consulta con medición de tiempo
        long tFinal = System.currentTimeMillis();
        double duracion = ( (double)tFinal - (double)tInicial)/(double)10;
        
        readOperations(file2);
        
        imprimirConsultas();
        System.out.println("Ha tardado " + duracion + " milisegundos.");
    }
    
    public void imprimirConsultas()
    {
        IteratorIF<Query> itr = consultas.getIterator();
        while(itr.hasNext())  {
            Query q = itr.getNext();
            System.out.println("" +q.getText() +" se repite: "+ q.getFreq() +" veces.");
        }
    }
    
    private void readQueries(QueryDepot deposito, String file)
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
    
    private void readOperations(String file)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String response = reader.readLine();
            int frecuencia = 0;
            while(response != null)  {
                if(response.startsWith("F "))  {
                    String consulta = response.substring(1);
                    frecuencia = deposito.getFreqQuery(consulta);
                    System.out.println("La frecuencia de "+ consulta + " es "+ frecuencia);
                }
                if(response.startsWith("S "))  {
                    consultas = deposito.listOfQueries(response.substring(1));
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
}
