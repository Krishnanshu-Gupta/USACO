package PastWork;
import java.util.ArrayList;
import java.util.Scanner;

public class Chess {

	@SuppressWarnings("unused")
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int teams = Integer.parseInt(s);
		s = in.nextLine();
		int rounds = Integer.parseInt(s);
		int games = ((teams * (teams - 1)) * rounds) / 2;
		double[] teamScore = new double[teams];
		String allGames = new String();
		for(int i = 0; i < games; i++){
			s = in.nextLine();
			allGames += s;
			allGames += ";";
			String[] parts = s.split(" ");
			int t1I, t2I;
			double t1S, t2S;
			t1I = Integer.parseInt(String.valueOf(parts[0].charAt(1)));
			t2I = Integer.parseInt(String.valueOf(parts[1].charAt(1)));
			String[] scores = parts[2].split("-");
			t1S = Double.parseDouble(scores[0]);
			t2S = Double.parseDouble(scores[1]);
			teamScore[t1I - 1] += t1S;
			teamScore[t2I - 1] += t2S;
		}
		String maxS = "", minS = "";
		double max = teamScore[0];
		ArrayList<Integer> maxes = new ArrayList<Integer>();	
		for(int i = 1; i < teamScore.length; i++){
			//System.out.println(teamScore[i]);
			if (teamScore[i] > max) {
				max = teamScore[i];
				maxes.clear();
			} else if (teamScore[i] == max) {
				maxes.add(i);
			}
		}
		if(maxes.size() == 1) maxS = ("P" + (maxes.get(0) + 1) + ":" + max);
		else {
			int i1 = maxes.get(0), i2 = maxes.get(1);
			double s1 = 0, s2 = 0;
			String[] split = allGames.split(";");
			for(int i = 0; i < split.length; i++){
				String[] parts = s.split(" ");
				int t1I, t2I;
				double t1S, t2S;
				t1I = Integer.parseInt(String.valueOf(parts[0].charAt(1)));
				t2I = Integer.parseInt(String.valueOf(parts[1].charAt(1)));
				String[] scores = parts[2].split("-");
				t1S = Double.parseDouble(scores[0]);
				t2S = Double.parseDouble(scores[1]);
				if(t1I == i1 && t2I == i2){
					s1 += t1S;
					s2 += t2S;
				}
				else if(t1I == i2 && t2I == i1){
					s1 += t2S;
					s2 += t1S;
				}
			}

			if(s1 > s2) maxS = ("P" + (maxes.get(0) + 1) + ":" + max);
			else if(s2 > s1) maxS = ("P" + (maxes.get(1) + 1) + ":" + max);
			else {
				if(i1 > i2) maxS = ("P" + (maxes.get(0) + 1) + ":" + max);
				else maxS = ("P" + (maxes.get(1) + 1) + ":" + max);
			}
		}

		double min = teamScore[0];
		ArrayList<Integer> mins = new ArrayList<Integer>();	
		for(int i = 0; i < teamScore.length; i++){
			//System.out.println(teamScore[i]);
			if (teamScore[i] < min) {
				min = teamScore[i];
				mins.clear();
			} else if (teamScore[i] == min) {
				mins.add(i);
			}
		}
		if(mins.size() <= 1) minS = ("P" + (mins.get(0) + 1) + ":" + min);
		else {
			int i1 = mins.get(0), i2 = mins.get(1);
			double s1 = 0, s2 = 0;
			String[] split = allGames.split(";");
			for(int i = 0; i < split.length; i++){
				String[] parts = s.split(" ");
				int t1I, t2I;
				double t1S, t2S;
				t1I = Integer.parseInt(String.valueOf(parts[0].charAt(1)));
				t2I = Integer.parseInt(String.valueOf(parts[1].charAt(1)));
				String[] scores = parts[2].split("-");
				t1S = Double.parseDouble(scores[0]);
				t2S = Double.parseDouble(scores[1]);
				if(t1I == i1 && t2I == i2){
					s1 += t1S;
					s2 += t2S;
				}
				else if(t1I == i2 && t2I == i1){
					s1 += t2S;
					s2 += t1S;
				}
			}

			if(s1 < s2) minS = ("P" + (mins.get(0) + 1) + ":" + min);
			else if(s2 < s1) minS = ("P" + (mins.get(1) + 1) + ":" + min);
			else {
				if(i1 > i2) minS = ("P" + (mins.get(0) + 1) + ":" + min);
				else minS = ("P" + (mins.get(1) + 1) + ":" + min);
			}
		}

