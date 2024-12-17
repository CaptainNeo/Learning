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
		// ��� Ž��(�������)
		// ����׷����� �־����� 1�� �������� N�� �������� ���� ��� ����� ���� ���� ����ϴ� ���α׷��� �ۼ��ϼ���. 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		//  5 9  1  2 1  3 1 4 2 1 2 3 2 5 3 4 4 2 4 5
		
		graph = new int[n+1][n+1];  // ��带 ������ķ� ������ְ� 
		visited = new boolean[n+1];  // ��� Ž�� üũ �迭
		
		for(int i=0; i<m; i++) {  // ������ŭ �� �� �� �޾Ƽ� �̵��Ҽ��ִٴ� �� 1 �־��ֱ� 
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph[row][col] = 1;
		}
		
		visited[1] = true;
		dfs(1);
		System.out.println(answer);
		
		
		

	}

}
