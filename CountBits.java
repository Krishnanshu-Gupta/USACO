package PastWork;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountBits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String st = new String(br.readLine());
		if(st.length() == 0) st = new String(br.readLine());
		String[] results = st.split(",");
		
		int[] r = new int[results.length];
		for(int i = 0; i < results.length; i++){
			String temp = Integer.toBinaryString(Integer.parseInt(results[i].trim()));
			r[i] = temp.length() - temp.replace("1", "").length();
		}
		int counter = 0;
		for(int i = 0; i < r.length; i++){
			for(int j = i + 1; j < r.length; j++){
				if(r[i] > r[j]) counter ++;
			}
		}
		System.out.println(counter);
	}

}
