package codingTest.dfsbfs;

import java.util.Scanner;

public class Test10 {
	
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};  // <��> �� �� �� ��
	static int[] dy = {-1, 1, 0, 0};  // <��> �� �� �� ��
	static int answer = 0;
	
	public static void dfs(int x, int y) {
		if(x == 6 && y == 6) {
			answer++;
			return;
		} else {
			for(int i=0; i<4; i++) {  // �����¿츸 �̵� �����ϴϰ� 
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx <= 6 && ny >=0 && ny <= 6 && board[nx][ny] == 0 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					dfs(nx, ny);
					visited[nx][ny] = false;
				}
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		board = new int[7][7];
		visited = new boolean[7][7];
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		visited[0][0] = true;
		
		dfs(0, 0);
		
		System.out.println(answer);
		

	}

}
