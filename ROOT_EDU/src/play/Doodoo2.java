package play;

import java.util.Scanner;

public class Doodoo2 {

	public static void main(String[] args) {
		// 버블정렬  제일큰수를 제일뒤로 밀고 가는거야 
		//  6
		//  13 5 11 7 23 15
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n-1; i++) {
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
