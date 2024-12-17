package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test12 {
	
	static int n, m;
	static int[][] graph;
	static boolean[] visited;
	static int answer = 0;
	
	public static void dfs(int s) {
		
		if(s == n) answer++;
		else {
			for(int i=1; i<=n; i++) {
				if(graph[s][i] == 1 && visited[i] == false ) {
					visited[i] = true;
					dfs(i);
					visited[i] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// 경로 탐색(인접행렬)
		// 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요. 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		//  5 9  1  2 1  3 1 4 2 1 2 3 2 5 3 4 4 2 4 5
		
		graph = new int[n+1][n+1];  // 노드를 인접행렬로 만들어주고 
		visited = new boolean[n+1];  // 노드 탐색 체크 배열
		
		for(int i=0; i<m; i++) {  // 간선만큼 행 열 값 받아서 이동할수있다는 값 1 넣어주기 
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph[row][col] = 1;
		}
		
		visited[1] = true;
		dfs(1);
		System.out.println(answer);
		
		
		

	}

}
