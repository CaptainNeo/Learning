package play;

import java.util.Scanner;

public class Doodoo3 {

	public static void main(String[] args) {
		// 삽입정렬 왼쪽부터 최워지는거고 i for문에 1부터 시작  tmp에 삽입해놓고 자리를 찾아가는거야
		//  6
		//  13 5 11 7 23 15
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			int j;
			for( j=i-1; j>=0; j--) {
				if(arr[j] > tmp) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
		}
		
		for(int x : arr) System.out.print(x + " ");
		
		
	}

}
