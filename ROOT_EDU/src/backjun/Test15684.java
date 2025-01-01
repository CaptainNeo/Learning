package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test15684 {
	
	static int n,m,h;
	
	static int[][] map;
	static StringTokenizer st;
	static boolean finish = false;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		// ��ٸ�����  // ���� �ʹ��ʹ� �����ž� �̰�...
		// i�� ������ ���μ��� ����� i���� �ǵ��� ���μ��� �ߴ´� �� ���μ��� �ּڰ��� ���. ��, 3�ʰ��� -1 �ƿ� �Ұ����ص� -1 ��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;  // ��������
			map[row][col+1] = -1;  // �������� 
		}
		
		// ���� �Ѱ��� ���μ��� �׾�ߵǴ´� �� 3���� �׾� �� ������ -1�� �����̾�
		
		for(int i=0; i<=3; i++) {
			answer = i;
			dfs(1, 0);
			if(finish) break;
		}
		
		System.out.println((finish) ? answer : -1);
		
		
	}
	
	public static void dfs(int r, int cnt) {
		
		if(finish) return;
		if(answer == cnt) {
			if(check()) finish = true;
			return;
		}
		
		// ���μ��� �׾� 
		for(int i=r; i <= h; i++) {
			for(int j=1; j<n; j++) {  // �״��� �������� ������ n�������� 
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = -1;
					dfs(i, cnt + 1);
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
		
	}
	
	public static boolean check() {
		
		for(int i=1; i<=n; i++) {  // i���� ���̴ϰ� �÷����� ���� 
			
			int row = 1, col = i;
			
			for(int j=1; j<=h; j++) { // ���� ������ �����������ؼ� �ุŭ �ݺ���  
				// ������ ���� ���������� 
				if(map[row][col] == 1) col++;
				else if(map[row][col] == -1) col--;
				row++;  // ���ǿ� �ȸ����� ��� ���� ������ 
			}
			
			if(col != i) return false;
			
		}
		
		return true;
	}

}
