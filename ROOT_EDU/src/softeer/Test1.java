package softeer;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// 나무공격 lv2 
		Scanner sc = new Scanner(System.in);
		
		
		
		int n,m;
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		int[][] board = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int L,R;
		
		L = sc.nextInt() -1;
		R = sc.nextInt() -1;
			
		// 첫번째 공격
		for(int i=L; i<=R; i++) {
			
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1) {
					board[i][j] = 0;
					break;
				}
			}
			
		}
		
		// 두번째 공격 
		
		L = sc.nextInt() -1;
		R = sc.nextInt() -1;
		
		for(int i=L; i<=R; i++) {
			
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1) {
					board[i][j] = 0;
					break;
				}
			}
			
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1) answer++;
			}
		}
		
		System.out.println(answer);
		

	}

}
