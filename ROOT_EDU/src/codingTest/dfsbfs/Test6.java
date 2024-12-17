package codingTest.dfsbfs;

import java.util.Scanner;

public class Test6 {
	
//	3 2 
//	3 6 9
	
	static int n,m;
	static int[] pm;
	static int[] arr;
	static boolean[] visited;
	
	public static void dfs(int idx) {
		if(idx == m) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=0; i<n; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					pm[idx] = arr[i];
					dfs(idx+1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		// 순열 구하기 > 10이하의 n개의 자연수가 주어지면 이 중 m개를 뽑아 일렬로 나열하는 방법 모두 출력  중복 불가  
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		visited = new boolean[n];
		arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		pm = new int[m];
		
		dfs(0);
		

	}

}
