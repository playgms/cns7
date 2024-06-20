import java.io.*;
import java.math.*;
import java.util.*;

public class RSA {
	public static double gcd(double a, double b)
	{
		if(b==0) return a;
        return gcd(b,a%b);
			}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter value for 'p': ");
		Double p=sc.nextDouble();
		System.out.print("Enter value for 'q': ");
		Double q=sc.nextDouble();
		System.out.print("Enter value for 'message': ");
		Double msg=sc.nextDouble();

		// Stores the first part of public key:
		double n = p * q;

		// Finding the other part of public key.
		// double e stands for encrypt
		double e = 2;
		double phi = (p - 1) * (q - 1);
		while (e < phi) {
			
			if (gcd(e, phi) == 1)
				break;
			else
				e++;
		}
		int k = 2; // A constant value
		double d = (1 + (k * phi)) / e;

		

		System.out.println("Message data = " + msg);

		// Encryption c = (msg ^ e) % n
		double c = Math.pow(msg, e);
		c = c % n;
		System.out.println("Encrypted data = " + c);

		// Decryption m = (c ^ d) % n
		double m = Math.pow(c, d);
		m = m % n;
		System.out.println("Decrypted Data = " + m);

		System.out.println("Public Key : (e ,n) : ( "+e+" , "+n+" )");
		System.out.println("Private Key : (d ,n) : ( "+d+" , "+n+" )");
		sc.close();
	}
}
