package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2580 {
	
	static int r = 9;
	static int c = 9;
	static int[][] map = new int[r][c];
	static boolean[][] visited = new boolean[r][c];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void sdoku(int y, int x) {
		
		if(x == 9) {
			sdoku(y+1, 0);
			return;
		}
		
		if(y == 9) {
			// �������� 
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			System.exit(0);
		}  // end for y
		
		if(map[y][x] == 0) {
			// ��ĭ 1~9���� �־�� �Ǵ�
			for(int i=1; i<=9; i++) {
				if(check(y, x, i)) {
					map[y][x] = i;
					sdoku(y, x+1);
				}
			}
			
			map[y][x] = 0;
			return;
		}
		
		
		sdoku(y, x + 1); // �÷��� �ϳ��� �÷����� ����
		
	}
	
	public static boolean check(int y, int x, int v) {
		
		// ��, ��, ��ĭ  �ߺ��Ǿ����� Ȯ��
		for(int i=0; i<9; i++) {
			if(map[y][i] == v) return false;
		}
		
		for(int i=0; i<9; i++) {
			if(map[i][x] == v) return false;
		}
		
		int setY = (y / 3) * 3;
		int setX = (x / 3) * 3;
		
		for(int i=setY; i<setY + 3; i++) {
			for(int j=setX; j<setX + 3; j++) {
				if(map[i][j] == v) return false;
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// ���� 2580 ������ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sdoku(0, 0);

	}

}
