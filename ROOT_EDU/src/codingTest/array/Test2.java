package codingTest.array;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] intArr = new int[n];
		
//		sc.nextLine();
		
		
		
		for(int i=0; i<n; i++) {
			
			intArr[i] = sc.nextInt();
			
		}
		
		int answer = 0;
		int maxHeight = 0;
		
		for(int i=0; i<n; i++) {
			
			if(intArr[i] > maxHeight) {
				maxHeight = intArr[i];
				answer ++;
			}
			
			
		}
		
		
		System.out.println(answer);
		

	}

}
