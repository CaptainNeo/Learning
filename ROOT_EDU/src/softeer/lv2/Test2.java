package softeer.lv2;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		// [�Ѿ�� HCPC 2023] Yeah, but How?
		// �������� ��ȣ ���ڿ� <<=== �� �׳� stack ��������... Ű����Ʈ�� �������ε� Ǯ���־� ������ ������ ! 
		
		// (()())  ()()()

		
		// )�� �������� stack ����� 1�� �̻��̸� 1 + 1����ߵǰ�  )�� ���������� �ݴ� �����̴�  + 1�� ��ߵǰ� 
		// ()()() ���̽��� ���ؼ� ������ ���غ��ڸ� ���� ���̽� �÷��� (�� ���������� ������ߵǳ� ��� �������ĺ��� (������ �տ��ٰ� + �������
		
		// �ٽ� �������ڸ� index�� 1 �̻��ϰ��  ( ������ answer += "+" �� �����ش�
		// )��������� size üũ�ؼ� ����� 1�̻��ΰ�� 1 + 1 size�� 1�ΰ�� 1 �� answer�� �����ش�.
		
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		
		String str = sc.nextLine();
		
		String answer = "";
		
		System.out.println(str.replace("()", "(1)").replace(")(", ")+("));
		
		
	}

}
