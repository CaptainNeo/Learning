package codingTest.array;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] intArr = new int[n];
		
		for(int i=0; i<n; i++) {
			
			intArr[i] = sc.nextInt();
			
		}
		
		
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			
			int cnt = 1;
			
			for(int j=0; j<intArr.length; j++) {
				if(intArr[i] < intArr[j]) cnt++;
			}
			
			answer[i] = cnt;
			
		}  // outer for loop
		
		for(int i : answer) 
			System.out.print(i + " ");
		

	}

}
