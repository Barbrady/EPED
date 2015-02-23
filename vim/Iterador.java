import weiss.ds.MyContainer;
import weiss.ds.Iterator;

class Iterador
{
	public static void main ( String [] args )
	{
		MyContainer v = new MyContainer();
		v.add( "Hola" );
		v.add( "Mundo." );

		Iterator itr = v.iterator();
		while( itr.hasNext() )
			System.out.println( itr.next() );
	}
}
