package codingTest.dfsbfs;

import java.util.Scanner;

public class Test2 {
	
	static int maxWeight = Integer.MIN_VALUE;
	static int[] dogs;
	static int n, c;
	
	// �κ����� ������ �߸��Ѱ� ��ã�ƾߵ� �� ó������ 194�� ���Դ��� Ȯ�� !  ������ �߸��� 
	// ���������� �¿��� ���¿����� �˸�ǰ� Ż���� �������� n���� ���� idx�� ���� Ż���ؾ��Ѵ�.
	
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
		// �ٵ��� ���� (DFS) 
		
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();  // ����
		
		n = sc.nextInt();  // �������� 
		
		// n������ �ٵ��̿� �� �ٵ����� ���� w�� �־�����, ö���� Ʈ���� �¿� �� �ִ� ���� ���ſ� ���� ! 
		
		dogs = new int[n];
		
		for(int i=0; i<n; i++) {
			dogs[i] = sc.nextInt();
		}
		
		dfs(0,0);
		
		System.out.println(maxWeight);
		
		

	}

}
