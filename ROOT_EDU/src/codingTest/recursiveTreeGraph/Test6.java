package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test6 {
	
	static int n;
	static int[] ch;
	
	public static void dfs(int L) {
		if(L == n+1) {
			String answer = "";
			for(int i=1; i<=n; i++) {
				if(ch[i] == 1) answer += i + " ";
			}
			if(answer.length() > 0)
			System.out.println(answer);
		}else {
			ch[L]=1;
			dfs(L+1);
			ch[L]=0;
			dfs(L+1);
		}
	}

	public static void main(String[] args) {
		// 부분집합 구하기 (DFS)
		// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요 . 단, 공집합은 출력하지않는다
		
		Scanner sc = new Scanner(System.in);
		
		n = 3;
		ch = new int[n+1];
		dfs(1);
		

	}

}
