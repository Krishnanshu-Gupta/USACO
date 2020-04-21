package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: taming
 */

import java.io.*;
import java.util.*;

class taming {

	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int num = Integer.parseInt(f.readLine());

		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] log = new int[num];
		for(int i = 0; i < num; i++) log[i] = Integer.parseInt(st.nextToken());
		log[0] = 0;
		
		int breakouts = 0, doubts = 0;
		int change = 0;
		for(int i = 0; i < num; i++){
			change = log[i];
			if(change > 0){
				int count = 0;
				for(int j = i - change; j < i; j++){
					log[j] = count;
					System.out.println(log[j] + count);
					count++;
				}
			}
		}
		
		for(int i = 0; i < num; i++){
			if(log[i] == 0) breakouts ++;
			if(log[i] == -1) doubts ++;
		}
		
		System.out.println(Arrays.toString(log));
		
		if(doubts == num) pw.println(-1);
		else pw.println(breakouts + " " + (breakouts + doubts));
		pw.close();
	}
}