package codingTest.array;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		// 1:���� 2:���� 3:�� ����
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		String aInfo = sc.nextLine().replace(" ", "");
		String bInfo = sc.nextLine().replace(" ", "");
		
		for(int i=0; i<n; i++) {
			
			String a = String.valueOf(aInfo.charAt(i));
			String b = String.valueOf(bInfo.charAt(i));
			String answer = "";
			
			// ��� �����ϰ� �̱�� ���Ÿ� ǥ������ a�̱�͸� üũ�ϰ� �������� b�� ���ΰ��� ���Ŵ� �Ǿտ��� ����
			
			if(a.equals(b)) {
				answer = "D";
			} else if( (a.equals("1") && b.equals("3")) || (a.equals("2") && b.equals("1")) || (a.equals("3") && b.equals("2")) ) {
				answer = "A";
			} else {
				answer = "B";
			}
			
			
			System.out.println(answer);
		}

	}

}
