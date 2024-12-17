package play;

import java.util.Scanner;

public class Doodoo6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		char t = sc.next().toCharArray()[0];
		
		int[] arr = new int[s.length()];
		
		int num = 1000;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == t) {
				arr[i] = 0;
				num = 0;
			} else {
				num++;
				arr[i] = num;
			}
		}
		
//		num = 0;  <=== �̰� ���� �ָ�ȵ�
		num = 1000;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == t) {
				arr[i] = 0;
				num = 0;
			} else {
				num++;
				if(arr[i] > num) {
					arr[i] = num;
				}
			}
		}
		
		for(int x : arr) 
			System.out.print(x + " ");

	}

}
