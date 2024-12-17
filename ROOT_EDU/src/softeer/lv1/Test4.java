package softeer.lv1;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// 주행거리
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a == b) {
			System.out.println("same");
		} else if(a > b) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}

	}

}
