package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordination {
	int r;
	int c;
	int cnt;
	
	Coordination(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Doodoo37 {
	
	static int r = 7;
	static int c = 7;
	static int[][] maze = new int[r][c];
	static boolean[][] visited = new boolean[r][c];
	static StringTokenizer st;
	static int count = 0;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// 미로의 최단거리 통로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		escape(0,0);
		
		System.out.println(count == 0 ? -1 : count);

	}
	
	public static void escape(int pr, int pc) {
		Queue<Coordination> q = new LinkedList<>();
		
		q.add(new Coordination(pr, pc, 0));
		visited[pr][pc] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			Coordination tmp = q.poll();
			
			if(tmp.r == r-1 && tmp.c == c-1) {
				count = tmp.cnt;
				break;
			}
			
			
			for(int s=0; s<size; s++) {
				for(int i=0; i<4; i++) {
					int nr = tmp.r + dy[i];
					int nc = tmp.c + dx[i];
					int nCnt = tmp.cnt + 1;
					if(nr >= 0 && nr < r && nc >= 0 && nc < c && maze[nr][nc] == 0 && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						q.add(new Coordination(nr, nc, nCnt));
					}
				}
			}
			
			
		}
		
		
	}

}
