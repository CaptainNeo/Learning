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
		// �������ϱ� (�ߺ� x) 
		// 10������ n���� �ڿ����� �־����� ���� m���� �̾� �Ϸķ� �����ϴ� ����� ��� ��� 
		
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
