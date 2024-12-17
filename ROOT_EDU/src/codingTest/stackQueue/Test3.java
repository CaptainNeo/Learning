package codingTest.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int moves = sc.nextInt();
		
		int[] mArr = new int[moves];
		
		for(int i=0; i<moves; i++) {
			mArr[i] = sc.nextInt();
		}
		
		
		///// ±¸ÇöºÎ 
		
		Stack<Integer> st = new Stack<>();
		int answer = 0;
		
		for(int claw : mArr) {
			claw -= 1;
			for(int i=0; i<n; i++) {
				if(board[i][claw] != 0) {
					int doll = board[i][claw];
					if(!st.isEmpty() && st.peek() == doll) {
						answer += 2;
						st.pop();
					} else {
						st.push(doll);
						
					}
					board[i][claw] = 0;
					break;
				}
			}
			
		}
		
		
		System.out.println(answer);

	}

}
