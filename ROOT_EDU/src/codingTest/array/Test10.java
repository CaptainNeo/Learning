package codingTest.array;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 상 우 하 좌 
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				// 현재 나 자신이 상하좌우 숫자보다 큰 봉우리인지 체크
				boolean flag = true;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < n && ny >=0 && ny < n && arr[i][j] <= arr[nx][ny]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
//					System.out.println("i => " + i + "  " + "j => " + j);
					answer++;
				}
				
				
			}
		}
		
		System.out.println(answer);
		

	}

}
