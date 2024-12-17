package codingTest.hashmapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		for(Character c : str1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		
		for(Character c : str2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		
		String answer = "YES";
		
		// ∞À¡ı
		for(Character c : str1.toCharArray()) {
			
			if(!map2.containsKey(c)) {
				answer = "NO";
				break;
			} else if(map2.get(c) != map1.get(c)) {
				answer = "NO";
				break;
			}
			
		}
		
		System.out.println(answer);
		
		
		

	}

}
