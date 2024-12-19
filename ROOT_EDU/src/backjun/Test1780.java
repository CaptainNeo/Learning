package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1780 {
	
	// 종이의 개수 
	
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int cntMinus = 0;
	static int cntZero = 0;
	static int cntOne = 0;

	public static void main(String[] args) throws IOException {
		// 종이의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, n);
		
		System.out.println(cntMinus);
		System.out.println(cntZero);
		System.out.println(cntOne);

	}
	
	public static void partition(int r, int c, int size) {
		
		if(check(r, c, size)) {
			
			if(map[r][c] == -1) {
				cntMinus++;
			} else if(map[r][c] == 0) {
				cntZero++;
			} else {
				cntOne++;
			}
		
			return;
		}
		
		// 9 등분으로 잘라야 한다. 
		
		int newSize = size / 3;
		
		// 왼쪽 위, 중앙 위, 오른쪽 위 
		partition(r, c, newSize);
		partition(r, c + newSize, newSize);
		partition(r, c + 2 * newSize, newSize);
		
		// 왼쪽 중앙, 중앙 중앙, 오른쪽 중앙 
		partition(r + newSize, c, newSize);
		partition(r + newSize, c + newSize, newSize);
		partition(r + newSize, c + 2 * newSize, newSize);
		
		// 왼쪽 아래, 중앙 아래, 오른쪽 아래
		partition(r + 2 * newSize, c, newSize);
		partition(r + 2 * newSize, c + newSize, newSize);
		partition(r + 2 * newSize, c+2 * newSize, newSize);
		
		
	}
	
	public static boolean check(int r, int c, int size) {
		
		int color = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}
