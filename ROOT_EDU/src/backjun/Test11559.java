package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Puyo {
	int y;
	int x;
	String color;
	
	public Puyo(int y, int x, String color) {
		this.y = y;
		this.x = x;
		this.color = color;
	}
}

public class Test11559 {
	
	static String[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean trigger;
	static int cnt = 0;
	static ArrayList<Puyo> list;

	public static void main(String[] args) throws IOException {
		// (PuyoPuyo)
		// 1. �����¿� 4���̻��� ���� ���� �ִ��� Ȯ��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[12][6];
		
		
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
			}
		}
		
		// 4�� �ִ��� ��ü������ Ȯ���ؾߵǴ´�..
		// �߷¿� ���ؼ� ���� �����;� �Ǵ´�..
		
		boolean keepGoing = true;
		
		while(keepGoing) {
			keepGoing = false;
			trigger = false; // 4���̻��̸� !! true�� 
			
			visited = new boolean[12][6];
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(!map[i][j].equals(".") && visited[i][j] == false) {
						list = new ArrayList<>();
						list.add(new Puyo(i, j, map[i][j]));
						visited[i][j] = true;
						bomb(i, j, map[i][j]);
						if(list.size() >= 4) {
							keepGoing = true;
						 	trigger = true;
						 	for(Puyo p : list) {
						 		map[p.y][p.x] = "."; 
						 	}
						}
						
					}
				}
			}
			
			if(trigger) cnt++;
			
			// Ȯ�ΰ��� 
//			for(int i=0; i<12; i++) {
//				for(int j=0; j<6; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			// ��迭! // �÷����� ����Ʈ�� ������Ͽ� �ؿ������� �־��ش�.
			for(int c=0; c<6; c++) {
				list = new ArrayList<>();
				
				for(int r=12-1; r>=0; r--) {
					if(!map[r][c].equals(".")) {
						list.add(new Puyo(r, c, map[r][c]));
						map[r][c] = ".";
					}
				}
				
				int idx = 12-1;
				for(Puyo p : list) {
					map[idx][c] = p.color;
					idx--;
				}
				
//				for(int i=0; i<12; i++) {
//					for(int j=0; j<6; j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				
//				System.out.println();
			}
			
		
			
			
		}
		
		
		System.out.println(cnt);

	}
	
	public static void bomb(int y, int x, String se) {
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >=0 && ny < 12 && nx >=0 && nx < 6 && map[ny][nx].equals(se) && visited[ny][nx] == false) {
				visited[ny][nx] = true;
				list.add(new Puyo(ny, nx, se));
				bomb(ny, nx, se);
			}
		}
		
	}

}

