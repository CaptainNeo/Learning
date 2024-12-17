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
		// 중복순열 구하기 
		// 1부터 n까지 번호가 적힌 구슬이 있습니다. 이 중복을 허락하여 m번을 뽑아 일렬로 나열 하는 방법을 모두 출력 
		
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
