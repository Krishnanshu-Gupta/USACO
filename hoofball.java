package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: teleport
 */

import java.io.*;
import java.util.*;

class hoofball {

	@SuppressWarnings("unused")
	private static int[] newC, cows;
	private static boolean[] touched;

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		int num = Integer.parseInt(f.readLine());

		StringTokenizer st = new StringTokenizer(f.readLine());
		cows = new int[num];
		touched = new boolean[num];
		Arrays.fill(touched, false);
		for(int i = 0; i < num; i++) cows[i] = Integer.parseInt(st.nextToken());
		newC = cows;
		Arrays.sort(cows);
		
		int used = 0, looping = 0, index = 0;
		boolean startNew = false, startSec = false, allTouched = false;
		int second = cows.length - 1;
		int third = cows.length/2;
				
		while(!allTouched){
			allTouched = true;
			if(used == 0){
				touched[0] = true;
				index = passBall(0);
				touched[index] = true;
				used ++;
			}
			
			index = passBall(index);
			touched[index] = true;
			
			if(passBall(index) == looping){
				used ++;
				if(!startNew){
					startNew = true;
					index = second;
				}
				else if(startNew){
					startSec = true;
					index = third;
				}
			}
			looping = index;			
			for(int i = 0; i < num; i++) if(!touched[i]) allTouched = false;
		}
				
		pw.println(used);
		pw.close();
	}	

	public static int passBall(int startCow){
		int index = startCow;
		touched[startCow] = true;
		if(index == 0) return (index + 1);
		if(index == cows.length - 1) return index - 1;

		int before = Math.abs(cows[index] - cows[index - 1]);
		int after = Math.abs(cows[index] - cows[index + 1]);
		if(before < after) return (index - 1);
		else if(before > after) return (index + 1);
		else return (index - 1);
	}
}