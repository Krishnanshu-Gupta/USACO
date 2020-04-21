package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: teleport
 */

import java.io.*;
import java.util.*;

class teleport {

	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int t1 = Integer.parseInt(st.nextToken());
		int t2 = Integer.parseInt(st.nextToken());
		
		int distance = 0;
		int startEnd = Math.abs(end - start), st1 = Math.abs(t1 - start), st2 = Math.abs(t2 - start);
		int et1 = Math.abs(end - t1), et2 = Math.abs(end - t2);
		int path1 =  st1 + et2, path2 = st2 + et1;
		
		if(startEnd <= path1 && startEnd <= path2) distance = startEnd;
		else if(path1 <= path2) distance = path1;
		else distance = path2;
		
		pw.println(distance);
		pw.close();
	}	
}