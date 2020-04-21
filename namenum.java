package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class namenum {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		String orig = f.readLine();
		int num = Integer.parseInt(orig);
		
		String[] words = new String[(int) Math.pow(3, orig.length())];
		char[][] possible = new char[num][3];
		 //2: A,B,C     5: J,K,L    8: T,U,V
         //3: D,E,F     6: M,N,O    9: W,X,Y
         //4: G,H,I     7: P,R,S
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	}
}