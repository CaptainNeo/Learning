package codingTest.dfsbfs;

import java.util.Scanner;

public class Test13 {
	
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int answer;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};  // 시계방향
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void dfs(int x, int y) {
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1 && visited[nx][ny] == false) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		board = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					answer++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
		

	}

}
