package codingTest.string;

import java.util.Scanner;

public class Test7 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ������ ������ �ڷ� ������ �Ȱ����� ȸ�� ���ڿ� Ȯ�� ������ 'YES' �ƴϸ� 'NO'
//		�տ��� ���� ���� �ڿ��� ���� ���� ���� ���ڿ��� ȸ�� ���ڿ��̶�� �մϴ�.
//
//		���ڿ��� �ԷµǸ� �ش� ���ڿ��� ȸ�� ���ڿ��̸� "YES", ȸ�� ���ڿ��� �ƴϸ� ��NO"�� ����ϴ� ���α׷��� �ۼ��ϼ���.
//
//		�� ȸ���� �˻��� �� ��ҹ��ڸ� �������� �ʽ��ϴ�.
		String lStr = sc.nextLine();
		
		String rStr = new StringBuilder(lStr).reverse().toString();
		
		lStr = lStr.toUpperCase();
		rStr = rStr.toUpperCase();
		
		String answer = "YES";
		
		if(!lStr.equals(rStr)) {
			answer = "NO";
		}
			
		
		System.out.println(answer);
		
		// �������� str.charAt(i) != str.charAt(len - i -1) �� �ϼ˳�
		
		
		
	}

}
