package softeer.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// GPT�� ���� �� 
		// Ű����Ʈ�� ���� ����
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println(Integer.compare(2, 11)); // ���� ���� �� ũ�� 1, ������ -1, ������ 0
		
		int n  = sc.nextInt();
		sc.nextLine();
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(sc.nextLine());
		}
		
		Collections.sort(list, (num1, num2) -> {
			String[] parts1 = num1.split("\\.");
	        String[] parts2 = num2.split("\\.");

	        // x�� ��
	        int x1 = Integer.parseInt(parts1[0]);
	        int x2 = Integer.parseInt(parts2[0]);

	        if (x1 != x2) {
	            return Integer.compare(x1, x2);  // �������� 
	        }

	        // y�� ��
	        int y1 = (parts1.length > 1) ? Integer.parseInt(parts1[1]) : -1; // �Ҽ��� ������ -1
	        int y2 = (parts2.length > 1) ? Integer.parseInt(parts2[1]) : -1;

	        return Integer.compare(y1, y2);
		});
		
		for(String x : list) {
			System.out.println(x);
		}
		

	}

}
