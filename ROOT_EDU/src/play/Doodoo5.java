package play;

import java.util.Scanner;

public class Doodoo5 {
	
	static int n;
	static int[] arr;
	
	static void getCombi(int idx) {
		
		if(idx == n+1) {
			for(int i=1; i<n+1; i++) {
				if(arr[i] == 1)
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			arr[idx] = 1;
			getCombi(idx + 1);
			arr[idx] = 0;
			getCombi(idx + 1);
		}
		
	}

	public static void main(String[] args) {
		// 부분집합 
		// n이 주어졌을때 n까지의 배열의 집할을 출력 단 공집합은 출력 하지 않는다. 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n+1];
		
		getCombi(1);
		
		

	}

}
