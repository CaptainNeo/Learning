package codingTest.dfsbfs;

import java.util.Scanner;

public class Test4 {
	
	static int n,m;
	static int[] pm;
	
	public static void dfs(int idx) {
		if(idx == m) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				pm[idx] = i;
				dfs(idx+1);
			}
		}
	}

	public static void main(String[] args) {
		// �ߺ����� ���ϱ� 
		// 1���� N���� ��ȣ�� ���� ������ �ֽ��ϴ�. �� �ߺ��� ����Ͽ� m���� �̾� �Ϸķ� �����ϴ� ����� ��� ����Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		pm = new int [m];
		
		dfs(0);
		

	}

}
