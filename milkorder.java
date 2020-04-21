package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: milkorder
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class milkorder {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int[] order = new int[count];
		boolean[] placed = new boolean[count];
		Arrays.fill(placed, false);
		Arrays.fill(order, 0);

		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] milkorder = new int[count];
		int index = 0;
		while(st.hasMoreTokens()){
			milkorder[index] = Integer.parseInt(st.nextToken());
			index ++;
		}


		for(int i = 0; i < k; i++){
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken());
			placed[cow - 1] = true;
			order[Integer.parseInt(st.nextToken()) - 1] = cow;
		}

		for(int i = 0; i < order.length; i++){
			System.out.println(order[i]);
		}

		int pos = 0, start = 1;
		if(!placed[milkorder[start]]){
			if(placed[milkorder[start - 1]]){
				int temp = milkorder[start - 1], num = milkorder[start];
				for(int i = Arrays.binarySearch(order, num); i >= 0; i--){
					if(order[i] == 0){
						placed[temp] = true;
						order[i] = temp;
					}
				}
			}
		}
		//5 is in order array
		while(pos == 0){
			pos = 1;
			
		}
		for(int i = 0; i < order.length; i++){
			System.out.println(order[i]);
		}
		pw.close();
	}
}