package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test6 {
	
	static int n;
	static int[] ch;
	
	public static void dfs(int L) {
		if(L == n+1) {
			String answer = "";
			for(int i=1; i<=n; i++) {
				if(ch[i] == 1) answer += i + " ";
			}
			if(answer.length() > 0)
			System.out.println(answer);
		}else {
			ch[L]=1;
			dfs(L+1);
			ch[L]=0;
			dfs(L+1);
		}
	}

	public static void main(String[] args) {
		// �κ����� ���ϱ� (DFS)
		// �ڿ��� N�� �־����� 1���� N������ ���Ҹ� ���� ������ �κ������� ��� ����ϴ� ���α׷��� �ۼ��ϼ��� . ��, �������� ��������ʴ´�
		
		Scanner sc = new Scanner(System.in);
		
		n = 3;
		ch = new int[n+1];
		dfs(1);
		

	}

}
