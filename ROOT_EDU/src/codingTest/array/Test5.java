package codingTest.array;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// �����佺�׳׽��� ü 
		
		// �Ҽ��� ã�°Ǵ� 1�� ���μ� �ܿ� ������ �������� �ʴ� ���� 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] intArr = new int[n+1];
		
		int cnt = 0; 
		
		for(int i=2; i<=n; i++) {
			
			if(intArr[i] == 0) cnt++;
			
			for(int j=i; j<=n; j=j+i) {
				intArr[j] = 1;
			}
			
		}
		
		System.out.println(cnt);
		
		

	}

}
