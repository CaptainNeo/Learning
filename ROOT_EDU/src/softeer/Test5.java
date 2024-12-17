package softeer;

import java.util.ArrayList;
import java.util.Scanner;

class Spot {
	int y;
	int x;
	Spot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Test5 {
	
	static int n,m;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Spot> spot = new ArrayList<>();
	static int cnt = 0;
	
	public static void drive(int y, int x, int idx) {
		
		// 확인 
		if(y == spot.get(idx).y && x == spot.get(idx).x) {
			
			if(idx == m-1) {
				cnt++;
				return;
			}
			
			idx++;
			
		}
		
			
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0 && visited[ny][nx] == false) {
				drive(ny, nx, idx);
			}
		}
		visited[y][x] = false;
			
			
		
		
	}

	public static void main(String[] args) {
		// LV3 문제 순서대로 방문하기 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][n];
		
		// 시작점으로 호출하고 끝점에 다다를때 카운트 하는대 순서대로 지나왔는지를 확인해야되는대?
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 지점 m개 저장 
		for(int i=0; i<m; i++) {
			spot.add(new Spot(sc.nextInt()-1, sc.nextInt()-1));
		}
		
		visited = new boolean[n][n];
		drive(spot.get(0).y, spot.get(0).x, 1);  // 출발 , 방문한지점의 수 
		
		
		System.out.println(cnt);
		
		
		
		
		
		

	}

}
