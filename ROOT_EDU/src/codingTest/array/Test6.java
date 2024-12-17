package codingTest.array;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// 뒤집은 소수 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] intArr = new int[n];
		
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		int[] intArr2 = new int[n];
		
		int maxNum = 0;
		
		for(int i=0; i<intArr.length; i++) {
			StringBuilder s = new StringBuilder(String.valueOf(intArr[i])).reverse();
			intArr2[i] = Integer.parseInt(s.toString());
			if(maxNum < intArr2[i]) maxNum = intArr2[i];
		}
		
		// 십진수 뒤집는 로직은 아래와 같다 .
		for(int i=0; i<intArr.length; i++) {
			int tmp = intArr[i];
			int res = 0; 
			while(tmp > 0) {  // 4320
				int t = tmp%10;   // 0   2  3  4
				res = res*10+t;   // 0   2  23 234
				tmp = tmp/10;     // 432 43 4  0
			}
			// res에 뒤집힌 십진수가 담긴다.
		}
		
		
		
		int[] intArr3 = new int[maxNum + 1];
		

		for(int i=2; i<maxNum; i++) {
			
			
			if(intArr3[i] == 0) {
				int k = i+i;
				for(int j=k; j<=maxNum; j=j+i) {
					intArr3[j] = 1;
				}
			}
			
			
			
		}
		
		String answer = "";
		
		for(int i=0; i<intArr2.length; i++) {
			if(intArr3[intArr2[i]] == 0 && intArr2[i] != 1) answer += intArr2[i] + " ";
		}
		
		System.out.println(answer);
		


	}

}
