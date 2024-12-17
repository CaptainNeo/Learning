package codingTest.string;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		// Ư�����ڿ� ������ 
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		char[] cArr = str.toCharArray();  // char �迭�� ������ְ�
		
		int lt = 0;  // ���� ���ĺ��������� ���ؼ� index Ȯ�ο����� lt, rt �ʱ�ȭ 
		int rt = cArr.length - 1;
		
		while(lt < rt) {  // �ΰ��� �ε����� ���������� 
			if(!Character.isAlphabetic(cArr[lt])) {
				lt++;
			}
			else if(!Character.isAlphabetic(cArr[rt])) {
				rt--;
			}
			else {
				char tmp = cArr[lt];
				cArr[lt] = cArr[rt];
				cArr[rt] = tmp;
				lt++; rt--;  // �ΰ��� ���� 
			}
		}
		
		System.out.println(String.valueOf(cArr));
		

	}

}

