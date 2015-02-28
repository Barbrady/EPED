public class Factorial
{
	public static void main (String [] args)
	{
		int n=5;
		int m;
		m = factorial(n);
		System.out.println("El factorial de" + n + " es:" + m);
	}
	public static int factorial (int n)
	{
		if(n == 0) return 1;
		return n*(factorial (n-1));
	}
}