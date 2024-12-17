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
//		// ���� ĭ�� û�ҵ��� ���� ��� û���� 1�� ����
//		if(board[r][c] == 0 && visited[r][c] == false) {
//			answer++;
//			visited[r][c] = true;
//		}
//		
//		System.out.println(r + " " + c + " " + dir);
//		
//		// û�ҵ��� ���� ��ĭ�� ������ Ȯ��
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
//			// 2������
//			// 2-1 ��ĭ ���� �ϴ´� ���̸�?  
//			Position p = getBakCoord(r, c, dir);
//			if(p.r < 0 || p.r >= n || p.c < 0 || p.c >= m || board[p.r][p.c]== 1 ) {
//				power = false;
//				return;
//			}
//			vacum(p.r, p.c, dir);
//		} else {
//			// 3������
//			// �ϴ� 90�� ȸ�K ���� ��ȯ 
//			// ������ȯ 0 -> 3 , 1 -> 0,  2 -> 1, 3 -> 2
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
		// �κ� û�ұ� (�ùķ��̼�)
		// d�� 0�ΰ�� ����, 1�ΰ�� ����, 2�ΰ�� ����, 3�� ��� ������ �ٶ󺸰� ����.
		
		//1. ���� ĭ�� ���� û�ҵ��� ���� ���, ���� ĭ�� û���Ѵ�.
		//2. ���� ĭ�� �ֺ� 4ĭ�� û�ҵ��� ���� ��ĭ�� ���� ���,
		  // 1. �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �� �ִٸ� �� ĭ �����ϰ� 1������ ���ư���.
		  // 2. �ٶ󺸴� ������ ���� ĭ�� ���̶� ������ �� ���ٸ� �۵��� �����.
		//3. ���� ĭ�� �ֺ� 4ĭ�� û�ҵ��� ���� �� ĭ�� �ִ°��,
		  // 1. �ݽð� �������� 90�� ȸ���Ѵ�.
		  // 2. �ٶ󺸴� ������ �������� ���� ĭ�� û�ҵ��� ���� �� ĭ�� ��� �� ĭ �����Ѵ�.
		  // 3. 1������ ���ư���.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // ����
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// �ù�
		vacum(r, c, d);
		
		System.out.println(answer);
		
		
		

	}
	
	public static Position getBakCoord(int r, int c, int d) {
		// r, c, d �� ������ 
		// d�� 0�ΰ�� ����, 1�ΰ�� ����, 2�ΰ�� ����, 3�� ��� ������ �ٶ󺸰� ����.
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
		//������ȯ 0 -> 3 , 1 -> 0,  2 -> 1, 3 -> 2
		if(d == 0) d = 3;
		else if(d == 1) d = 0;
		else if(d == 2) d = 1;
		else d= 2;
		return d;
	}
	
	public static Position getForCoord(int r, int c, int d) {
		// �ٶ󺸴� �������� ��ĭ Ȯ�� 
		// d�� 0�ΰ�� ����, 1�ΰ�� ����, 2�ΰ�� ����, 3�� ��� ������ �ٶ󺸰� ����.
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
