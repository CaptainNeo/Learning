package codingTest.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class Test13 {
	
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int answer = 0;
	
	public static void dfs(int s) {
		
		if(s == n) answer++;
		else {
			for(int i : graph.get(s)) {
				if(visited[i] == false ) {
					visited[i] = true;
					dfs(i);
					visited[i] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		// Test12를 인접행렬로 더 빠르게 구현하도록 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {  // 간선만큼 행 열 값 받아서 이동할수있다는 값 1 넣어주기 
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph.get(row).add(col);
		}
		
		visited[1] = true;
		dfs(1);
		System.out.println(answer);
		

	}

}
