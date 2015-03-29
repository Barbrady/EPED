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
    private int rep = 100;
    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {

    }
    
    public Controlador(String tipo, String consultas, String sugerencias)
    {
        if(tipo.equals("L"))  {
            deposito = new QueryDepotList();
        }
        
        if(tipo.equals("T"))  {
            //QueryDepotTree deposito  = new QueryDepotTree();
            System.out.println("El depósito de consultas con árbol aun no está implementado.");
            return;
        }
        
            
        
        //iniciarPrograma(deposito,file1,file2);
        iniciarPrograma(consultas,sugerencias);
    }
    
    public void iniciarPrograma(String consultas, String sugerencias)
    {
        readQueries(consultas);
        exeOperations(sugerencias);
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
                    duracion = ( (double)tFinal - (double)tInicial)/(double)10;
                    System.out.println("La frecuencia de \""+ consulta + "\" es "+ frecuencia +".");
                    System.out.println("-Tiempo:"+duracion);
                }
                
                if(response.startsWith("S "))  {
                    String sugerencia = response.substring(2);
                    tInicial = System.currentTimeMillis();
                    for(int i=0; i < rep; i++)  {
                        consultas = deposito.listOfQueries(sugerencia);
                    }
                    tFinal = System.currentTimeMillis();
                    duracion = ( (double)tFinal - (double)tInicial)/(double)10;
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
        IteratorIF<Query> itr = consultas.getIterator();
        while(itr.hasNext())  {
            Query q = itr.getNext();
            System.out.println("    \"" +q.getText() +"\" con frecuencia "+ q.getFreq() +".");
        }
    }
}
