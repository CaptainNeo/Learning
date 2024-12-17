package codingTest.hashmapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
				
			
		String str = sc.nextLine();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(char c : str.toCharArray()) {
			String s = String.valueOf(c);
			
			if(map.get(s) == null) {
				map.put(s, 1);
			} else {
				int cnt = map.get(s) + 1 ;
				map.put(s, cnt);
			}
			
		}
		
		String answer = "";
		int maxNum = Integer.MIN_VALUE;
		
		for(String key : map.keySet()) {
			if(map.get(key) > maxNum) {
				answer = key;
				maxNum = map.get(key);
			}
		}
		
		System.out.println(answer);
		
			

	}

}
