package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bead {
	int ry;
	int rx;
	int by;
	int bx;
	int count;
	
	Bead(int ry, int rx, int by, int bx, int count) {
		this.ry = ry;
		this.rx = rx;
		this.by = by;
		this.bx = bx;
		this.count = count;
	}
}

public class Test13460 {
	
	static int answer = Integer.MAX_VALUE;
	static int n,m;
	static char[][] map;
	static boolean[][][][] visited;
	static StringTokenizer st;
	static Queue<Bead> q = new LinkedList<>();
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// 구슬탈출2  // 최소몇번만에  빨간 구슬이 구멍을 통해 나가는가(파란구슬 들어가지 않고)
		// 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없다면 -1 출력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m][n][m];  // 방문
		Bead b = new Bead(0, 0, 0, 0, 0);  // 최초 구슬 정보
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					b.ry = i;
					b.rx = j;
				} else if(map[i][j] == 'B') {
					b.by = i;
					b.bx = j;
				}
			}
		}
		
		visited[b.ry][b.rx][b.by][b.bx] = true;
		q.add(b);
		
		leanBead();
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
		
		

	}
	
	public static void leanBead() {
		
		
		while(!q.isEmpty()) {
			
			Bead cur = q.poll();
			
			if(cur.count == 10) break;
			
			// 기울이자 
			for(int i=0; i<4; i++) {  // 상하좌우로 기울여 
				// 한번에 같이 이동이야 레드볼, 블루볼 순으로
				int ry = cur.ry;
				int rx = cur.rx;
				int by = cur.by;
				int bx = cur.bx;
				int count = cur.count;
				
				boolean rmove = true;
				boolean rgoal = false;
				boolean bmove = true;
				boolean bgoal = false;
				
				while(rmove) {
					ry = ry + dy[i];
					rx = rx + dx[i];
					if(ry >= 0 && ry < n && rx >= 0 && rx < m) {
						if(map[ry][rx] == '#') {
							rmove = false;
							// 기울이는곳 한칸 전으로 
							ry = ry - dy[i];
							rx = rx - dx[i];
						} else if(map[ry][rx] == 'O') {
							// 구멍이야 
							rmove = false;
							rgoal = true;
						}
					}
					
				}  // 빨간공 기울이기
				
				while(bmove) {
					by = by + dy[i];
					bx = bx + dx[i];
					
					if(by >= 0 && by < n && bx >= 0 && bx < m) {
						if(map[by][bx] == '#') {
							bmove = false;
							// 기울이는곳 한칸 전으로 
							by = by - dy[i];
							bx = bx - dx[i];
						} else if(map[by][bx] == 'O') {
							// 구멍이야 
							bmove = false;
							bgoal = true;
						}
					}
				}
				
				if(rgoal == true && bgoal == false) {
					answer = Math.min(answer, count + 1);
					break;
				} else if(rgoal == false && bgoal == false) {
					// 두개의 볼이 붙어있을경우 계산 
					if(ry == by && rx == bx) {
						calCoord(cur, ry, rx, by, bx, count, i);
					} else if(visited[ry][rx][by][bx] == false) {
						visited[ry][rx][by][bx] = true;
						q.add(new Bead(ry, rx, by, bx, count+1));
					}
					
				}
				
				
			}  // end for 기울이기 
			
			
			
		}  // end for while
		
		
		
	}  // end for leanBead
	
	public static void calCoord(Bead cur, int ry, int rx, int by, int bx, int count, int dir) {
		
		// dir 상하좌우 기울였을경우 계산 
		if(dir == 0) {  // 상
			if(cur.ry < cur.by) {  // 빨간공이 더 위에 있다면 파란공을 밑으로 내려줘야 한다.
				by = by + 1;
			} else {
				ry = ry + 1;
			}
		} else if(dir == 1) {  // 하
			if(cur.ry > cur.by) {  // 빨간공이 더 아래에 있다면 파란공을 위로 올려줘야 한다.
				by = by - 1;
			} else {
				ry = ry - 1;
			}
		} else if(dir == 2) {  // 좌
			if(cur.rx < cur.bx) {  // 빨간공이 더 좌측에 있다면 파란공을 우측으로 이동시켜 줘야한다.
				bx = bx + 1;
			} else {
				rx = rx + 1;
			}
		} else {  // 우
			if(cur.rx > cur.bx) {  // 빨간공이 더 우측에 있다면 파란공을 좌측으로 이동시켜 줘야한다.
				bx = bx -1;
			} else {
				rx = rx -1;
			}
		}
		
		// 붙은 구슬들의 조정이 끝났다면 해당 구슬을 큐에 넣어 
		if(visited[ry][rx][by][bx] == false) {
			visited[ry][rx][by][bx] = true;
			q.add(new Bead(ry, rx, by, bx, count + 1));
		}
		
		
	}
	

}
