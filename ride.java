package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	
	@SuppressWarnings("resource")
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String a = f.readLine();
		String b = f.readLine();
		
		int product1 = toProduct(a);
		int product2 = toProduct(b);
		
		if(product1 % 47 == product2 % 47)
			out.println("GO");
		else 
			out.println("STAY");
		out.close();                                  
	}
	
	public static int toProduct(String word){
		int product = 1;
		for(int i = 0; i < word.length(); i++){
			  product *= (word.charAt(i) - 'A') + 1;
		}
		return product;
	}
}