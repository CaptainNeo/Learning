package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test1987 {
	
	static StringTokenizer st;
	static int r,c;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] board;
	static boolean[][] visited;
	static int answer = 1;
	
	
	public static void exec(int y, int x, ArrayList<Character> list, int move) {
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= 0 && ny < r && nx >= 0 && nx < c && visited[ny][nx] == false && list.contains(board[ny][nx]) == false) {
				visited[ny][nx] = true;
				answer = Math.max(answer, move + 1);
				list.add(board[ny][nx]);
				exec(ny, nx, list, move+1);
				visited[ny][nx] = false;
				list.remove(list.size()-1);
			}
			
		}
			
		
	}
	
	public static void main(String[] args) throws IOException {
		// 알파벳 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		ArrayList<Character> list = new ArrayList<>();
		
		visited[0][0] = true;	// 시작위치
		list.add(board[0][0]);
		
		exec(0, 0, list, 1);
		
		System.out.println(answer);

	}

}
