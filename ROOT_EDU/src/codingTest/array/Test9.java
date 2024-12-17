package codingTest.array;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		// 2�߹迭 ������ ����
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// ���� ���� ��밢�� ���� ū�� ã�� 
		int answer = Integer.MIN_VALUE;
		
		int sumA, sumB;
		for(int i=0; i<n; i++) {
			sumA = 0; sumB = 0;
			for(int j=0; j<n; j++) {
				sumA += arr[i][j];  // ���� �� 
				sumB += arr[j][i];  // ���� �� 
			}
			answer = Integer.max(answer, sumA);
			answer = Integer.max(answer, sumB);
		}
		
		// �밢��! 
		sumA = 0; sumB = 0;
		
		for(int i=0; i<n; i++) {
			
			sumA += arr[i][i];  // 0,0 ���� 5,5 �밢��
			sumB += arr[i][n - i - 1];  // 0,5 ���� 5,0 ���� �밢��
			
		}
		
		answer = Integer.max(answer, sumA);
		answer = Integer.max(answer, sumB);
		
		System.out.println(answer);
		

	}  // end for main

}
