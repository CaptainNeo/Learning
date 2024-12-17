package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Doodoo20 {

	public static void main(String[] args) throws IOException {
		// 모든아나그램 찾기 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, Integer> a = new HashMap<>();
		HashMap<Character, Integer> b = new HashMap<>();
		
		
		int answer = 0;
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		for(char c : str2.toCharArray()) b.put(c, b.getOrDefault(c, 0) + 1);
		
		for(int i=0; i<str2.length(); i++) {
			a.put(str1.charAt(i), a.getOrDefault(str1.charAt(i), 0) + 1);
		}
		
		if(a.equals(b)) answer++;
		
		
		int lt = 0;
		
		for(int rt=str2.length(); rt<str1.length(); rt++) {
			
			a.put(str1.charAt(rt), a.getOrDefault(str1.charAt(rt), 0) + 1);
			
			a.put(str1.charAt(lt), a.get(str1.charAt(lt)) - 1);
			
			if(a.get(str1.charAt(lt)) == 0) {
				a.remove(str1.charAt(lt));
			}
			
			if(a.equals(b)) answer++;
			
			lt++;
		}
		
		
		
		System.out.println(answer);
		

	}

}
