package EstructurasDatos;
import EstructurasDatos.*;
//import Excepciones.*;

public final class TipoListaEnlazada
{
	public static void main ( String [] args )
	{
		Lista laLista = new ListaEnlazada();
		ListaIter iter = new ListaEnlazadaIter(LaLista);
		
		for( int i=0; i<5; i++)  
		 {
			 iter.insertar(new Integer( i ) );
		 }

		 System.out.print("Contenido.");
		 for( iter.primero(); iter.estaDentro(); iter.avanzar())
		 {
			 System.out.print(" " + iter.recuperar());
		 }
	}
}
