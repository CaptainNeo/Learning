package codingTest.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		// 문장에서 공백이 있는?? 뭘로 확인하지 ?? 아스키코드표로 확인하자 32가 space네 
		// 음아니네 공백으로 문자열을 제거하면되겟네
		// 문자열로 쪼갰을때 근대 그러고나서 제일긴문자열을 어떻게 뽑는다쳐 그게 끝이아니지 
		
		int flagL = 0;
		
		String[] bList = sc.nextLine().split(" ");
		for(int i=0; i < bList.length; i++) {
			if(bList[i].length() > flagL) {
				flagL = bList[i].length();
				if(!m.containsKey(flagL)) {
					m.put(flagL, bList[i]);
				}
			}
		}
		
		System.out.println(m.get(flagL));
		


	}

}
