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
		// ����Ż��2  // �ּҸ������  ���� ������ ������ ���� �����°�(�Ķ����� ���� �ʰ�)
		// �ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. ���� 10�� ���Ϸ� �������� ���� ������ ������ ���� ���� �� ���ٸ� -1 ��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m][n][m];  // �湮
		Bead b = new Bead(0, 0, 0, 0, 0);  // ���� ���� ����
		
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
			
			// ������� 
			for(int i=0; i<4; i++) {  // �����¿�� ��￩ 
				// �ѹ��� ���� �̵��̾� ���庼, ��纼 ������
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
							// ����̴°� ��ĭ ������ 
							ry = ry - dy[i];
							rx = rx - dx[i];
						} else if(map[ry][rx] == 'O') {
							// �����̾� 
							rmove = false;
							rgoal = true;
						}
					}
					
				}  // ������ ����̱�
				
				while(bmove) {
					by = by + dy[i];
					bx = bx + dx[i];
					
					if(by >= 0 && by < n && bx >= 0 && bx < m) {
						if(map[by][bx] == '#') {
							bmove = false;
							// ����̴°� ��ĭ ������ 
							by = by - dy[i];
							bx = bx - dx[i];
						} else if(map[by][bx] == 'O') {
							// �����̾� 
							bmove = false;
							bgoal = true;
						}
					}
				}
				
				if(rgoal == true && bgoal == false) {
					answer = Math.min(answer, count + 1);
					break;
				} else if(rgoal == false && bgoal == false) {
					// �ΰ��� ���� �پ�������� ��� 
					if(ry == by && rx == bx) {
						calCoord(cur, ry, rx, by, bx, count, i);
					} else if(visited[ry][rx][by][bx] == false) {
						visited[ry][rx][by][bx] = true;
						q.add(new Bead(ry, rx, by, bx, count+1));
					}
					
				}
				
				
			}  // end for ����̱� 
			
			
			
		}  // end for while
		
		
		
	}  // end for leanBead
	
	public static void calCoord(Bead cur, int ry, int rx, int by, int bx, int count, int dir) {
		
		// dir �����¿� ��￴����� ��� 
		if(dir == 0) {  // ��
			if(cur.ry < cur.by) {  // �������� �� ���� �ִٸ� �Ķ����� ������ ������� �Ѵ�.
				by = by + 1;
			} else {
				ry = ry + 1;
			}
		} else if(dir == 1) {  // ��
			if(cur.ry > cur.by) {  // �������� �� �Ʒ��� �ִٸ� �Ķ����� ���� �÷���� �Ѵ�.
				by = by - 1;
			} else {
				ry = ry - 1;
			}
		} else if(dir == 2) {  // ��
			if(cur.rx < cur.bx) {  // �������� �� ������ �ִٸ� �Ķ����� �������� �̵����� ����Ѵ�.
				bx = bx + 1;
			} else {
				rx = rx + 1;
			}
		} else {  // ��
			if(cur.rx > cur.bx) {  // �������� �� ������ �ִٸ� �Ķ����� �������� �̵����� ����Ѵ�.
				bx = bx -1;
			} else {
				rx = rx -1;
			}
		}
		
		// ���� �������� ������ �����ٸ� �ش� ������ ť�� �־� 
		if(visited[ry][rx][by][bx] == false) {
			visited[ry][rx][by][bx] = true;
			q.add(new Bead(ry, rx, by, bx, count + 1));
		}
		
		
	}
	

}
