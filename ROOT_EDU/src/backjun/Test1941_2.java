package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test1941_2 {
	
	static int n, m;
	static String[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] combiY;
	static int[] combiX;
	static int[] combination;
	static int ans = 0;
	
	public static void check() {
		// 이다솜파 학생들이 많아야 한다 4명이상 그리고 7 칠공주 인접해야 한다. 
		boolean[] c = new boolean[m];
		Queue<Integer> q = new LinkedList<>();
		q.add(combination[0]);
		c[0] = true;
		
		int sCnt = 0, cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(map[combiY[cur]][combiX[cur]].equals("S")) sCnt++;
			
			// 현재의 위치에서 상하좌우 에서 인접한 combination 행렬이 있는지 
			for(int i=0; i<4; i++) {
				
				for(int nxt=1; nxt<combination.length; nxt++) {
					
					if(combiY[cur] + dy[i] == combiY[combination[nxt]] && combiX[cur] + dx[i] == combiX[combination[nxt]] && c[nxt] == false) {
						c[nxt] = true;
						q.add(combination[nxt]);
						cnt++;
					}
					
				}
				
			}
			
		}
		
		if(cnt == m && sCnt >= 4) ans++;
		
		
	}
	
	public static void combi(int idx, int num) {
		
		if(idx == m) {
			
			check();
			
			return;
		}
		
		if(num == 25) return;
		
		combination[idx] = num;
		
		combi(idx + 1, num + 1);
		combi(idx, num+1);
		
	}

	public static void main(String[] args) throws IOException {
		// 소문난 칠공주 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = 5; m = 7;
		
		map = new String[n][n];
		
		combiY = new int[25];
		combiX = new int[25];
		
		combination = new int[m];
		
		// 맵에 입력
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = String.valueOf(str.charAt(j)); 
			}
		}
		
		// combination 조합 입력
		for(int i=0; i<25; i++) {
			combiY[i] = i / n;
			combiX[i] = i % n;
		}
		
		
		combi(0, 0);
		
		System.out.println(ans);

	}

}
