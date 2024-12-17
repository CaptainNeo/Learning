package codingTest.array;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		// 1:가위 2:바위 3:보 게임
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		String aInfo = sc.nextLine().replace(" ", "");
		String bInfo = sc.nextLine().replace(" ", "");
		
		for(int i=0; i<n; i++) {
			
			String a = String.valueOf(aInfo.charAt(i));
			String b = String.valueOf(bInfo.charAt(i));
			String answer = "";
			
			// 어떻게 간결하게 이기고 진거를 표시하지 a이긴것만 체크하고 나머지는 b가 이인거지 비긴거는 맨앞에서 막고
			
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
