package backjun;

import java.util.ArrayList;
import java.util.Scanner;

class AcPosition {
	int y;
	int x;
	
	AcPosition(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Test17144 {
	
	static int r,c,t;
	
	static int[][] board;
	static int[][] map;
	
	static int[] dy = {-1, 1, 0, 0};  	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	
	static int[] airU = new int[2];
	static int[] airD = new int[2];
	
	static ArrayList<AcPosition> ac = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// 미세먼지안녕 (시뮬레이션 문제)
		
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();  // 행
		c = sc.nextInt();   // 열
		t = sc.nextInt();  // 초 
		
		board = new int[r][c];
		
		
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == -1) {
					ac.add(new AcPosition(i, j));
				}
			}
		}
		
		for(int i=0; i<t; i++) {
			// 시뮬레이션 시작 // 1. 더스트 확산   2. 공기청정기 가동 
			map = new int[r][c];
			spread();
			// 확산이 되었다면 !? 공기청정기 가동 
			turnOnAc();
		}
		
		
		int answer = 0; 
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(board[i][j] != -1) {
					answer += board[i][j];
				}
			}
		}
		
		System.out.println(answer);
		
		
		

	}
	
	public static void turnOnAc() {
		// 공기청정기 1, 공기청정기 2 구분해서 !! 
		// 공기청정기는 항상 1번열에 설치되고 크기는 두행을 차지하니간 두번만돌면되 
		int acNum = 0;
		for(AcPosition acp : ac) {
			acNum++;
			if(acNum == 1) {
				
				int top = acp.y;
				// 위쪽 공기청정기의 바람은 반시계방향 순환,
		        // 아래로 당기기
		        for (int i = top - 1; i > 0; i--) 
		        	board[i][0] = board[i-1][0];
		        // 왼쪽으로 당기기
		        for (int i = 0; i < c - 1; i++) 
		        	board[0][i] = board[0][i+1];
		        // 위로 당기기
		        for (int i = 0; i < top; i++) 
		        	board[i][c - 1] = board[i + 1][c - 1];
		        // 오른쪽으로 당기기
		        for (int i = c - 1; i > 1; i--) 
		        	board[top][i] = board[top][i-1];
		        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		        board[top][1] = 0;
				}
				
				
			 else {
				// 아래 공기청정기 
				int down = acp.y;
				
				 // 아래쪽 공기청정기의 바람은 시계방향으로 순환
		        // 위로 당기기
		        for (int i = down + 1; i < r - 1; i++) 
		        	board[i][0] = board[i + 1][0];
		        // 왼쪽으로 당기기
		        for (int i = 0; i < c - 1; i++) 
		        	board[r - 1][i] = board[r - 1][i + 1]; 
		        // 아래로 당기기
		        for (int i = r - 1; i > down; i--) 
		        	board[i][c - 1] = board[i - 1][c - 1];
		        // 오른쪽으로 당기기
		        for (int i = c - 1; i > 1; i--) 
		        	board[down][i] = board[down][i - 1];
		        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
		        board[down][1] = 0;

		        //				for(int i=0; i<r; i++) {
//					for(int j=0; j<c; j++) {
//						System.out.print(board[i][j] + " ");
//					}
//					System.out.println();
//				}
//				
//				System.out.println("=======================");
				
				
			}
		}
	}
	
	public static void spread() {
		// 기존에 가지고 있던 board들의 먼지들을 복사 
//		copy(board, map);
		// 퍼지기전에 공청기 위치를 저장해줘야되 
		for(AcPosition a : ac) {
			map[a.y][a.x] = -1;
		}
		
		// 이제 계산해줘 먼지들 확산을 시켜라 
		// 0 이 아닌건 모두 먼지야 -1은 공청기이고 
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				// 먼지 확인 4군대로 확산
				int val = board[i][j] / 5;
				int candi = 0;// 먼지가 퍼질경우 해당 좌표 계산을 위해
				for(int k=0; k<dy.length; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(ny >= 0 && ny < r && nx >= 0 && nx < c && board[ny][nx] != -1) {
						// 4군대중 한군대 퍼졌을 경우 계산
						map[ny][nx] += val;
						candi += val;
					}
				}
				
				if(map[i][j] != -1) {
					map[i][j] += (board[i][j] - candi);
				}
				
				
			}
			
		}// end for 먼지확산 루프 1초 
		
		board = new int[r][c];
		copy(map, board);
		
		
	}
	
	public static void copy(int[][] a, int[][] b) {
		
		for(int i=0; i<r; i++) {
			b[i] = a[i].clone();
		}
		
	}

}
