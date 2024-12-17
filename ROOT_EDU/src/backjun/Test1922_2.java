package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class NetNode implements Comparable<NetNode> {
	int from;
	int to;
	int cost;
	
	NetNode(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	public int compareTo(NetNode o) {
		return this.cost - o.cost;
	}
}

public class Test1922_2 {
	
	static StringTokenizer st;
	static int n,m;
	static int[] unf;
	static ArrayList<NetNode> list = new ArrayList<>();
	
	public static int find(int v) {
		if(unf[v] == v) return v;
		else return unf[v] = find(unf[v]);
	}
	
	public static void union(int a, int b) {
		
		int fa = find(a);
		int fb = find(b);
		
		if(fa != fb) unf[fa] = fb;
		
	}

	public static void main(String[] args) throws IOException {
		// 네트워크 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		unf = new int[n+1];
		for(int i=0; i<=n; i++) unf[i] = i;
		
		int answer = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new NetNode(s, e, c));
			
		}
		
		Collections.sort(list);
		
		for(int i=0; i<m; i++) {
			NetNode tmp = list.get(i);
			
			int fa = find(tmp.from);
			int fb = find(tmp.to);
			
			if(fa != fb) {
				answer += tmp.cost;
				union(fa, fb);
			}
			
		}
		
		System.out.println(answer);

	}

}
