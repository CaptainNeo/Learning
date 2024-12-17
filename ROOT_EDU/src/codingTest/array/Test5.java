package codingTest.array;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// 에라토스테네스의 체 
		
		// 소수를 찾는건대 1과 본인수 외에 나누어 떨어지지 않는 수들 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] intArr = new int[n+1];
		
		int cnt = 0; 
		
		for(int i=2; i<=n; i++) {
			
			if(intArr[i] == 0) cnt++;
			
			for(int j=i; j<=n; j=j+i) {
				intArr[j] = 1;
			}
			
		}
		
		System.out.println(cnt);
		
		

	}

}
