package sunyeal;

import java.util.Scanner;

public class Test3 {
	
	static int n, m;
	static int[] arr, combination;
	
	// *** 조합은 그냥 외워버려  
	
	public static void combi(int idx, int s) {
		if(idx == m) {
			for(int x : combination) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=s; i<=n; i++) {
				combination[idx] = arr[i];
				combi(idx+1, s + 1);
			}
		}
	}
	

	public static void main(String[] args) {
		// 조합 구하기 
		
		// 4 2 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		
		combination = new int[m];
		
		combi(0, 1);
		

	}

}
