package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Doodoo18 {

	public static void main(String[] args) throws IOException {
		// 아나그램
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		String str1 = br.readLine();
		
		for(char c : str1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		
		
		String str2 = br.readLine();
		for(char c : str2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		
		
		String answer = "YES";
		
		for(Character c : str1.toCharArray()) {
			if(!map2.containsKey(c)) {
				answer = "NO";
				break;
			}
			
			if(map1.get(c) != map2.get(c)) {
				answer = "NO";
				break;
			}
		}
		
		
		System.out.println(answer);
		

	}

}
