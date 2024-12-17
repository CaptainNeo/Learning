package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2468 {
	
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int answer = Integer.MIN_VALUE;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// 안전 영역
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		StringTokenizer st;
		
		int min = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
			}
		}
		
		
		// 비를 내리자 -> 안전지대를 확인하자
		for(int rain=min; rain<=max; rain++) {
			visited = new boolean[n][n];
			
			int tmpValue = 0;
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					if(board[y][x] > rain && visited[y][x] == false) {
						tmpValue += safeZone(y, x, rain);
					}
				}
			}
			
			
			answer = Math.max(answer, tmpValue);
			
		}
		
		System.out.println(answer);
		

	}
	
	public static int safeZone(int y, int x, int rain) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx<0 || ny <0 || nx>n-1 || ny > n-1) continue;
			if(visited[ny][nx]) continue;
			
			if(board[ny][nx] > rain ) {
				safeZone(ny, nx, rain);
			}
		}
		return 1;
	}
	
}
