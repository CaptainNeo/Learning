package softeer.lv2;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		// [한양대 HCPC 2023] Yeah, but How?
		// 균형잡힌 괄호 문자열 <<=== 난 그냥 stack 문제인줄... 키포인트는 스택으로도 풀수있어 하지만 복잡해 ! 
		
		// (()())  ()()()

		
		// )를 만났을때 stack 사이즈가 1나 이상이면 1 + 1을써야되고  )를 만났을때는 닫는 가로이니  + 1을 써야되고 
		// ()()() 케이스를 더해서 로직을 구해보자면 위에 케이스 플러스 (를 만났을때도 정해줘야되네 대신 시작이후부터 (만나면 앞에다가 + 써줘야해
		
		// 다시 정리하자면 index가 1 이상일경우  ( 만나면 answer += "+" 를 더해준다
		// )만났을경우 size 체크해서 사이즈가 1이상인경우 1 + 1 size가 1인경우 1 을 answer에 더해준다.
		
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		
		String str = sc.nextLine();
		
		String answer = "";
		
		System.out.println(str.replace("()", "(1)").replace(")(", ")+("));
		
		
	}

}
