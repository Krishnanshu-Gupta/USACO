package PastWork;


import java.io.*;
import java.util.*;

public class Swap {

	public static void main(String[] args) throws IOException{
		//Scanner s = new Scanner(System.in);
		//Scanner s = new Scanner(new File("swap.in"));
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter(new File("swap.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> mov = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			mov.add(Integer.parseInt(st.nextToken()));
			mov.add(Integer.parseInt(st.nextToken()));
		}
		int []arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		for(int j = 0; j < k; j++) {
			for(int i = 0; i < mov.size(); i += 2) {
				reverse(arr, mov.get(i) - 1, mov.get(i +1) - 1);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
            pw.println(arr[i]); 
		}
		pw.close();

	}

	public static void reverse(int[] arr, int l, int r){
		int d = (r - l + 1) / 2;
		for(int i = 0; i < d; i++){
			int t = arr[l + i];
			arr[l + i] = arr[r - i];
			arr[r - i] = t;
		}
	}

}