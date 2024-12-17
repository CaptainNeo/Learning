package play;

import java.util.Scanner;

public class Doodoo15 {

	public static void main(String[] args) {
		// 연속된 자연수의 합 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		int cnt = 1;
		n--;
		while(n>0) {
			cnt++;
			n = n-cnt;
			if(n%cnt == 0) answer++;
		}
		
		System.out.println(answer);

	}

}
