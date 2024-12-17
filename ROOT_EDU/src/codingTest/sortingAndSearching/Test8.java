package codingTest.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		// 이분검색은 정렬이 되있어야 한다.!
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int mid;
		int lt = 0;
		int rt = arr.length - 1;
		int answer = 0;
		
		while(lt<=rt) {
			mid = (lt + rt) / 2;
			
			if(arr[mid] == m) {
				answer = mid;
				break;
			} else if(arr[mid] > m) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
			
		}
		
		System.out.println(answer + 1);
		

	}

}
