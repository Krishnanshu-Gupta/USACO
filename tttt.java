package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: tttt
*/

import java.io.*;

class tttt {
 	
	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

		char[] p = new char[9];
		// 0	1 	 2
		// 3	4	 5
		// 6 	7	 8
		int index = 0;
		for(int i = 0; i < 3; i++){
			String line = br.readLine();
			for(int j = 0; j < 3; j++){
				p[index] = line.charAt(j);
				index ++;
			}
		}
		int alone = 0, team = 0;
		//alone
		//rows
		if(p[0] == p[1] && p[1] == p[2]) alone ++;
		if(p[3] == p[4] && p[4] == p[5]) alone ++;
		if(p[6] == p[7] && p[7] == p[8]) alone ++;
		
		//columns
		if(p[0] == p[3] && p[3] == p[6]) alone ++;
		if(p[1] == p[4] && p[4] == p[7]) alone ++;
		if(p[2] == p[5] && p[5] == p[8]) alone ++;
		
		//diagonals
		if(p[0] == p[4] && p[4] == p[8]) alone ++;
		if(p[2] == p[4] && p[4] == p[6]) alone ++;
		
		//team
		//rows
		if( (p[0] == p[1] || p[0] == p[2]  || p[1] == p[2]) && (p[0] != p[1] || p[1] != p[2]) ) team ++;
		if( (p[3] == p[4] || p[3] == p[5]  || p[4] == p[5]) && (p[3] != p[4] || p[4] != p[5]) ) team ++;
		if( (p[6] == p[7] || p[6] == p[8]  || p[7] == p[8]) && (p[6] != p[7] || p[7] != p[8]) ) team ++;
		
		//columns
		if( (p[0] == p[3] || p[0] == p[6]  || p[3] == p[6]) && (p[0] != p[3] || p[3] != p[6]) ) team ++;
		if( (p[1] == p[4] || p[1] == p[7]  || p[4] == p[7]) && (p[1] != p[4] || p[4] != p[7]) ) team ++;
		if( (p[2] == p[5] || p[2] == p[8]  || p[5] == p[8]) && (p[2] != p[5] || p[5] != p[8]) ) team ++; 
		
		//diagonals
		if( (p[0] == p[4] || p[0] == p[8]  || p[4] == p[8]) && (p[0] != p[4] || p[4] != p[8]) ) team ++;
		else if( (p[2] == p[4] || p[2] == p[6]  || p[4] == p[6]) && (p[2] != p[4] || p[4] != p[6]) ) team ++;
		// 0	1 	 2
		// 3	4	 5
		// 6 	7	 8
		pw.println(alone);
		pw.println(team);
		pw.close();
	}
}