package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Smo implements Comparable<Smo>{
	int height;
	int weight;
	
	Smo(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Smo o) {
		if(this.height == o.height) return this.weight - o.weight;
		else return o.height - this.height;
	}
}

public class Doodoo36 {
	
	static StringTokenizer st;
	static ArrayList<Smo> list;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// ¾¾¸§¼±¼ö
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			list.add(new Smo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		Collections.sort(list);
		
		exec();
		
		System.out.println(answer);

	}
	
	public static void exec() {
		Smo s = list.get(0);
		answer++;
		int height = s.height;
		int weight = s.weight;
		
		
		for(int i=1; i<list.size(); i++) {
			Smo tmp = list.get(i);
			
			if(weight < tmp.weight) {
				answer++;
				height = tmp.height;
				weight = tmp.weight;
			}
			
		}
		
		
	}

}
