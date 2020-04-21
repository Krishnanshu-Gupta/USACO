package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
	
	private static BufferedReader f;
	private static String[] people;
	private static String giving;
	private static int[] money;
 	
	public static void main(String [] args) throws IOException {
		f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int readMore = Integer.parseInt(f.readLine());
		
		people = new String[readMore];
		money = new int[readMore];
		
		for(int i = 0; i < people.length; i++){
			people[i] = f.readLine();
			money[i] = 0;
		}
		
		String temp = f.readLine();;
		do{
			giving = temp;
			StringTokenizer st = new StringTokenizer(f.readLine());
			int s1 = Integer.parseInt(st.nextToken()), s2 = Integer.parseInt(st.nextToken());
			if(s2 != 0) evaluateMoney(s1, s2);
			temp = f.readLine();
		}while(temp != null);
		
		for(int i = 0; i < people.length; i++){
			out.println(people[i] + " " + money[i]);
		}
		
		
		out.close();                                  
	}
	
	public static void evaluateMoney(int amount, int divide) throws IOException {
		int count = 0;
		String temp;
		
		while(count < divide){
			temp = f.readLine();
			for(int i = 0; i < people.length; i++){
				if(temp.equals(people[i])){
					money[i] += amount/divide;
					System.out.println("A " + money[i] + " " + people[i]);
				}
			}
			count ++;
		}
		
		for(int i = 0; i < people.length; i++){
			if(giving.equals(people[i])){
				money[i] -= amount - (amount % divide);
				System.out.println("G " + money[i] + " " + people[i]);
			}
		}
	}
}