		//queries
		int rouds = Integer.parseInt(in.nextLine());
		String[] q = new String[rouds];
		for(int j = 0; j < rouds; j++){
			s = in.nextLine();
			String[] part = s.split(" ");
			int i1 = Integer.parseInt(part[0]), i2 = Integer.parseInt(part[0]);
			double s1 = 0, s2 = 0;
			String[] split = allGames.split(";");
			int length = 0;
			if(part.length == 2) length = split.length;
			else length = Integer.parseInt(part[2]);
			for(int i = 0; i < split.length; i++){
				String[] parts = split[i].split(" ");
				int t1I, t2I;
				double t1S, t2S;
				t1I = Integer.parseInt(String.valueOf(parts[0].charAt(1)));
				t2I = Integer.parseInt(String.valueOf(parts[1].charAt(1)));
				String[] scores = parts[2].split("-");
				t1S = Double.parseDouble(scores[0]);
				t2S = Double.parseDouble(scores[1]);
				if(t1I == i1 && t2I == i2){
					s1 += t1S;
					s2 += t2S;
				}
				else if(t1I == i2 && t2I == i1){
					s1 += t2S;
					s2 += t1S;
				}
			}
			q[j] = String.valueOf((s1 - s2));
		}
		System.out.println(maxS);
		System.out.println(minS);
		for(String fns: q) System.out.println(fns);
		in.close();
	}
}

/*
1. If the length of the query is 2, then we have to find the difference between the scores of participants after all the rounds. Example, 2 1

We will have to find the difference between the scores of 2 and 1 after all the rounds are over.

2. If the length of the query is 3, then we have to find the difference between the cumulative scores of participants after that round is over. Example, 2 1 4

We will have to find the difference between the scores of 2 and 1 after fourth round is over.

3
3
P1 P2 0.5-0.5 1
P1 P3 0-1 1
P2 P3 0.5-0.5 1
P2 P1 1-0 2
P3 P1 0-1 2
P3 P2 0.5-0.5 2
P1 P2 0-1 3
P1 P3 0.5-0.5 3
P2 P3 0-1 3
2
3 1
2 1 2

Output:

P3:3.5

P1:2.0

0.0

1.0

Explanation:

P3 and P2 have same score but P3 will have higher rank because, P3 has won more (while playing as black) against P2 when they played head to head.

Also, in the query 3 1, means the difference between the scores of 3 and 1 after all the rounds are over that is 0 as P3 has won one match, P1 has won one match and one match was drawn between them.

Also, in the query 2 1 2, means the difference between the scores of 3 and 1 after second round is over that is 1 as P3 has won one match, P1 has won one match and one match was drawn between them.

Example 2

Input:

4
2
P2 P1 0.5-0.5 1
P3 P1 0.5-0.5 1
P4 P1 1-0 1
P3 P2 1-0 1
P4 P2 0-1 1
P4 P3 0.5-0.5 1
P1 P2 0-1 2
P1 P3 1-0 2
P1 P4 0.5-0.5 2
P2 P3 1-0 2
P2 P4 0-1 2
P3 P4 0.5-0.5 2
3
3 2 2
1 2
3 2 1

Output:

P4:3.5

P3:2.5

0.0

1.0

1.0

Explanation:


Here P4 and P2 have the same score, also they have same score when they play as black against each other but P4 is ranked higher because it is seeded lower than P2.

 */