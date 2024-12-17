package codingTest.sortingAndSearching;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		// 버블정렬 인접한 두수 확인하고 스와프
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n-1; i++) {  // 앞이아니라 배열의 뒤부터 채운다는 개념 
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			
		}
		
		for(int x : arr) {
			System.out.print(x + " ");
		}
				

	}

}
