package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Test2667 {
	
	static int n;
	static int[][] apt;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int cnt = 0;
	static int tmp;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		// 단지번호붙이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		apt = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				apt[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		
		execFn();
		Collections.sort(list);
		
		System.out.println(cnt);
		for(int x : list) {
			System.out.println(x);
		}

	}
	
	public static void execFn() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(apt[i][j] == 1 && visited[i][j] == false) {
					tmp = 1;
					cnt++;
					visited[i][j] = true;
					cnnApt(i, j);
					list.add(tmp);
				}
			}
		}
		
		
	}
	
	public static void cnnApt(int y, int x) {
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >=0 && ny < n && nx >=0 && nx < n && apt[ny][nx] == 1 && visited[ny][nx] == false) {
				tmp++;
				visited[ny][nx] = true;
				cnnApt(ny, nx);
			}
		}
		
	}

}
