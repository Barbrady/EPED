import Biblioteca.*;
/**
 * Write a description of class EjerciciosListas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjerciciosListas
{
    ListDynamic<Enteros> lista;
    Enteros a, b, c, d;
    
    public EjerciciosListas()
    {
        lista = new ListDynamic<Enteros> ();
        a = new Enteros(1);
        b = new Enteros(2);
        c = new Enteros(4);
        d = new Enteros(12);
        
        lista.insert(a);
        lista.insert(b);
        lista.insert(c);
        lista.insert(d);
    }
    
    public void imprimir()
    {
        a.mostrar();
        b.mostrar();
        c.mostrar();
        d.mostrar();
    }
    
    public void sumarUno()
    {
        IteratorIF<Enteros> itr = lista.getIterator();
        while(itr.hasNext())
        {
            
        
    }
}
