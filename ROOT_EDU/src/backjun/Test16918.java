package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Boom {
	int y;
	int x;
	Boom(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Test16918 {
	
	static int r,c,n;
	static String[][] map;
	static StringTokenizer st;
	static int cnt = 0;
	static ArrayList<Boom> immiBoom  = new ArrayList<>();
//	static ArrayList<Boom> postBoom  = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// ºÕ¹ö¸Ç
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new String[r][c];
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
				
				if(map[i][j].equals("O")) immiBoom.add(new Boom(i, j));
			}
		}
		
		cnt++;	// 1ÃÊ°¡ Áö³´´Ù ÀÌÁ¦ nÃÊ¸¸Å­ µ·´Ù.
		
		if(n == cnt) {
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}	
		} else {
			cnt++;
			// ½ºÀ§Ä¡·Î ÆøÅºÀ» ¼³Ä¡, ÆøÅº Æø¹ß ¹Ýº¹ 
			boolean flag = false;  // false¸é ÆøÅº ¼³Ä¡ true¸é ÆøÅº ÅÍÆ®·Á
			for(int count = cnt; count <= n; count++) {
				if(!flag) {
					//ÆøÅºÀ» ³ö 
					putBoom();
					flag = true;
//					Printing(count);
				} else {
					// ÆøÅºÀ» ÅÍÆ®·Á
					flag = false;
					for(Boom boom : immiBoom) {
						
						map[boom.y][boom.x] = ".";
						
						// »óÇÏÁÂ¿ì¸¸ ÅÍÆ®¸°´Ù. 
						for(int i=0; i<4; i++) {
							int ny = boom.y + dy[i];
							int nx = boom.x + dx[i];
							if(ny >= 0 && ny < r && nx >= 0 && nx < c) {
								map[ny][nx] = ".";
							}
						}
						
					}
					
					immiBoom = new ArrayList<>();
					setImiBoom();
					
//					Printing(count);
				}
			}  // end for loop
			
			// ´ä 
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}  // end for else
		
		
		
		System.out.println(sb);

	}
	
	public static void setImiBoom() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j].equals("O")) {
					immiBoom.add(new Boom(i, j));
				}
			}
		}
	}
	
	public static void Printing(int count) {
		System.out.println("count => " + count);
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("=============================");
	}
	
	public static void putBoom() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j].equals(".")) {
					map[i][j] = "O";
//					postBoom.add(new Boom(i, j));
				}
			}
		}
	}

}
