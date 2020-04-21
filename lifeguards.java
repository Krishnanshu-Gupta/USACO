package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: lifegaurds
*/

import java.io.*;
import java.util.*;

class lifeguards {
 	
	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		int count = in.nextInt();
		in.nextLine();
		
		int[] start = new int[count];
		int[] end = new int[count];
		for(int i = 0; i < count - 1; i++){
			start[i] = in.nextInt();
			end[i] = in.nextInt();
			in.nextLine();
		}
		start[count - 1] = in.nextInt();
		end[count - 1] = in.nextInt();
		
		int[] cover = new int[1000];
		for(int i = 0; i < count; i++) for(int t = start[i]; t < end[i]; t++) cover[t] ++;
		
		int maxCover = 0;
		for(int i = 0; i < count; i++){
			for(int t = start[i]; t < end[i]; t++) cover[t]--;
			
			int covered = 0;
			for(int t = 0; t < 1000; t++) if(cover[t] > 0) covered ++; 
			
			maxCover = Math.max(maxCover, covered);
			for(int t = start[i]; t < end[i]; t++) cover[t] ++;
		}
		
		out.println(maxCover);
		out.close();
	}
}