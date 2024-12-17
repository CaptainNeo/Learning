package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Doodoo24 {

	public static void main(String[] args) throws IOException {
		// 크레인 인형뽑기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int  n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<m; i++) {
			int idx = Integer.parseInt(st.nextToken()) - 1;  // 크레인 내리는곳
			
			for(int row=0; row<n; row++) {
				if(board[row][idx] != 0) {
					if(!stack.isEmpty()) {
						if(board[row][idx] == stack.peek()) {
							answer += 2;
							stack.pop();
						} else {
							stack.push(board[row][idx]);	
						}
					} else {
						stack.push(board[row][idx]);
					}
					
					board[row][idx] = 0;
					break;
				}
				
			}
			
			
		}
		
		System.out.println(answer);
		

	}

}
