package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test17090 {
	
	static int answer = 0;
	static int n,m;
	static String[][] board;
	static boolean[][] visited;
	static boolean[][] dp;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static boolean escapeMaze(int y, int x) {
		
		String se = board[y][x];  // 현재위치
		
		int ny, nx;
		
		if(board[y][x].equals("U")) {
			ny = y + dy[0];
			nx = x + dx[0];
		}else if(board[y][x].equals("D")) {
			ny = y + dy[1];
			nx = x + dx[1];
		} else if(board[y][x].equals("L")) {
			ny = y + dy[2];
			nx = x + dx[2];
		} else {
			ny = y + dy[3];
			nx = x + dx[3];
		}
		
		
		
		// 벽을 넘어갔다면 탈출 
		if(ny >= n || ny < 0 || nx >= m || nx < 0) {
			// 탈출 
			answer++;
			dp[y][x] = true;
			return true;
		} else {
			if(dp[ny][nx] == true) {
				dp[y][x] = true;
				answer++;
				return true;
			}
			
			if(visited[ny][nx] == false) {
				visited[ny][nx] = true;
				return dp[y][x] = escapeMaze(ny, nx);
			}
		}
		
		return false;
			
		
		
	}

	public static void main(String[] args) throws IOException{
		// 미로 탈출하기 
		// 각칸에서 시작해서 밖으로 나가는 갯수 합 출력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new String[n][m];
		visited = new boolean[n][m];
		dp = new boolean[n][m];
	
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = String.valueOf(str.charAt(j));
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 계속 칸마다 돌아서 계수를 확인
				if(dp[i][j] == true) {
					answer++;
				} else {
					if(visited[i][j] == false) {
						visited[i][j] = true;
						escapeMaze(i, j);
					}
				}
			}
		}
		
		System.out.println(answer);
		

	}

}
