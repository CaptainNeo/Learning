package codingTest.array;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		// key 포인트는 이중포문 사람으로
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int cnt = 0;
				for(int k=0; k<m; k++) {
					int pi = Integer.MIN_VALUE;
					int pj = Integer.MIN_VALUE;
					for(int s=0; s<n; s++) {
						if(arr[k][s] == i) {
							pi = s;
						}
						if(arr[k][s] == j) {
							pj = s;
						}
					}
					if(pi < pj) cnt++;
				}
				
				if(cnt == m) answer++;
				
			}
		}
		
		System.out.println(answer);
		
		

	}
	
	

}
