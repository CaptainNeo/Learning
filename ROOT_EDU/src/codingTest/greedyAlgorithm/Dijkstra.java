package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Line implements Comparable<Line> {
	int nextNode;
	int cost;
	
	Line(int nextNode, int cost) {
		this.nextNode = nextNode;
		this.cost     = cost;
	}

	@Override
	public int compareTo(Line o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;  // 오름차순
	}
}

public class Dijkstra {
	
	static int n,m;
	static ArrayList<ArrayList<Line>> nodes = new ArrayList<ArrayList<Line>>();
	static int[] distance;
	
	public static void simulator(int startNode) {
		
		PriorityQueue<Line> q = new PriorityQueue<>();
		q.offer(new Line(startNode, 0));
		distance[startNode] = 0;
		
		// 다익스트라 로직 시작
		while(!q.isEmpty()) {
			
			Line curLine = q.poll();
			int curNode = curLine.nextNode;
			int curCost = curLine.cost;
			
			if(curCost > distance[curNode]) continue;
			
			for(Line nl : nodes.get(curNode)) {
				int nextNode = nl.nextNode;
				int nextCost = nl.cost;
				
				if(distance[nextNode] > curCost + nextCost) {
					distance[nextNode] = curCost + nextCost;
					q.offer(new Line(nextNode, curCost + nextCost));
				}
			}
			
		}	// end for while
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();  // 노드의 수
		m = sc.nextInt();  // 간선의 갯수
		
		distance = new int[n+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 노드르 만들자 
		for(int i=0; i<=n; i++) {
			nodes.add(new ArrayList<Line>());
		}
		
		for(int i=0; i<m; i++) {
			int node = sc.nextInt();
			int nextNode = sc.nextInt();
			int cost = sc.nextInt();
			// 노드들의 정보를 저장한다. 
			nodes.get(node).add(new Line(nextNode, cost));
		}
		
		
		simulator(1);
		
		for(int i=2; i<=n; i++) {
			if(distance[i] != Integer.MAX_VALUE) {
				System.out.println(i + " : " + distance[i]);
			} else {
				System.out.println(i + " : impossible");
			}
		}

	}

}

/*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/