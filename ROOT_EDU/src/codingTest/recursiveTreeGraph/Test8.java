package codingTest.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test8 {
	
	static Queue<Integer> q = new LinkedList<>();
	static int[] pos = {1, -1, 5};
	
	public static void bfs(int start, int end) {
		
		boolean[] visited = new boolean[10001];
		
		visited[start] = true;
		q.offer(start);
		int level = 0;
		
		while(!q.isEmpty()) {
			int len = q.size();
			
			for(int i=0; i<len; i++) {
				int curPosition = q.poll();
				
				for(int j=0; j<3; j++) {
					int nx = curPosition + pos[j];
					if(nx == end) {
						System.out.println(level + 1);
						return;
					}
					if(nx >= 1 && nx <= 10000 && visited[nx] == false) {
						q.offer(nx);
						visited[nx] = true;
					}
				}
				
			}
			
			level++;
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		int e = sc.nextInt();
		
		bfs(s, e);

	}

}
