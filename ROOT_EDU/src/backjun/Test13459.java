package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BallInfo {
	int ry;
	int rx;
	int by;
	int bx;
	int count;
	BallInfo(int ry, int rx, int by, int bx, int count) {
		this.ry = ry;
		this.rx = rx;
		this.by = by;
		this.bx = bx;
		this.count = count;
	}
}

public class Test13459 {
	
	static int n,m;
	static char[][] map;
	static StringTokenizer st;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<BallInfo> q = new LinkedList<>();
	static BallInfo ballInfo = new BallInfo(0, 0, 0, 0, 0);
	static boolean[][][][] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// 구슬탈출
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		map = new char[n][m];
		visited = new boolean[n][m][n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					ballInfo.ry = i;
					ballInfo.rx = j;
				} else if(map[i][j] == 'B') {
					ballInfo.by = i; 
					ballInfo.bx = j;
				}
			}
		}
		
		visited[ballInfo.ry][ballInfo.rx][ballInfo.by][ballInfo.bx] = true;
		
		doLean();
		
		System.out.println(answer);
		
		
		
	}
	
	public static void doLean() {
		
		q.add(ballInfo);
		
		while(!q.isEmpty()) {
			
			BallInfo cur = q.poll();
			
			if(cur.count == 10) return;
			
			// 구슬을 움직이자. 상하좌우의 구슬들을 큐에 쌓아
			for(int i=0; i<4; i++) {
				boolean rflag = true;
				boolean rgoal = false;
				boolean bflag = true;
				boolean bgoal = false;
				
				int ry = cur.ry;
				int rx = cur.rx;
				int by = cur.by;
				int bx = cur.bx;
				
				// 빨간공
				while(rflag) {
					
					ry = ry + dy[i];
					rx = rx + dx[i];
					
					if(ry >= 0 && ry < n && rx >= 0 && rx < m) {
						if(map[ry][rx] == '#') {  // 벽이라면
							rflag = false;
							ry = ry - dy[i];
							rx = rx - dx[i];
						} else if(map[ry][rx] == 'O') {
							rgoal = true;
							rflag = false;
						}
					}
					
				}  // end for while rflag
				
				// 파란공 
				while(bflag) {
					
					by = by + dy[i];
					bx = bx + dx[i];
					
					if(by >= 0 && by < n && bx >= 0 && bx < m) {
						if(map[by][bx] == '#') {  // 벽이라면
							bflag = false;
							by = by - dy[i];
							bx = bx - dx[i];
						} else if(map[by][bx] == 'O') {
							bgoal = true;
							bflag = false;
						}
					}
					
				}  // end for while bflag
				
				// 구슬두개를 한꺼번에 이동시켯다.
				if(rgoal == true && bgoal == false) {
					answer = 1;
					return;
				} else if(rgoal == false && bgoal == false) {
					if(ry == by && rx == bx) {  // 2개의 공이 겹칠경우
						recoordination(cur, ry, rx, by, bx, i);
					} else if(visited[ry][rx][by][bx] == false) {
						visited[ry][rx][by][bx] = true;
						q.add(new BallInfo(ry, rx, by, bx, cur.count + 1));
					}
				}
				
			}  // end for 상하좌우
			
			
			
		}  // end for while q
	 
		
	}
	
	public static void recoordination(BallInfo ballInfo, int ry, int rx, int by, int bx, int i) {
		
		int cry = ballInfo.ry;
		int crx = ballInfo.rx;
		int cby = ballInfo.by;
		int cbx = ballInfo.bx;
		
		if(i == 0) {  // 상
			if(cry < cby) {
				by = by + 1;
			} else {
				ry = ry + 1;
			}
			
		} else if(i == 1) {  // 하
			if(cry > cby) {  // 레드볼이 더 크다면 
				by = by - 1;
			} else {
				ry = ry - 1;
			}
			
		} else if(i == 2) {  // 좌
			if(crx < cbx) {  // 레드볼이 더 작은값이라면
				bx = bx + 1;
			} else {
				rx = rx + 1;
			}
		} else {  // 우
			if(crx > cbx) {
				bx = bx - 1;
			} else {
				rx = rx - 1;
			}
		}
		
		if(visited[ry][rx][by][bx] == false) {
			visited[ry][rx][by][bx] = true;
			q.add(new BallInfo(ry, rx, by, bx, ballInfo.count + 1));
		}
		
	}

}
