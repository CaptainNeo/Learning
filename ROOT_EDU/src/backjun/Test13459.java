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
		// ����Ż��
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
			
			// ������ ��������. �����¿��� �������� ť�� �׾�
			for(int i=0; i<4; i++) {
				boolean rflag = true;
				boolean rgoal = false;
				boolean bflag = true;
				boolean bgoal = false;
				
				int ry = cur.ry;
				int rx = cur.rx;
				int by = cur.by;
				int bx = cur.bx;
				
				// ������
				while(rflag) {
					
					ry = ry + dy[i];
					rx = rx + dx[i];
					
					if(ry >= 0 && ry < n && rx >= 0 && rx < m) {
						if(map[ry][rx] == '#') {  // ���̶��
							rflag = false;
							ry = ry - dy[i];
							rx = rx - dx[i];
						} else if(map[ry][rx] == 'O') {
							rgoal = true;
							rflag = false;
						}
					}
					
				}  // end for while rflag
				
				// �Ķ��� 
				while(bflag) {
					
					by = by + dy[i];
					bx = bx + dx[i];
					
					if(by >= 0 && by < n && bx >= 0 && bx < m) {
						if(map[by][bx] == '#') {  // ���̶��
							bflag = false;
							by = by - dy[i];
							bx = bx - dx[i];
						} else if(map[by][bx] == 'O') {
							bgoal = true;
							bflag = false;
						}
					}
					
				}  // end for while bflag
				
				// �����ΰ��� �Ѳ����� �̵����ִ�.
				if(rgoal == true && bgoal == false) {
					answer = 1;
					return;
				} else if(rgoal == false && bgoal == false) {
					if(ry == by && rx == bx) {  // 2���� ���� ��ĥ���
						recoordination(cur, ry, rx, by, bx, i);
					} else if(visited[ry][rx][by][bx] == false) {
						visited[ry][rx][by][bx] = true;
						q.add(new BallInfo(ry, rx, by, bx, cur.count + 1));
					}
				}
				
			}  // end for �����¿�
			
			
			
		}  // end for while q
	 
		
	}
	
	public static void recoordination(BallInfo ballInfo, int ry, int rx, int by, int bx, int i) {
		
		int cry = ballInfo.ry;
		int crx = ballInfo.rx;
		int cby = ballInfo.by;
		int cbx = ballInfo.bx;
		
		if(i == 0) {  // ��
			if(cry < cby) {
				by = by + 1;
			} else {
				ry = ry + 1;
			}
			
		} else if(i == 1) {  // ��
			if(cry > cby) {  // ���庼�� �� ũ�ٸ� 
				by = by - 1;
			} else {
				ry = ry - 1;
			}
			
		} else if(i == 2) {  // ��
			if(crx < cbx) {  // ���庼�� �� �������̶��
				bx = bx + 1;
			} else {
				rx = rx + 1;
			}
		} else {  // ��
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
