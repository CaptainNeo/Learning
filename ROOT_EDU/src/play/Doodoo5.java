package play;

import java.util.Scanner;

public class Doodoo5 {
	
	static int n;
	static int[] arr;
	
	static void getCombi(int idx) {
		
		if(idx == n+1) {
			for(int i=1; i<n+1; i++) {
				if(arr[i] == 1)
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			arr[idx] = 1;
			getCombi(idx + 1);
			arr[idx] = 0;
			getCombi(idx + 1);
		}
		
	}

	public static void main(String[] args) {
		// �κ����� 
		// n�� �־������� n������ �迭�� ������ ��� �� �������� ��� ���� �ʴ´�. 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n+1];
		
		getCombi(1);
		
		

	}

}
