package codingTest.array;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		// 2중배열 격자판 연습
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 가로 세로 양대각선 제일 큰수 찾기 
		int answer = Integer.MIN_VALUE;
		
		int sumA, sumB;
		for(int i=0; i<n; i++) {
			sumA = 0; sumB = 0;
			for(int j=0; j<n; j++) {
				sumA += arr[i][j];  // 열의 합 
				sumB += arr[j][i];  // 행의 합 
			}
			answer = Integer.max(answer, sumA);
			answer = Integer.max(answer, sumB);
		}
		
		// 대각선! 
		sumA = 0; sumB = 0;
		
		for(int i=0; i<n; i++) {
			
			sumA += arr[i][i];  // 0,0 부터 5,5 대각선
			sumB += arr[i][n - i - 1];  // 0,5 부터 5,0 까지 대각선
			
		}
		
		answer = Integer.max(answer, sumA);
		answer = Integer.max(answer, sumB);
		
		System.out.println(answer);
		

	}  // end for main

}
