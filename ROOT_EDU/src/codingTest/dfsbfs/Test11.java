package codingTest.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Test11 {
	
	static int[][] board;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};  // <열> 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};  // <행> 상 하 좌 우
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		board[x][y] = 1;
		
		while(!q.isEmpty()) {
			
			Point curPoint = q.poll();
			
			for(int j=0; j<4; j++) {  // 상하좌우만 이동 가능하니간 
				int nx = curPoint.x + dx[j];
				int ny = curPoint.y + dy[j];
				
				if(nx >= 0 && nx <= 6 && ny >=0 && ny <= 6 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					q.offer(new Point(nx, ny));
					dist[nx][ny] = dist[curPoint.x][curPoint.y] + 1;
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		board = new int[7][7];
		dist = new int[7][7];
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		dist[6][6] = -1;
		
		bfs(0, 0);
		
		System.out.println(dist[6][6]);
		
		

	}

}
