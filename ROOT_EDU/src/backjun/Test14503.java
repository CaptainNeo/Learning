package backjun;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Position {
	int r;
	int c;
	
	public Position(int r, int c) {
		this.r = r;
		this.c = c;
	}

	
}

public class Test14503 {
	
	static int n,m,d;
	static int[][] board;
	static boolean[][] visited;
	static int answer = 0;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean power = true;
	
	public static void vacum(int r, int c, int dir) {
		
		if(board[r][c] == 0 && visited[r][c] == false) {
			answer++;
			visited[r][c] = true;
		}
		
		for(int i=0; i<4; i++) {
			dir = getDirection(dir);
			Position p = getForCoord(r, c, dir);
			
			if(board[p.r][p.c] == 0 && visited[p.r][p.c] == false) {
				vacum(p.r, p.c, dir);
				return;
			}
		}
		
		Position p = getBakCoord(r, c, dir);
		if(p.r < 0 || p.r >= n || p.c < 0 || p.c >= m || board[p.r][p.c]== 1 ) {
			return;
		} else {
			vacum(p.r, p.c, dir);
		}
		
		
		
//		if(!power) return;
//		
//		// 현재 칸이 청소되지 않은 경우 청소해 1번 구현
//		if(board[r][c] == 0 && visited[r][c] == false) {
//			answer++;
//			visited[r][c] = true;
//		}
//		
//		System.out.println(r + " " + c + " " + dir);
//		
//		// 청소되지 않은 빈칸이 없는지 확인
//		boolean allClean = true;
//		int ny, nx;
//		for(int i=0; i<4; i++) {
//			ny = r + dy[i];
//			nx = c + dx[i];
//			if(board[ny][nx] == 0 && visited[ny][nx] == false) {
//				allClean = false;
//				break;
//			}
//		}
//		
//		if(allClean) {
//			// 2번구현
//			// 2-1 한칸 후진 하는대 벽이면?  
//			Position p = getBakCoord(r, c, dir);
//			if(p.r < 0 || p.r >= n || p.c < 0 || p.c >= m || board[p.r][p.c]== 1 ) {
//				power = false;
//				return;
//			}
//			vacum(p.r, p.c, dir);
//		} else {
//			// 3번구현
//			// 일단 90도 회줜 방향 전환 
//			// 방향전환 0 -> 3 , 1 -> 0,  2 -> 1, 3 -> 2
//			for(int i=0; i<4; i++) {
//				dir = getDirection(dir);
//				Position p = getForCoord(r, c, dir);
//				
//				if(board[p.r][p.c] == 0 && visited[p.r][p.c] == false) {
//					vacum(p.r, p.c, dir);
//					break;
//				}
//			}
//			
//		}
		
	}

	public static void main(String[] args) throws IOException {
		// 로봇 청소기 (시뮬레이션)
		// d가 0인경우 북쪽, 1인경우 동쪽, 2인경우 남쪽, 3인 경우 서쪽을 바라보고 있음.
		
		//1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
		//2. 현재 칸의 주변 4칸중 청소되지 않은 비칸이 없는 경우,
		  // 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
		  // 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
		//3. 현재 칸의 주변 4칸중 청소되지 않은 빈 칸이 있는경우,
		  // 1. 반시계 방향으로 90도 회전한다.
		  // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
		  // 3. 1번으로 돌아간다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 방향
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 시뮬
		vacum(r, c, d);
		
		System.out.println(answer);
		
		
		

	}
	
	public static Position getBakCoord(int r, int c, int d) {
		// r, c, d 가 왔을떄 
		// d가 0인경우 북쪽, 1인경우 동쪽, 2인경우 남쪽, 3인 경우 서쪽을 바라보고 있음.
		Position p = new Position(r, c);
		if(d == 0) {
			p.r = r+1;
			p.c = c;
		} else if(d == 1) {
			p.r = r;
			p.c = c - 1;
		} else if(d == 2) {
			p.r = r-1;
			p.c = c;
		} else {
			p.r = r;
			p.c = c + 1;
		}
		
		
		return p;
		
	}
	
	public static int getDirection(int d) {
		//방향전환 0 -> 3 , 1 -> 0,  2 -> 1, 3 -> 2
		if(d == 0) d = 3;
		else if(d == 1) d = 0;
		else if(d == 2) d = 1;
		else d= 2;
		return d;
	}
	
	public static Position getForCoord(int r, int c, int d) {
		// 바라보는 방향으로 앞칸 확인 
		// d가 0인경우 북쪽, 1인경우 동쪽, 2인경우 남쪽, 3인 경우 서쪽을 바라보고 있음.
		Position p = new Position(r, c);
		if(d == 0) {
			p.r = r-1;
			p.c = c;
		} else if(d == 1) {
			p.r = r;
			p.c = c + 1;
		} else if(d == 2) {
			p.r = r + 1;
			p.c = c;
		} else {
			p.r = r;
			p.c = c - 1;
		}
		
		return p;
		
	}

}
