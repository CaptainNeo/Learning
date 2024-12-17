package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test2 {
	
	public static void dfs(int n) {
		
		if(n == 0) return;
		else {
			dfs(n/2);
			System.out.print(n%2 + " ");
		}
		
		
	}

	public static void main(String[] args) {
		
		// 2진수 출력
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dfs(n);

	}

}
