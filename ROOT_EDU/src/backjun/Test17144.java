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
	
	static int[] dy = {-1, 1, 0, 0};  	// �����¿�
	static int[] dx = {0, 0, -1, 1};
	
	static int[] airU = new int[2];
	static int[] airD = new int[2];
	
	static ArrayList<AcPosition> ac = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// �̼������ȳ� (�ùķ��̼� ����)
		
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();  // ��
		c = sc.nextInt();   // ��
		t = sc.nextInt();  // �� 
		
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
			// �ùķ��̼� ���� // 1. ����Ʈ Ȯ��   2. ����û���� ���� 
			map = new int[r][c];
			spread();
			// Ȯ���� �Ǿ��ٸ� !? ����û���� ���� 
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
		// ����û���� 1, ����û���� 2 �����ؼ� !! 
		// ����û����� �׻� 1������ ��ġ�ǰ� ũ��� ������ �����ϴϰ� �ι�������� 
		int acNum = 0;
		for(AcPosition acp : ac) {
			acNum++;
			if(acNum == 1) {
				
				int top = acp.y;
				// ���� ����û������ �ٶ��� �ݽð���� ��ȯ,
		        // �Ʒ��� ����
		        for (int i = top - 1; i > 0; i--) 
		        	board[i][0] = board[i-1][0];
		        // �������� ����
		        for (int i = 0; i < c - 1; i++) 
		        	board[0][i] = board[0][i+1];
		        // ���� ����
		        for (int i = 0; i < top; i++) 
		        	board[i][c - 1] = board[i + 1][c - 1];
		        // ���������� ����
		        for (int i = c - 1; i > 1; i--) 
		        	board[top][i] = board[top][i-1];
		        // ����û���⿡�� �δ� �ٶ��� �̼������� ���� �ٶ�
		        board[top][1] = 0;
				}
				
				
			 else {
				// �Ʒ� ����û���� 
				int down = acp.y;
				
				 // �Ʒ��� ����û������ �ٶ��� �ð�������� ��ȯ
		        // ���� ����
		        for (int i = down + 1; i < r - 1; i++) 
		        	board[i][0] = board[i + 1][0];
		        // �������� ����
		        for (int i = 0; i < c - 1; i++) 
		        	board[r - 1][i] = board[r - 1][i + 1]; 
		        // �Ʒ��� ����
		        for (int i = r - 1; i > down; i--) 
		        	board[i][c - 1] = board[i - 1][c - 1];
		        // ���������� ����
		        for (int i = c - 1; i > 1; i--) 
		        	board[down][i] = board[down][i - 1];
		        // ����û���⿡�� �δ� �ٶ��� �̼������� ���� �ٶ�
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
		// ������ ������ �ִ� board���� �������� ���� 
//		copy(board, map);
		// ���������� ��û�� ��ġ�� ��������ߵ� 
		for(AcPosition a : ac) {
			map[a.y][a.x] = -1;
		}
		
		// ���� ������� ������ Ȯ���� ���Ѷ� 
		// 0 �� �ƴѰ� ��� ������ -1�� ��û���̰� 
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				// ���� Ȯ�� 4����� Ȯ��
				int val = board[i][j] / 5;
				int candi = 0;// ������ ������� �ش� ��ǥ ����� ����
				for(int k=0; k<dy.length; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(ny >= 0 && ny < r && nx >= 0 && nx < c && board[ny][nx] != -1) {
						// 4������ �ѱ��� ������ ��� ���
						map[ny][nx] += val;
						candi += val;
					}
				}
				
				if(map[i][j] != -1) {
					map[i][j] += (board[i][j] - candi);
				}
				
				
			}
			
		}// end for ����Ȯ�� ���� 1�� 
		
		board = new int[r][c];
		copy(map, board);
		
		
	}
	
	public static void copy(int[][] a, int[][] b) {
		
		for(int i=0; i<r; i++) {
			b[i] = a[i].clone();
		}
		
	}

}
