package sunyeal;

import java.util.Scanner;

public class Test1 {
	
	static int n,m;
	static int[] arr, tmp;
	
	public static void combi(int idx) {
		if(idx == m) {
			for(int x : tmp) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				tmp[idx] = i;
				combi(idx+1);
			}
		}
	}

	public static void main(String[] args) {
		// �ߺ����� ���ϱ� 
		// 1���� n���� ��ȣ�� ���� ������ �ֽ��ϴ�. �� �ߺ��� ����Ͽ� m���� �̾� �Ϸķ� ���� �ϴ� ����� ��� ��� 
		
		// 3 2 
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1];
		tmp = new int[m];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		
		combi(0);

	}

}
