package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Guest implements Comparable<Guest>{
	int time;
	String status;
	
	Guest(int time, String status) {
		this.time = time;
		this.status = status;
	}

	@Override
	public int compareTo(Guest o) {
		if(this.time == o.time) return this.status.compareTo(o.status);
		else return this.time - o.time;
	}
	
	
}

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Guest> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int start = sc.nextInt();
			list.add(new Guest(start, "S"));
			int end   = sc.nextInt();
			list.add(new Guest(end, "E"));
		}
		
		Collections.sort(list);
		
		
		int cnt = 0;
		int answer = 0;
		
		for(Guest g : list) {
			if(g.status.equals("S")) {
				cnt++;
				answer = Math.max(cnt, answer);
			} else {
				cnt--;
			}
		}
		
		System.out.println(answer);
		

	}

}
