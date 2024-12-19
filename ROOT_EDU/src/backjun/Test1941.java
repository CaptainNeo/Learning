package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test1941 {
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] combiY = new int[25];
	static int[] combiX = new int[25];
	static int answer = 0;
	static String[][] map = new String[5][5];
	static boolean[] visited;
	static int[] selected = new int[7];
	
	public static void check() {
		// ���� �������� Ȯ�� �ϰ� S�� 4���̻��̿��ߵ�
		Queue<Integer> q = new LinkedList<>();
		
		q.add(selected[0]);
		visited[0] = true;
		
		int sCnt = 0;
		int cnt = 1; // �����ѿ� ���� 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(map[combiY[cur]][combiX[cur]].equals("S")) sCnt++;
			
			
			for(int i=0; i<4; i++) {
				
				// ������ ��ġ���� �����¿�� ���鼭 ������ 6���� ��ǥ�� ���������� ã�� ã������ q�� �ִ´�
				for(int j=1; j<7; j++) {
					
					if(combiY[cur] + dy[i] == combiY[selected[j]] && combiX[cur] + dx[i] == combiX[selected[j]] && visited[j] == false) {
						visited[j] = true;
						q.add(selected[j]);
						cnt++;
					}
								
				}
				
			}
		}
		
		if(cnt == 7 && sCnt >= 4) {
			answer++;
		}
		
		
	}
	
	
	public static void combi(int idx, int depth, int ypa) {
		
		if(ypa >= 4) return;
		
		if(idx == 7) {
			visited = new boolean[7];
			check();
//			for(int i=0; i<selected.length; i++) {
//				System.out.print(selected[i] + " ");
//			}
//			System.out.println();
			return;
		}
		
		if(depth == 25) return;
		
		selected[idx] = depth;
		
		int y = combiY[selected[idx]];
		int x = combiX[selected[idx]];
		if(map[y][x].equals("Y")) ypa++;
		
		combi(idx+1, depth+1, ypa);
		combi(idx, depth+1, ypa);
		
	}
	

	public static void main(String[] args) throws IOException {
		// ���� �ҹ��� ĥ����. ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = String.valueOf(str.charAt(j));
			}
		}
		
		// ���ձ��ϱ�
		for(int i=0; i<25; i++) {
			combiY[i] = i / 5;
			combiX[i] = i % 5;
		}
		
//		combi(0, 0, 7);
		combi(0, 0, 0);
		
		System.out.println(answer);
		

	}

}
