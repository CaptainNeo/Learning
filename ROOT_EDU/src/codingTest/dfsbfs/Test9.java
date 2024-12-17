package codingTest.dfsbfs;

import java.util.Scanner;

public class Test9 {
	
	static int n, m;
	static boolean[] visited;
	static int[] p;
	
	public static void dfs(int idx) {
		
		if(idx == m) {
			for(int x : p) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					p[idx] = i;
					dfs(idx+1);
					visited[i] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// ���� ���ϱ�
		// 1���� n���� ��ȣ�� ���� ������ �ֽ��ϴ�. �� �� m���� �̴� ����� ���� ����ϴ� ���α׷��� �ۼ��ϼ���
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		p = new int[m];
		
		visited = new boolean[n+1];
		
		dfs(0);
		

	}

}
