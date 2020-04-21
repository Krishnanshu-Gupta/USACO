package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: lostcow
*/

import java.io.*;
import java.util.StringTokenizer;

class lostcow {
 	
	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int farmer = Integer.parseInt(token.nextToken());
		int bessie = Integer.parseInt(token.nextToken());
		//count to track pos or neg, current for current pos, distance for total traveled, factor for num to add or sub by
		int count = 0, current = farmer, distance = 0, factor = 1;
		for(int i = 0; i <= 9; i++){
			if(current == bessie){
				distance += Math.abs(bessie - farmer);
				break;
			}
			if(count % 2 == 0) current += factor;
			else current -= factor;
			factor *= 2;
			count ++;
			distance += current;
			System.out.println(current + " " + distance);
		}
		
		
		pw.println(distance);
		pw.close();
	}
}