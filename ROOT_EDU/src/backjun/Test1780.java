package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1780 {
	
	// ������ ���� 
	
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int cntMinus = 0;
	static int cntZero = 0;
	static int cntOne = 0;

	public static void main(String[] args) throws IOException {
		// ������ ����
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
		
		// 9 ������� �߶�� �Ѵ�. 
		
		int newSize = size / 3;
		
		// ���� ��, �߾� ��, ������ �� 
		partition(r, c, newSize);
		partition(r, c + newSize, newSize);
		partition(r, c + 2 * newSize, newSize);
		
		// ���� �߾�, �߾� �߾�, ������ �߾� 
		partition(r + newSize, c, newSize);
		partition(r + newSize, c + newSize, newSize);
		partition(r + newSize, c + 2 * newSize, newSize);
		
		// ���� �Ʒ�, �߾� �Ʒ�, ������ �Ʒ�
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
