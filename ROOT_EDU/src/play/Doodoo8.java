package play;

import java.util.Scanner;

public class Doodoo8 {

	public static void main(String[] args) {
		// �ӽù��� ���ϱ� (�迭 ����)
		// �ڱ�� �л� �߿��� �� �л����� 1�г���� 5�г���� �������鼭 �ѹ��̶� ���� ���̾��� ����� ���� ���� �л��� �ӽ� �������� ����
		// �л� �߿��� 1�г���� 5�г���� �������鼭 �ѹ��̶� ���� ���̾��� ����� ���� ���� �л��� �ӽ� �������� �����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][5+1];  // ���� �л��� �ǹ� , ���� �г��� �ǹ� 
		
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
		
		// Ű����Ʈ i���л��� j���л��� k�г��� ������? ������ cnt++
		int max = Integer.MIN_VALUE;
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			// i���л��� �̾�
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				// j���л��� �̾� 
				
				for(int k=1; k<=5; k++) {
					// 5�г���� ������ Ȯ���� �ϴ´� �ѹ��̶� ������  cnt �ø��� Ż��
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
						// i���л��� j���л��ϰ� ���� ���̾��ٰ� ���� 
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
