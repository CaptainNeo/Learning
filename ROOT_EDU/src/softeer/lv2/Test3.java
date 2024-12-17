package softeer.lv2;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// 연탄의 크기 
		
		// n개의 난로 반지름 x 정수를 선택하여 n개의 난로반지름에 배수인지 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
//		int min = Integer.MAX_VALUE;
		int min = 2; // 제일 작은 연탄나로의 반지금으로 지정 
		int max = Integer.MIN_VALUE;
		
		for(int i=0 ;i<n; i++) {
			arr[i] = sc.nextInt();
			//min = Math.min(min, arr[i]);  // 나로의 반지름의 길이!! 6 9 12 들어오면? 아 무조건 2부터 시작해야겠구나  
			max = Math.max(max, arr[i]);
		}
		
//		max = (max / 2) + 1; // 마지막 연탄 본인 하나는 넣어야 하자나
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=min; i<=max; i++) {
			int cnt = 0;
			// i반지름의 연탄을 생성해서 n개의 집에 넣어보자 
			for(int j=0; j<n; j++) {
				if(arr[j] % i == 0) cnt++;
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
				
		
		
	}

}
