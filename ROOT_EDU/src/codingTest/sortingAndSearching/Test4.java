package codingTest.sortingAndSearching;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		// �������� ���� ���� 
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] cache = new int[s];
		
		// �̽� ������ ��Ʈģ���� Ȯ���� �ʿ�
		
		for(int x : arr) {
			int pos = -1;
			for(int i=0; i<s; i++) {
				// ĳ�ø� �����鼭 ��Ʈ�� ã�´� 
				if(x == cache[i]) pos = i;
			}
			if(pos == -1) {  // �̽� 
				for(int i=s-1; i>=1; i--) {
					cache[i] = cache[i-1];
				}
				cache[0] = x;
			} else {
				// ��Ʈ 
				for(int i=pos; i>=1; i--) {
					cache[i] = cache[i-1];
				}
				cache[0] = x;
			}
			
		}// end for loop
		
		for(int x : cache) {
			System.out.print(x + " ");
		}

	}

}
