package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Test10866 {

	public static void main(String[] args) throws IOException {
		// µ¦
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			
			String se = st.nextToken();
			
			switch(se) {
				case "push_front":
					dq.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					dq.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.getFirst()).append("\n");
						dq.removeFirst();
					}
					break;
				case "pop_back":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.getLast()).append("\n");
						dq.removeLast();
					}
					break;
				case "size":
					sb.append(dq.size()).append("\n");
					break;
				case "empty":
					if(dq.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.getFirst()).append("\n");
					}
					break;
				case "back":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.getLast()).append("\n");
					}
					break;
			}
			
		}
		
		System.out.println(sb);

	}

}
