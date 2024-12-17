package codingTest.array;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// 피보나치 수열
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] intArr = new int[n];
		
		intArr[0] = 1;
		intArr[1] = 1;
		
		String answer = "";
		answer += intArr[0] + " " + intArr[1] + " "; 
		
		for(int i=2; i<n; i++) {
			intArr[i] = intArr[i-2] + intArr[i-1];
			answer += intArr[i] + " ";
		}
		
		System.out.println(answer);

	}

}
