package PastWork;
/*
ID: krishna87
LANG: JAVA
TASK: transform
 */

import java.io.*;
import java.util.*;

class transform {

	private static char[][] orig, newArray;
	private static int length;

	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));  

		length = in.nextInt();
		in.nextLine();
		orig = new char[length][length];
		String temp = null;

		for(int i = 0; i < length; i++){
			temp = in.nextLine();
			for(int j = 0; j < length; j++){
				orig[i][j] = temp.charAt(j);
			}
		}

		newArray = new char[length][length];
		for(int i = 0; i < length; i++){
			temp = in.nextLine();
			for(int j = 0; j < length; j++){
				newArray[i][j] = temp.charAt(j);
			}
		}
		
		if(check90()) out.println("1");
		else if(check180()) out.println("2");
		else if(check270()) out.println("3");
		else if(checkReflect()) out.println("4");
		//else if(checkCombo()) out.println("5");
		else if(noChange()) out.println("6");
		else out.println("7");
		
		out.close();
	}

	public static boolean check90(){
		String origLine = "", newLine = "";

		for(int i = length - 1; i >= 0; i--) for(int j = 0; j < length; j++) origLine += orig[i][j];
		for(int i = 0; i < length; i++) for(int j = 0; j < length; j++) newLine += newArray[j][i];
		
		if(!origLine.equalsIgnoreCase(newLine)) return false;
		return true;
	}

	public static boolean check180(){
		String origLine = "", newLine = "";
	
		for(int i = length - 1; i > 0; i--) for(int j = length - 1; j >= 0; j--) origLine += orig[i][j];
		for(int i = 0; i < length; i++) for(int j = 0; j < length; j++) newLine += newArray[i][j];
		
		if(!origLine.equalsIgnoreCase(newLine)) return false;
		return true;
	}

	public static boolean check270(){
		String origLine = "", newLine = "";

		for(int i = length - 1; i >= 0; i--) for(int j = 0; j < length; j++) origLine += orig[j][i];
		for(int i = 0; i < length; i++) for(int j = 0; j < length; j++) newLine += newArray[i][j];
		if(!origLine.equalsIgnoreCase(newLine)) return false;
		return true;
	}

	public static boolean checkReflect(){
		String origLine = "", newLine = "";

		for(int i = 0; i < length; i++) for(int j = length - 1; j >= 0; j--) origLine += orig[i][j];
		for(int i = 0; i < length; i++) for(int j = 0; j < length; j++) newLine += newArray[i][j];
		
		if(!origLine.equalsIgnoreCase(newLine)) return false;
		return true;
	}

	//check
	public static boolean checkCombo(){
		String reflected = "", check = "";
		for(int i = 0; i < length; i++) for(int j = length - 1; j >= 0; j--) reflected += orig[i][j];
		
		//check 90
		for(int i = length - 1; i >= 0; i--) for(int j = 0; j < length; j++) check += orig[i][j];
		if(reflected.equalsIgnoreCase(check)) return true;
		
		//check 180
		check = "";
		for(int i = length - 1; i > 0; i--) for(int j = length - 1; j >= 0; j--) check += orig[i][j];
		if(reflected.equalsIgnoreCase(check)) return true;
		
		//check 270
		check = "";
		for(int i = length - 1; i >= 0; i--) for(int j = 0; j < length; j++) check += orig[j][i];
		if(reflected.equalsIgnoreCase(check)) return true;
		
		return false;
	}

	public static boolean noChange(){
		String origLine = null, newLine = null;

		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				origLine += orig[i][j];
				newLine += newArray[i][j];
			}
		}
		
		if(!origLine.equalsIgnoreCase(newLine)) return false;
		return true;
	}
}