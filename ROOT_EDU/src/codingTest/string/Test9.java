package codingTest.string;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		str = str.replaceAll("[^0-9]", "");
		
		System.out.println(Integer.parseInt(str));

	}

}
