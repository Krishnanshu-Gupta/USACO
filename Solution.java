package PastWork;
import java.util.*;

public class Solution {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int count = 0;
		boolean[] done = new boolean[26];
		Arrays.fill(done, false);
		s = s.toLowerCase();

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != ' '){
				int index = s.charAt(i) - 'a';
				done[index] = true;
			}
		}

		boolean allDone = true;
		for(int i = 0; i < 26; i++){
			if(!done[i]) allDone = false;  
		}

		System.out.println(allDone ? "panagram" : "not panagram");
	}
}