package play;

import java.util.Scanner;

public class Doodoo1 {

	public static void main(String[] args) {
		// 선택정렬
		
		
		// 6 
		// 13 5 11 7 23 15 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 선택정렬 알고리즘 시작 
		
		for(int i=0; i<n; i++) {
			// 키포인트는 i번째 오는 숫자를 바꿔주기위한 idx를 구한다 i번쨰에 제일 작은 수를 넣기위한다. 
			
			int idx = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[idx]) {
					idx = j;
				}
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
