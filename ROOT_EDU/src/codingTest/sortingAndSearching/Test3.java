package codingTest.sortingAndSearching;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// ��������
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// ó�� 1���� 
		for(int i=1; i<n; i++) {
			int tmp = arr[i], j; 
			for(j=i-1; j>=0; j--) {
				if(arr[j] > tmp) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
		}
		
		for(int x : arr) {
			System.out.print(x + " ");
		}



	}

}