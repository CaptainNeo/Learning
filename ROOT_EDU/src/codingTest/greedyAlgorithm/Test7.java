package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class WonderLand implements Comparable<WonderLand>{
	int v1;
	int v2;
	int cost;
	
	WonderLand(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(WonderLand o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}

public class Test7 {
	
	static int[] unf;
	
	public static int find(int v) {
		if(unf[v] == v) return v;
		else return unf[v] = find(unf[v]);
	}
	
	public static void union(int fa, int fb) {
		fa = find(fa);
		fb = find(fb);
		if(fa != fb) unf[fa] = fb;
	}

	public static void main(String[] args) {
		// 원더랜드 (최소스패닝트리) <union & find>
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		ArrayList<WonderLand> edges = new ArrayList<>();
		
		unf = new int[v+1];
		
		for(int i=0; i<=v; i++) unf[i] = i;
		
		for(int i=0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new WonderLand(v1,v2,cost));
		}
		
		Collections.sort(edges);
		
		int answer = 0;
		int cnt = 0;
		
		for(WonderLand edge : edges) {
			int v1 = edge.v1;
			int v2 = edge.v2;
			int cost = edge.cost;
			
			int fa = find(v1);
			int fb = find(v2);
			
			if(cnt == e-1) break;
			
			if(fa != fb) {
				answer += cost;
				union(fa, fb);
				cnt++;
			}
			
		}
		
		System.out.println(answer);

	}

}
