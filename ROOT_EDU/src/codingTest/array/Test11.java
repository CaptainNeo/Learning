package codingTest.array;

import java.util.Scanner;

public class Test11 {
	
	public static int solution(int n, int[][] arr) {
		int answer=0, max=Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++) {
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break; // 중요 i번째 학생이랑 j번째 학생 비교하는대 한번만 비교해야지 학년 다 보면안된다 
					}
				}
			}
			if(cnt>max) {
				max = cnt;
				answer = i;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][6];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		System.out.println(solution(n, arr));
		

	}

}
