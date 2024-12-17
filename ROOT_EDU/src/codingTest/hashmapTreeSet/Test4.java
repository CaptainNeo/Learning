package codingTest.hashmapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] s = sc.nextLine().toCharArray();
		char[] t = sc.nextLine().toCharArray();
		
		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();
		
		for(int i=0; i<t.length-1; i++) {
			mapA.put(s[i], mapA.getOrDefault(s[i], 0) + 1);
		}
		
		for(int i=0; i<t.length; i++) {
			mapB.put(t[i], mapB.getOrDefault(t[i], 0) + 1);
		}
		
		int lt = 0;
		int answer = 0;
		
		// °ËÁõ
		for(int rt=t.length-1; rt<s.length; rt++) {
			
			mapA.put(s[rt], mapA.getOrDefault(s[rt], 0) + 1);
			
			if(mapA.equals(mapB)) answer++;
			
			mapA.put(s[lt], mapA.get(s[lt]) - 1);
			if(mapA.get(s[lt]) == 0) mapA.remove(s[lt]);
			lt++;
			
			
		}
		
		System.out.println(answer);
		

	}

}
