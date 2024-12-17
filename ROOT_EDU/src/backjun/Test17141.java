package backjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Virus {
	int y;
	int x;
	Virus(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Test17141 {
	static int[] dy = {-1, 1, 0, 0}; // �����¿�
	static int[] dx = {0, 0, -1, 1};
	static int n,m;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Virus> list = new ArrayList<Virus>();
	static int count = 0;
	static int[] virusIdx;
	static int answer = Integer.MAX_VALUE;
	
	public static void doSpray() {
		
		Queue<Virus> q = new LinkedList<>();
		
		for(int x : virusIdx) {
			if(x != -1) {
				Virus v = list.get(x);
				q.add(v);
				visited[v.y][v.x] = true; 
			}
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			
			int len = q.size();
			
			for(int i=0; i<len; i++) {
				Virus v = q.poll();
				
				// ���̷��� ��ġ
				for(int j=0; j<4; j++) {
					int ny = v.y + dy[j];
					int nx = v.x + dx[j];
					if(ny >=0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0 && visited[ny][nx] == false) {
						visited[ny][nx] = true;
						q.offer(new Virus(ny, nx));
					}
				}
				
			}
			
			if(q.size() > 0) {
				cnt++;
			}
			
		}
		
		if(check()) {
			answer = Math.min(answer, cnt);
		}
		
		
		
	}
	
	public static boolean check() {
		
		boolean flag = true;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] != 1 && visited[i][j] == false) {
					flag = false;
				}
			}
		}
		
		return flag;
		
	}
	
	
	public static void putVirus(int idx, int s) {
		
		// ������ ���̷��� 3���� �̾�
		if(idx == m) {
			visited = new boolean[n][n];
			doSpray();
		} else { 
			for(int i=s; i<list.size(); i++) {
				virusIdx[idx] = i;
				putVirus(idx + 1, i + 1);
				virusIdx[idx] = -1;
			}
			
		}
		
	}

	public static void main(String[] args) {
		// ������ 2 
		// ���̷����� ������ 1 ���� ũ�� 10���� ������ dfs ������ �ǰڳ� 
		// ������ 2���̷����� ������ �ִ�ĭ�� 3���� �������� ���� �ùķ��̼��� �������ߵ� .. 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		virusIdx = new int[m];
		Arrays.fill(virusIdx, -1);
		
		board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int tmp = sc.nextInt();
				if(tmp == 2) {
					list.add(new Virus(i, j));
					board[i][j] = 0;
				} else {
					board[i][j] = tmp;
				}
			}
		}
		
		
		putVirus(0, 0);  // ���̷����� ����
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
		

	}

}
