package softeer.lv2;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// ��ź�� ũ�� 
		
		// n���� ���� ������ x ������ �����Ͽ� n���� ���ι������� ������� 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
//		int min = Integer.MAX_VALUE;
		int min = 2; // ���� ���� ��ź������ ���������� ���� 
		int max = Integer.MIN_VALUE;
		
		for(int i=0 ;i<n; i++) {
			arr[i] = sc.nextInt();
			//min = Math.min(min, arr[i]);  // ������ �������� ����!! 6 9 12 ������? �� ������ 2���� �����ؾ߰ڱ���  
			max = Math.max(max, arr[i]);
		}
		
//		max = (max / 2) + 1; // ������ ��ź ���� �ϳ��� �־�� ���ڳ�
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=min; i<=max; i++) {
			int cnt = 0;
			// i�������� ��ź�� �����ؼ� n���� ���� �־�� 
			for(int j=0; j<n; j++) {
				if(arr[j] % i == 0) cnt++;
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
				
		
		
	}

}
