package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test1 {
	
	public static void reculsive(int n, int trgN) {
		
		System.out.println(trgN);

		if(n == trgN) return;
		
		trgN++;
		
		reculsive(n, trgN);
		
	}

	public static void main(String[] args) {
		
		// ����Լ� ����
		
		// �ڿ��� n�� �ԷµǸ� ����Լ��� �̿��Ͽ� 1���� n���� ����ϴ� ���α׷� �ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		reculsive(n,1);
		
		

	}

}
