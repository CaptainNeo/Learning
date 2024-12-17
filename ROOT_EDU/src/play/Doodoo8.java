package play;

import java.util.Scanner;

public class Doodoo8 {

	public static void main(String[] args) {
		// 임시반장 정하기 (배열 문제)
		// 자기반 학생 중에서 각 학생들이 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 선출
		// 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 선출한다.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][5+1];  // 행이 학생을 의미 , 열이 학년을 의미 
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=5; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 키포인트 i번학생이 j번학생과 k학년이 같은가? 같으면 cnt++
		int max = Integer.MIN_VALUE;
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			// i번학생을 뽑아
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				// j번학생을 뽑아 
				
				for(int k=1; k<=5; k++) {
					// 5학년까지 같은지 확인을 하는대 한번이라도 같으면  cnt 늘리고 탈출
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
						// i번학생이 j번학생하고 같은 반이었다고 간주 
					}
				}
				
				
			}
			
			if(max < cnt) {
				max = cnt;
				answer = i;
			}
			
		}
		
		System.out.println(answer);
		
		

	}

}
