package play;

import java.util.Scanner;

public class Doodoo3 {

	public static void main(String[] args) {
		// �������� ���ʺ��� �ֿ����°Ű� i for���� 1���� ����  tmp�� �����س��� �ڸ��� ã�ư��°ž�
		//  6
		//  13 5 11 7 23 15
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			int j;
			for( j=i-1; j>=0; j--) {
				if(arr[j] > tmp) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
		}
		
		for(int x : arr) System.out.print(x + " ");
		
		
	}

}
