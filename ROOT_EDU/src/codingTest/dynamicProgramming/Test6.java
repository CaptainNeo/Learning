package codingTest.dynamicProgramming;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] dy = new int[m+1];  // i분안에 문제를 풀때의 최대 점수 
		
		for(int i=0; i<n; i++) {
			int score = sc.nextInt();
			int minute = sc.nextInt();
			
			for(int j=m; j>=minute; j--) {
				if(dy[j] < dy[j - minute] + score) {
					dy[j] = dy[j - minute] + score;
				}
			}
			
			
		}
		
		System.out.println(dy[m]);
		
		

	}

}
