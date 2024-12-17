package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Wolf {
	int r;
	int c;
	
	Wolf(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Test16956 {
	
	static int R,C;
	static String[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static StringTokenizer st;
	static boolean chk = true;
	
	public static void hunting(int r, int c) {
		
		if(map[r][c].equals("S")) {
			chk = false;
			return;
		} else {
			for(int i=0; i<4; i++) {
				int nr = r + dy[i];
				int nc = c + dx[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !map[nr][nc].equals("W") && !map[nr][nc].equals("D") && visited[nr][nc] == false  ) {
					visited[nr][nc] = true;
					hunting(nr, nc);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// ����� ��    2�� �ð� �ֳ� dfs�� Ǯ��  "D"�� �ξ ���ƾ� �ϴ´�...
		// D�� �δ°ſ� 
		// W �������� ������ �����ִ��� Ȯ���ϴ°� �ϳ��� �־�� �ǳ� 
		
		// ��Ÿ���� �ּҰ� �Ǵ� ������ �ƴϴ� ��Ÿ���� �� ������ �ȴٴ� �ֱ��̳�
		// �׷� �̵���ο� ���δ� �־���� D�� 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		
		ArrayList<Wolf> list = new ArrayList<>();
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
				if(map[i][j].equals(".")) map[i][j] = "D";
				if(map[i][j].equals("W")) list.add(new Wolf(i, j));
			}
		}
		
		
		for(Wolf w : list) {
			visited = new boolean[R][C];
			visited[w.r][w.c] = true;
			hunting(w.r, w.c);
		}
			
		
		if(chk) {  // ���밡 ������ ���� ���Ѵ�.
			System.out.println("1");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} else {
			System.out.println("0");
		}
		
		

	}

}
