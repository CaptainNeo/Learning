package softeer;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// [�Ѿ�� HCPC 2023] Hanyang Popularity Exceeding Competition
		
		Scanner sc = new Scanner(System.in);
		
		// 20������ ���Ƶ� ���� ������? �ܼ� ����δ�... �����ϰ� �ִ� ���� �״�� �غ��� 
		
		int n = sc.nextInt();
		
		int x = 0;
		
		for(int i=0; i<n; i++) {
			int pi = sc.nextInt();
			int ci = sc.nextInt();
			
			if(Math.abs(pi-x) <= ci) {
				x++;
			}
			
		}
		
		System.out.println(x);
				

	}

}
