package sunyeal;

import java.util.Scanner;

public class Test2 {
	
	static int n,m;
	static int[] arr, pm;
	static boolean[] check;
	
	public static void combi(int idx) {
		
		if(idx == m) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					pm[idx] = arr[i];
					check[i] = true;
					combi(idx + 1);
					check[i] = false;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// 순열구하기 (중복 x) 
		// 10이하의 n개의 자연수가 주어지면 이중 m개를 뽑아 일렬로 나열하는 방법을 모두 출력 
		
		// 3 2 
		// 3 6 9
		
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		pm = new int[m];
		
		combi(0);
		
		

	}

}
