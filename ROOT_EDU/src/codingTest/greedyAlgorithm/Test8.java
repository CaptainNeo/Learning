package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Doro implements Comparable<Doro>{
	int ver;
	int cost;
	
	Doro(int ver, int cost) {
		this.ver = ver;
		this.cost = cost;
	}

	@Override
	public int compareTo(Doro o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}

public class Test8 {
	
	static int v;
	static int e;
	static int answer;
	static ArrayList<ArrayList<Doro>> nodes;
	static boolean[] visited;
	
	public static void bfs(int startNode) {
		
		PriorityQueue<Doro> q = new PriorityQueue<Doro>();
		q.offer(new Doro(startNode, 0));
		
		while(!q.isEmpty()) {
			Doro tmp = q.poll();
			
			int now = tmp.ver;
			int nowCost = tmp.cost;
			
			if(visited[now] == false) {
				visited[now] = true;
				answer += nowCost;
				for(Doro d : nodes.get(now)) {
					int nextVer = d.ver;
					int nextCost = d.cost;
					if(visited[nextVer] == false) {
						q.offer(new Doro(nextVer, nextCost));
					}
					
				}
			}
			
			
		}  // end for while
		
		
	}  // end for bfs

	public static void main(String[] args) {
		// 원더랜드 (최소스패닝트리) priorityqueue 로 푼거
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		visited  = new boolean[v+1];
		
		nodes = new ArrayList<ArrayList<Doro>>();
		
		for(int i=0; i<=v; i++) {
			nodes.add(new ArrayList<Doro>());  // 초기화 정점 개수만큼 만든다.
		}
		
		for(int i=0; i<e;i ++) {  // 간선수만큼 데이터 저장
			
			int ver = sc.nextInt();
			int nextVer = sc.nextInt();
			int cost = sc.nextInt();
			
			nodes.get(ver).add(new Doro(nextVer, cost));
			nodes.get(nextVer).add(new Doro(ver, cost));
		}
		
		bfs(1); // 1번노드부터 전부 연결 
		
		System.out.println(answer);
		

	}

}
