package codingTest.string;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		// �ҹ��ڴ� �빮�ڷ�. �빮�ڴ� �ҹ��ڷ� 
		
		char[] cs = str.toCharArray();
		
		// 24�� ���̳��°� �˰��ְ� a�� A ĳ���� ���� ��� �Ǵ����� �˾ƾߵ�   a �� 97 �̰� A�� 65             65 ~ 90 �� �빮��,  97 ~ 122 �� �ҹ���
		
		String answer = "";
		
		for(int i=0; i < str.length(); i++) {
			if( (int)cs[i] >= 65 && (int) cs[i] <= 90) {
				answer += String.valueOf(cs[i]).toLowerCase();
			} else {
				answer += String.valueOf(cs[i]).toUpperCase();
			}
		}
		
		System.out.println(answer);
		
		
	}

}
