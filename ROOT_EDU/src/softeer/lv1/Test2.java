package softeer.lv1;

import java.util.Scanner;

public class Test2 {
	
	static int answer = 0;
	static int sd;
	static int[] tmp;
	static int cnt;
	
	public static void combi(int[] arr, int idx, int s) {
		
		if(idx == 2) {
			if(tmp[1] - tmp[0] == sd) {
				cnt++;
			}
			return;
		} else {
			for(int i=s; i<arr.length; i++) {
				tmp[idx] = arr[i];
				combi(arr, idx + 1, s + 1);
			}
		}
		
	}

	public static void main(String[] args) {
		// 연탄 배달의 시작
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sd = Integer.MAX_VALUE;
		tmp = new int[2];  // 2개마을
		
		for(int i=1; i<n; i++) {
			if(arr[i] - arr[i-1] < sd) {
				sd = arr[i] - arr[i-1];
			}
		}
		
		combi(arr, 0, 0);
		
		System.out.println(cnt);

	}

}
