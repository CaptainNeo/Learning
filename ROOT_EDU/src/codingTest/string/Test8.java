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
		
		// �����ڵ带 str.toUpperCase().replaceAll("[^A-Z]", "")�̷��� ����� ������ 
		
		String strRvs = new StringBuilder(valiStr).reverse().toString();
		
		String answer = "YES";
		
		if(!valiStr.equals(strRvs)) answer = "NO";
		
		System.out.println(answer);

	}

}
