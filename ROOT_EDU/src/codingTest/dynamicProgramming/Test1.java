package codingTest.dynamicProgramming;

import java.util.Scanner;

public class Test1 {
	
	static int n;
	static int answer = 0;
	static int[] dy;
	
	public static void dfs(int step) {
		if(step > n) return;
		if(step == n) {
			answer++;
		} else {
			dfs(step+1);
			dfs(step+2);
		}
		
	}
	
	public static void main(String[] args) {
		// ��ܿ����� ����� ������ 1, 2 ��ܾ� ������ n����� �����ٸ� �� ����� ���� ? 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dy = new int [n+1];
		
		dy[1] = 1;
		dy[2] = 2;
		
//		dfs(0);
		
//		System.out.println(answer);
		
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		
		System.out.println(dy[n]);

	}

}
