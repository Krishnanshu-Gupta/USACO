package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: cowsignal
 */

import java.io.*;
import java.util.*;

class cowsignal {

	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

		int M = in.nextInt();
		int N = in.nextInt();
		int K = in.nextInt(); 
		in.nextLine();
		
		
		
		char t;
		String line, temp = "";
		System.out.println("hacjjdjjdkerrank".contains("hackerrank"));
		for(int i = 0; i < M; i++){
			line = in.nextLine();
			for(int j = 0; j < N; j++){
				t = line.charAt(j);
				for(int k = 0; k < K; k ++) temp += t;
			}
			for(int k = 0; k < K; k ++) pw.println(temp);
			temp = "";
		}
		pw.close();
	}	
}