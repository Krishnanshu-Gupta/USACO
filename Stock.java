package PastWork;
import java.util.Scanner;

public class Stock {

	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int mess = Integer.parseInt(in.nextLine());
		int max = Integer.parseInt(in.nextLine());
		
		int total = 0;
		for(int i = 0; i < mess; i++){
			String[] read = in.nextLine().split(" ");
			total += Integer.parseInt(read[1]);
		}
		double a = (double)(total) / max;
		System.out.println((int)Math.round(a));
		in.close();
	}
}
