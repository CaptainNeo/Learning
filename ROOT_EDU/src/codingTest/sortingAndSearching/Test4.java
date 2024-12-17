package codingTest.sortingAndSearching;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		// 삽입정렬 변형 문제 
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] cache = new int[s];
		
		// 미스 난건지 힛트친건지 확인이 필요
		
		for(int x : arr) {
			int pos = -1;
			for(int i=0; i<s; i++) {
				// 캐시를 뒤지면서 히트를 찾는다 
				if(x == cache[i]) pos = i;
			}
			if(pos == -1) {  // 미스 
				for(int i=s-1; i>=1; i--) {
					cache[i] = cache[i-1];
				}
				cache[0] = x;
			} else {
				// 히트 
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
