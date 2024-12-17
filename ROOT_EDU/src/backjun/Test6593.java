package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class EscapeMan {
	int l;
	int r;
	int c;
	int m;
	
	EscapeMan(int l,int r, int c, int m) {
		this.l = l;
		this.r = r;
		this.c = c;
		this.m = m;
	}
}

public class Test6593 {
	
	static int L,R,C;
	static String[][][] building;
	static boolean[][][] visited;
	static StringTokenizer st;
	static String tmp;
	static int[] dy = {-1, 1, 0, 0, 0, 0};  // �� �� �� �� �� ��
	static int[] dx = {0, 0, -1, 1, 0, 0};  // �� �� �� �� �� ��
	static int[] dz = {0, 0, 0, 0, -1, 1};  // �� ��
	static int answer = Integer.MAX_VALUE;
	
	public static void escape(int l, int r, int c, int m) {
		
		Queue<EscapeMan> q = new LinkedList<>();
		q.add(new EscapeMan(l, r, c, m));
		
		while(!q.isEmpty()) {
			
			EscapeMan e = q.poll();
			
			int el = e.l;
			int er = e.r;
			int ec = e.c;
			int em = e.m;
			
			if("E".equals(building[el][er][ec])) {
				answer = Math.min(answer, em);
				break;
			}
			
			for(int i=0; i<6; i++) {
				int nl = el + dz[i]; 
				int nr = er + dy[i];
				int nc = ec + dx[i];
				if(nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !building[nl][nr][nc].equals("#") && visited[nl][nr][nc] == false) {
					visited[nl][nr][nc] = true;
					q.add(new EscapeMan(nl, nr, nc, em + 1));
				}
				
			}
			
		}  // end for while 
		
		// ���� �� �� ���� ��������.
//		if("#".equals(building[l][r][c])) {
//			return;
//		}
		
		// Ż�� 
//		if("E".equals(building[l][r][c])) {
//			answer = Math.min(answer, m);
//			return;
//		} else {
//			// Ż�ⱸ�� ã�� 
//			int nl, nr, nc;
//			for(int i=0; i<dz.length; i++) {
//				nl = l + dz[i];
//				if(nl >= 0 && nl < L && !building[nl][r][c].equals("#") && visited[nl][r][c] == false) {
//					visited[nl][r][c] = true;
//					escape(nl, r, c, m+1);
//				}
//			}
//			
//			for(int i=0; i<4; i++) {
//				nr = r + dy[i];
//				nc = c + dx[i];
//				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !building[l][nr][nc].equals("#") && visited[l][nr][nc] == false) {
//					visited[l][nr][nc] = true;
//					escape(l, nr, nc, m+1);
//				}
//			}
//			
//		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// ������� 1�ʾȿ� 3���� �迭 ������� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean flag = true;
		while(flag) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				flag = false;
				continue;
			}
			
			building = new String[L][R][C];
			
			int sl = 0;
			int sr = 0;
			int sc = 0;
			
			for(int l=0; l<L; l++) {
				for(int r=0; r<R; r++) {
					tmp = br.readLine();
					for(int c=0; c<C; c++) {
						building[l][r][c] = String.valueOf(tmp.charAt(c));
						if("S".equals(building[l][r][c])) {
							sl = l; sr = r; sc = c;
						}
					}
				}
				br.readLine();
			}
			
			// ���� 
			
			
			visited = new boolean[L][R][C];
			
			answer = Integer.MAX_VALUE;
			
			visited[sl][sr][sc] = true;
			
			escape(sl, sr, sc, 0);
			
			
			if(answer == Integer.MAX_VALUE) {
				sb.append("Trapped!").append("\n");
			} else {
				sb.append("Escaped in ").append(answer).append(" minute(s).").append("\n");
			}
			
			
		}  // end for while 
		
		
		System.out.println(sb);
		
		
		
		
		
		
		

	}

}
