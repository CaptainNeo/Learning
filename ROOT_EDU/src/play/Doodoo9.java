package play;

import java.util.Scanner;

public class Doodoo9 {

	public static void main(String[] args) {
		// 멘토링
		// 입력되는 데이터를 잘 이해하는게 중요해 행이 m번에 걸친 수학테스트 , 열이 1등 2등..n등순이야 
		
		Scanner sc = new Scanner(System.in);
		
		// 학생 두명씩 비교해야겠지? 두명씩 비교해가면서 i번학생의 등수와 j번학생의 등수를 확인해야겠지 m번의 테스트를 전부다 이길경우를 찾아야지 
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[m][n+1];
		
		for(int i=0; i<m; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			// i번학생을 선택
			for(int j=1; j<=n; j++) {
				// j번학생을 선택
				int iNum = 0;
				int jNum = 0;
				int cnt = 0;  // 시험을 3번이겨야 한다.
				for(int test=0; test<m; test++) {
					// m번의 테스트 동안 i번 학생과 j번학생의 등수를 찾아 
					for(int rank=1; rank<=n; rank++) {
						if(arr[test][rank] == i) iNum = rank;
						if(arr[test][rank] == j) jNum = rank;
					}
					if(iNum > jNum) {
						cnt++;
					}
				}
				
				if(cnt == m) {
					answer += 1;
				}
				
				
				
			}
		}
		
		System.out.println(answer);

	}

}
