package codingTest.dfsbfs;

import java.util.Scanner;

public class Test4 {
	
	static int n,m;
	static int[] pm;
	
	public static void dfs(int idx) {
		if(idx == m) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				pm[idx] = i;
				dfs(idx+1);
			}
		}
	}

	public static void main(String[] args) {
		// 중복순열 구하기 
		// 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중복을 허락하여 m번을 뽑아 일렬로 나열하는 방법을 모두 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		pm = new int [m];
		
		dfs(0);
		

	}

}
