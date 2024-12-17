package codingTest.greedyAlgorithm;

import java.util.Scanner;

public class Test6 {
	
	static int n, m;
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
		// 서로소 집합 문제 친구인가? (Disjoint-Set : Union & Find)
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		unf = new int[n+1];
		for(int i=0; i<=n; i++) {
			unf[i] = i;
		}
		
		for(int i =0; i<m; i++) {
			int fa = sc.nextInt();
			int fb = sc.nextInt();
			union(fa, fb);
		}
		
		
		int a = find(sc.nextInt());
		int b = find(sc.nextInt());
		
		if(a == b) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		

	}

}
