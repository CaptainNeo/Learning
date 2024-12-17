package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Doodoo17 {

	public static void main(String[] args) throws IOException {
		// 학급 회장(해쉬)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int max = 0;
		char answer = 0;

		 for(Character s : map.keySet()) {
			 
			 int v = map.get(s);
			 if(max < v) {
				 max = Math.max(max, v);
				 answer = s;
			 }
			 
		 }
		
		System.out.println(answer);
		
	}

}
