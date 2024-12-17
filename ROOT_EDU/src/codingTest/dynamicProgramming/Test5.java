package codingTest.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// ������ȯ(���� �˰���)  �Ž����ٵ����� �ּҰ��� 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int change = sc.nextInt();  // �Ž����� �ݾ�
		
		int[] dy = new int[change + 1];	// dy[i] : i �ݾ��� ����´� �ּ� ���� ���� 
		
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;  // ** �߿� 
		// ���̳��� ���α׷��� ���� 
		for(int i=0; i<n; i++) {
			
			int jstartIdx = coins[i];
			
			for(int j=jstartIdx; j<change+1; j++) {
				int tmp = dy[j - coins[i]] + 1;
				if(dy[j] > tmp) {
					dy[j] = tmp;
				}
			}
		}
		
		System.out.println(dy[change]);
		

	}

}
