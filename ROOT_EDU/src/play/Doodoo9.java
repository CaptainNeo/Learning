package play;

import java.util.Scanner;

public class Doodoo9 {

	public static void main(String[] args) {
		// ���丵
		// �ԷµǴ� �����͸� �� �����ϴ°� �߿��� ���� m���� ��ģ �����׽�Ʈ , ���� 1�� 2��..n����̾� 
		
		Scanner sc = new Scanner(System.in);
		
		// �л� �θ� ���ؾ߰���? �θ� ���ذ��鼭 i���л��� ����� j���л��� ����� Ȯ���ؾ߰��� m���� �׽�Ʈ�� ���δ� �̱��츦 ã�ƾ��� 
		
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
			// i���л��� ����
			for(int j=1; j<=n; j++) {
				// j���л��� ����
				int iNum = 0;
				int jNum = 0;
				int cnt = 0;  // ������ 3���̰ܾ� �Ѵ�.
				for(int test=0; test<m; test++) {
					// m���� �׽�Ʈ ���� i�� �л��� j���л��� ����� ã�� 
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
