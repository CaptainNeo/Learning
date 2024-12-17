package codingTest.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		int[] intArr = new int[n];
		
		for(int i=0; i<n; i++) {
			intArr[i] = sc.nextInt();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(intArr[0]);
		
		for(int i=1; i<intArr.length; i++) {
			if(intArr[i] > intArr[i-1]) {
				list.add(intArr[i]);
			}
		}
		
		for(int i : list) {
			System.out.print(i + " ");
		}
		

	}

}
