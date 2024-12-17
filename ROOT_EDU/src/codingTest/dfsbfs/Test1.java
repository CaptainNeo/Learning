package codingTest.dfsbfs;

import java.util.Scanner;

public class Test1 {
	
	static boolean[] visited;
	static int n;
	static int[] arr;
	static String answer = "NO";
	static int total;
	static boolean flag = false;
	
	public static void dfs(int idx, int sum) {
		if(flag) return;
		if(sum > total/2) return;
		if(total-sum == sum) {
			answer = "YES";
			flag = true;
		} else {
			for(int i=idx; i<n; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					dfs(i, sum + arr[i]);
					visited[i] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// ���� ���� �κ������� �ִ��� �ִٸ� "YES" �ƴϸ� "NO"
		// �׷� �ϳ��� ���ո� ���� Ȯ���� �� �� ���� 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		visited = new boolean[n];
		
		visited[0] = true;
		
		dfs(0, 0);
		
		System.out.println(answer);

	}

}
