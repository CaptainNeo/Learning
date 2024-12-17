package softeer;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// [한양대 HCPC 2023] Hanyang Popularity Exceeding Competition
		
		Scanner sc = new Scanner(System.in);
		
		// 20만번을 돌아도 되지 않을가? 단순 계산인대... 무식하게 있는 공식 그대로 해보자 
		
		int n = sc.nextInt();
		
		int x = 0;
		
		for(int i=0; i<n; i++) {
			int pi = sc.nextInt();
			int ci = sc.nextInt();
			
			if(Math.abs(pi-x) <= ci) {
				x++;
			}
			
		}
		
		System.out.println(x);
				

	}

}
