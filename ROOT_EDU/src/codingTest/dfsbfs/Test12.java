package codingTest.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
	int x,y;
	
	Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Test12 {
	
	static int n,m;
	static int[][] box;
	static int[][] days;
	static Queue<Tomato> q = new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0};    // 행  // 최초 토마토 객체에 넣을때 i, j 로 넣었어 행 열로 
	static int[] dy = {0, 0, -1, 1};    // 열
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Tomato curTomato = q.poll();
			for(int i=0; i<4; i++) {
				int nx = curTomato.x + dx[i];
				int ny = curTomato.y + dy[i];
//				System.out.println("nx  : " + nx + "   " + "ny : " + ny);
				if(nx >=0 && nx < n && ny >=0 && ny < m && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					q.offer(new Tomato(nx,ny));
					days[nx][ny] = days[curTomato.x][curTomato.y] + 1;
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		// 토마토
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		box = new int[n][m];
		days = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) {
					q.offer(new Tomato(i,j));
				} 
			}
		}
		
		bfs();
		
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		// 익지않는 토마토 있는 경우 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 0) flag = false;
			}
		}
		
		if(flag) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					answer = Math.max(answer, days[i][j]);
				}
			}	
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
		

	}

}
