package codingTest.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 버블정렬로 정렬을 하고 마지막에 인접한 두수가 같으면 중복 하자 
		
		String answer = "U";
//		for(int i=0; i<n-1; i++) {
//			for(int j=0; j<n-i-1; j++) {
//				if(arr[j] > arr[j+1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j+1];
//					 arr[j+1] = tmp;
//				}
//			}
//		}
		
		Arrays.sort(arr);
		
		
		for(int i=0; i<n-1; i++) { 
			if(arr[i] == arr[i+1]) {
				answer = "D";
				break;
			}
		}
		
		System.out.println(answer);

	}

}
