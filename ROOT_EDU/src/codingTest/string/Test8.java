package codingTest.string;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); 
		
		String valiStr = "";
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				valiStr += String.valueOf(str.charAt(i)).toUpperCase();
			}
		}
		
		// 위의코드를 str.toUpperCase().replaceAll("[^A-Z]", "")이렇게 만들어 버리네 
		
		String strRvs = new StringBuilder(valiStr).reverse().toString();
		
		String answer = "YES";
		
		if(!valiStr.equals(strRvs)) answer = "NO";
		
		System.out.println(answer);

	}

}
