package codingTest.sortingAndSearching;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		// 선택정렬
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		// i번째가 어디로 가야할지를 인덱스 찾기
		
		for(int i=0; i<n; i++) {
			int idx = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[idx] > arr[j]) idx =j;
			}
			
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
			
		}
		
		for(int x : arr) {
			System.out.print(x + " ");
		}
		
		

	}

}
