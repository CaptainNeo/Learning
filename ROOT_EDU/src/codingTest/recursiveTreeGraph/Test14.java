package codingTest.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test14 {
	
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] dis;
	
	public static void bfs(int v) {
		
		Queue<Integer> q = new LinkedList<>();
		
		visited[v] = true;
		dis[v] = 0;
		
		q.offer(v);
		
		while(!q.isEmpty()) {
			int cv = q.poll();
			for(int nv : graph.get(cv)) {
				if(visited[nv] == false) {
					visited[nv] = true;
					q.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		
		// 그래프 최단거리 (BFS)
		// 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수 출력 
		// 6 9 1 3 1 4 2 1 2 5 3 4 4 5 4 6 6 2 6 5
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();  // 정점의 개수 
		m = sc.nextInt();  // 간선의 개수 
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		visited = new boolean[n+1];
		dis = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			graph.get(row).add(col);
		}
		
		bfs(1);
		
		for(int i=2; i<=n; i++) {
			System.out.println(i + " : " + dis[i]);
		}
		

	}

}
