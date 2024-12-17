package codingTest.dfsbfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test5 {
	
	static Integer[] coins;
	static int m, n;
	static int count = Integer.MAX_VALUE;
	
	public static void dfs(int sum, int c) {
		
		if(sum > m) return;
		if(c >= count) return;
		if(sum == m) count = Math.min(c, count);
		else {
			for(int i=0; i<n; i++) {
				dfs(sum + coins[i], c + 1);
			}
		}
		
	}

	public static void main(String[] args) {
		// 동전교환
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		coins = new Integer[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.sort(coins, Collections.reverseOrder());
		
		m = sc.nextInt();
		
		dfs(0, 0);
		
		System.out.println(count);

	}

}
