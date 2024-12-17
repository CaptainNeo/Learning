package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Network implements Comparable<Network>{
	
	int node;
	int cost;
	
	Network(int node, int cost) {
		this.node   = node;
		this.cost = cost;
	}
	
	public int compareTo(Network o) {
		return this.cost - o.cost;
	}
}

public class Test1922 {
	
	// 네트워크 연결 <무방향 인접리스트로> 
	
	static int n,m;
	static ArrayList<ArrayList<Network>> list = new ArrayList<ArrayList<Network>>();
	static StringTokenizer st;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// 네트워크 연결
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visited = new boolean[n+1];
		
		// 인접행렬 자료구조 시작 
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Network>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Network(to, cost));
			list.get(to).add(new Network(from, cost));
			
		}
		
		
		// 1부터 n까지 연결시켜라
		connect(1);
		
		System.out.println(answer);

	}
	
	static public void connect(int n) {
		
		PriorityQueue<Network> q = new PriorityQueue<>();
		q.add(new Network(n, 0));
		
		while(!q.isEmpty()) {
			
			Network nw = q.poll();
			if(visited[nw.node] == true) continue;
			visited[nw.node] = true;
			answer += nw.cost;
			
			for(Network tmp : list.get(nw.node)) {
				if(visited[tmp.node] == false) {
					q.add(tmp);
				}
			}
			
			
			
			
		}
		
		
	}

}
