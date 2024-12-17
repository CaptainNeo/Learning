package codingTest.string;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] cArr = str.toCharArray();
		
		int[] answer = new int[cArr.length];
		
		char c = sc.next().charAt(0);
		
		int checkNum = 1000;
		
		// 왼쪽부터 순환 
		for(int i=0; i<cArr.length; i++) {
			if(cArr[i] == c) {
				answer[i] = 0;
				checkNum = 0;
			} else {
				checkNum += 1;
				answer[i] = checkNum;
			}
		}
		
		// 오른쪽 순환 
		for(int i=cArr.length-1; i >= 0; i--) {
			if(cArr[i] == c) {
				answer[i] = 0;
				checkNum = 0;
			} else {
				checkNum += 1;
				if(answer[i] > checkNum) answer[i] = checkNum;
			}
		}
		
		for(int i : answer) {
			System.out.print(i + " ");
		}
		
		
		
	}

}
