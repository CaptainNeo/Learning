package codingTest.dfsbfs;

import java.util.Scanner;

public class Test2 {
	
	static int maxWeight = Integer.MIN_VALUE;
	static int[] dogs;
	static int n, c;
	
	// 부분집합 조합을 잘못한거 꼭찾아야되 왜 처음답이 194가 나왔는지 확인 !  조합을 잘못함 
	// 강아지들을 태울지 안태울지만 알면되고 탈출은 강아지들 n마리 까지 idx가 오면 탈출해야한다.
	
	public static void dfs(int idx, int sum) {
		
		if(sum > c) return;
		if(idx == n) {
			maxWeight = Math.max(maxWeight, sum);
		} else {
			dfs(idx+1, sum + dogs[idx]);
			dfs(idx+1, sum);
		}
		
		
	}

	public static void main(String[] args) {
		// 바둑이 승차 (DFS) 
		
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();  // 무게
		
		n = sc.nextInt();  // 강아지들 
		
		// n마리의 바둑이와 각 바둑이의 무게 w가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게 ! 
		
		dogs = new int[n];
		
		for(int i=0; i<n; i++) {
			dogs[i] = sc.nextInt();
		}
		
		dfs(0,0);
		
		System.out.println(maxWeight);
		
		

	}

}
