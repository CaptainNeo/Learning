package codingTest.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// 동전교환(냅색 알고리즘)  거슬러줄동전의 최소개수 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int change = sc.nextInt();  // 거슬러줄 금액
		
		int[] dy = new int[change + 1];	// dy[i] : i 금액을 만드는대 최소 동전 개수 
		
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;  // ** 중요 
		// 다이나믹 프로그래밍 시작 
		for(int i=0; i<n; i++) {
			
			int jstartIdx = coins[i];
			
			for(int j=jstartIdx; j<change+1; j++) {
				int tmp = dy[j - coins[i]] + 1;
				if(dy[j] > tmp) {
					dy[j] = tmp;
				}
			}
		}
		
		System.out.println(dy[change]);
		

	}

}
