package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	
	public int vex;  // ���� 
	public int cost;  // ��� ������ ����ġ �� 
	
	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
	
	
	
}

public class Test5 {
	
	// ���ͽ�Ʈ�� �˰��� 
	
	static int[] dis;
	static int n,m;
	static ArrayList<ArrayList<Edge>> graph;
	
	public static void dijkstra(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		
		while(!pQ.isEmpty()) {
			
			Edge tmp = pQ.poll();  // �������� �ڽ�Ʈ����� �����ش�. 
			
			int now = tmp.vex;
			int nowCost = tmp.cost;
			
			if(nowCost > dis[now]) continue;
			
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex]> nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
			
		}  // end for while
	}
	
	public static void main(String[] args) {
		// ���ͽ�Ʈ�� �˰��� 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		dis = new int[n+1];
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		graph = new ArrayList<ArrayList<Edge>>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
		
	    dijkstra(1);  // 1���������� ��� 
	    
	    for(int i=2; i<=n; i++) {
	    	if(dis[i] != Integer.MAX_VALUE) System.out.println( i + " : " + dis[i]);
	    	else {
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