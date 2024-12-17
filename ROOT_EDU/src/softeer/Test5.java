package softeer;

import java.util.ArrayList;
import java.util.Scanner;

class Spot {
	int y;
	int x;
	Spot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Test5 {
	
	static int n,m;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Spot> spot = new ArrayList<>();
	static int cnt = 0;
	
	public static void drive(int y, int x, int idx) {
		
		// Ȯ�� 
		if(y == spot.get(idx).y && x == spot.get(idx).x) {
			
			if(idx == m-1) {
				cnt++;
				return;
			}
			
			idx++;
			
		}
		
			
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0 && visited[ny][nx] == false) {
				drive(ny, nx, idx);
			}
		}
		visited[y][x] = false;
			
			
		
		
	}

	public static void main(String[] args) {
		// LV3 ���� ������� �湮�ϱ� 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][n];
		
		// ���������� ȣ���ϰ� ������ �ٴٸ��� ī��Ʈ �ϴ´� ������� �����Դ����� Ȯ���ؾߵǴ´�?
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// ���� m�� ���� 
		for(int i=0; i<m; i++) {
			spot.add(new Spot(sc.nextInt()-1, sc.nextInt()-1));
		}
		
		visited = new boolean[n][n];
		drive(spot.get(0).y, spot.get(0).x, 1);  // ��� , �湮�������� �� 
		
		
		System.out.println(cnt);
		
		
		
		
		
		

	}

}
