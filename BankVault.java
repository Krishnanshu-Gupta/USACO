package PastWork;
import java.util.Scanner;

public class BankVault {

	private static int[] nums;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		nums = new int[Integer.parseInt(s)]; 
		s = in.nextLine();
		String[] vals = s.split(", ");
		for(int i = 0; i < vals.length; i++){
			nums[i] = Integer.parseInt(vals[i]);
		}
		System.out.println(findSum());
		in.close();
	}
	
	public static int findSum(){
		for(int i = 0; i < nums.length; i++){
			int[] vals = new int[5];
			int counter = 0;
			for(int j = -2; j < 3; j++){
				if(i + j < 0) vals[counter] = nums[nums.length - i + j];
				else if(i + j > nums.length - 1) vals[counter] = nums[0 + nums.length - (i + j - 1)];
				else vals[counter] = nums[i + j];
			}	
		}
		return 0;
	}
}
