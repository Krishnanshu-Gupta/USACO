package PastWork;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BadPerms {

	private static ArrayList<Integer> f = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		//get input and chaaage num
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] nums = new int[num];
		for(int i = 0; i < num; i++){
			nums[i] = Integer.parseInt(br.readLine());
		}
		System.out.println();
		for(int i = 0; i < nums.length; i++){
			int ret = run(nums[i]);
			System.out.println(ret);
			f = new ArrayList<Integer>();
		}
	}

	static int run(int number){
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for(int i = 1; i <= number; ++i) {
			if (number % i == 0) {
				nums.add(i);
			}
		}
		int[] sequence = new int[nums.size()];
		int index = 0;
		for(int num: nums){
			sequence[index] = num;
			index ++;
		}
		permute(sequence, 0);
		int[] sorted = new int[nums.size()];
		for(int i = 0; i < nums.size(); i++) sorted[i] = f.get(i);
		Arrays.sort(sorted);
		int valids = 0;
		for(int i = 0; i < f.size() - sequence.length; i += sequence.length){
			boolean isValid = true;
			for(int k = i; k < sequence.length + i - 1; k++){
				for(int j = 0; j < sorted.length - 1; j ++){
					if(f.get(k) == sorted[j] && f.get(k + 1) == sorted[j + 1]) isValid = false;
				}
			}
			if(isValid) valids ++;
		}
		return (valids);
	}

	static void permute(int[] a, int k) 
	{
		if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                f.add(a[i]);
            }
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
	}
}