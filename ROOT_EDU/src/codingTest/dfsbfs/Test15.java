package codingTest.dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

class Point2 {
	int x;
	int y;
	
	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Test15 {
	
	static ArrayList<Point2> pizzaStore = new ArrayList<>();
	static ArrayList<Point2> home = new ArrayList<>();
	static int n,m, len;
	static int[][] board;
	static int[] combi;
	static int answer = Integer.MAX_VALUE;
	
	public static void dfs(int idx, int s) {
		
		if(idx == m) {
			
			int sum = 0;
			
			for(Point2 h : home) {
				// 각각 집 하나당 피지집과의 거리 계산에서 최소값 구해 
				int dist = Integer.MAX_VALUE;
				
				for(int i : combi) {
					dist = Math.min(dist, Math.abs(h.x - pizzaStore.get(i).x) + Math.abs(h.y - pizzaStore.get(i).y)) ; 
				}
				
				sum += dist;
				
			}
			
			answer = Math.min(answer, sum);
			
			
		} else {
			for(int i=s; i<len; i++) {
				combi[idx] = i;
				dfs(idx+1, i+1);
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][n];
		combi = new int[m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1) {
					home.add(new Point2(i, j));
				} else if(board[i][j] == 2) {
					pizzaStore.add(new Point2(i, j));
				}
			}
		}
		
		len = pizzaStore.size();
		
		dfs(0, 0);
		
		System.out.println(answer);
		

	}

}
