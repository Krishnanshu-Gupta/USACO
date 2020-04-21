package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: square
*/

import java.io.*;
import java.util.*;

class square {
 	
	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(new FileReader("square.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		
		int[] xval = new int[4], yval = new int[4];
		xval[0] = in.nextInt();
		yval[0] = in.nextInt();
		xval[1] = in.nextInt();
		yval[1] = in.nextInt();
		in.nextLine();
		xval[2] = in.nextInt();
		yval[2] = in.nextInt();
		xval[3] = in.nextInt();
		yval[3] = in.nextInt();
		
		int current = 0, max = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				current = Math.abs(xval[i] - xval[j]);
				max = Math.max(current, max);
			}
		}
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				current = Math.abs(yval[i] - yval[j]);
				max = Math.max(current, max);
			}
		}
		out.println(max * max);
		out.close();
	}
}