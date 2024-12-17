package codingTest.dfsbfs;

import java.util.Scanner;

public class Test3 {
	
	static int n, m;
	static int[] score;
	static int[] time;
	static int maxScore = Integer.MIN_VALUE;
	
	public static void dfs(int idx, int sum, int t) {
		
		if(t > m) return;
		
		if(idx == n) {
			maxScore = Math.max(maxScore, sum);
		} else {
			dfs(idx + 1, sum + score[idx], t + time[idx]);
			dfs(idx + 1, sum, t);
		}
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		score = new int[n];
		time = new int[n];
		
		for(int i=0; i<n; i++) {
			score[i] = sc.nextInt();
			time[i] = sc.nextInt();
		}
		
		dfs(0, 0, 0);
		
		System.out.println(maxScore);

	}

}
