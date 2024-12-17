package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class MSched implements Comparable<MSched>{
	int sh;
	int eh;
	MSched(int sh, int eh) {
		this.sh = sh;
		this.eh = eh;
	}
	
	public int compareTo(MSched o) {
		if(this.eh == o.eh) return this.sh - o.sh;
		else return this.eh - o.eh;
	}
}

public class Doodoo35 {
	
	static StringTokenizer st;
	static int answer = 0;
	static ArrayList<MSched> list;

	public static void main(String[] args) throws IOException {
		// 탐욕 알고리즘 회의실 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			list.add(new MSched(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		mkResrv();
		
		System.out.println(answer);
		

	}
	
	public static void mkResrv() {
		
		// 빨리 끝난 시간부터 ! 
		MSched tmp = list.get(0);
		int s = tmp.sh;
		int e = tmp.eh;
		answer++;
		
		for(int i=1; i<list.size(); i++) {
			MSched c = list.get(i);
			if(e <= c.eh && c.sh >= e) {
				s = c.sh;
				e = c.eh;
				answer++;
			}
		}
		
	}

}
