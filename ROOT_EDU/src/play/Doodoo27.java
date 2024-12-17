package play;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Doodoo27 {

	public static void main(String[] args) {
		// 공주구하기 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		
		int cnt = 0; 
		
		while(q.size() > 1) {
			
			cnt++;
			
			if(cnt == m) {
				cnt = 0;
				q.poll();
			} else {
				int tmp = q.poll();
				q.add(tmp);
			}
			
		}
		
		System.out.println(q.poll());

	}

}
