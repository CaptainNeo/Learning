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
		// 사다리조작  // 진자 너무너무 어려운거야 이거...
		// i번 순서의 세로선의 결과가 i번이 되도록 가로선을 긋는대 그 가로선의 최솟값을 출력. 단, 3초과면 -1 아에 불가능해도 -1 출력 
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
			map[row][col] = 1;  // 우측으로
			map[row][col+1] = -1;  // 좌측으로 
		}
		
		// 이제 한개씩 가로선을 그어야되는대 딱 3번만 그어 더 그으면 -1이 정답이야
		
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
		
		// 가로선을 그어 
		for(int i=r; i <= h; i++) {
			for(int j=1; j<n; j++) {  // 그다음 세로줄이 없으니 n전까지만 
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
		
		for(int i=1; i<=n; i++) {  // i번의 줄이니간 컬럼줄을 내려 
			
			int row = 1, col = i;
			
			for(int j=1; j<=h; j++) { // 행을 끝까지 내려가기위해서 행만큼 반복문  
				// 각각의 행을 내려가보자 
				if(map[row][col] == 1) col++;
				else if(map[row][col] == -1) col--;
				row++;  // 조건에 안맞으면 계속 행을 내려가 
			}
			
			if(col != i) return false;
			
		}
		
		return true;
	}

}
