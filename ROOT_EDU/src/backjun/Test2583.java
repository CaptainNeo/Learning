package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Test2583 {
	
	static int r, c, k;
	static boolean[][] visited;
	static int region = 0;
	static int cnt = 0;
	static StringTokenizer st;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 영역 구하기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new boolean[r][c];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			
			for(int y = (r-r1-1); y>=(r-r2-1); y--) {
				for(int x = c1; x<=c2; x++) {
					visited[y][x] = true;
				}
			}
			
		}
		
		exec();
		
		System.out.println(region);
		Collections.sort(list);
//		Collections.sort(list, Collections.reverseOrder());// 내림
		
		for(int x : list) {
			System.out.print(x + " ");
		}
		
		
	}
	
	public static void exec() {
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(visited[i][j] == false) {
					region++;
					visited[i][j] = true;
					count(i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
	}
	
	public static void count(int y, int x) {
		cnt++;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >=0 && ny < r && nx >= 0 && nx < c && visited[ny][nx] == false) {
				visited[ny][nx] = true;
				count(ny, nx);
			}
			
		}
	}

}
