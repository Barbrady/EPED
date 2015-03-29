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
    private int rep = 10;
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
        
            
        
        //iniciarPrograma(deposito,file1,file2);
        iniciarPrograma(file1,file2);
    }
    
    public void iniciarPrograma(String file1, String file2)
    {
        //long tInicial = System.currentTimeMillis();
        //Lee el archivo pasado por parámetro y crea un depósito de consultas
        //Consulta con medición de tiempo
        //long tFinal = System.currentTimeMillis();
        //double duracion = ( (double)tFinal - (double)tInicial)/(double)10;
        readQueries(file1);
        readOperations(file2);
        //System.out.println("Ha tardado " + duracion + " milisegundos.");
    }
    
    public void imprimirSugerencias()
    {
        IteratorIF<Query> itr = consultas.getIterator();
        while(itr.hasNext())  {
            Query q = itr.getNext();
            System.out.println("    " +q.getText() +" con frecuencia "+ q.getFreq() +".");
        }
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
    
    private void readOperations(String file)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String response = reader.readLine();
            while(response != null)  {
                
                if(response.startsWith("F "))  {
                    String consulta = response.substring(2);
                    System.out.println("La frecuencia de \""+ consulta + "\" es "+ deposito.getFreqQuery(consulta));
                }
                
                if(response.startsWith("S "))  {
                    String sugerencia = response.substring(2);
                    long tInicial = System.currentTimeMillis();
                    for(int i=0; i < rep; i++)  {
                        consultas = deposito.listOfQueries(sugerencia);
                    }
                    long tFinal = System.currentTimeMillis();
                    double duracion = ( (double)tFinal - (double)tInicial)/(double)10;
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
}
