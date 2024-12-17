package codingTest.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Test10 {
	
	// Test9를 BFS로 풀어야 맞다 BFS로 풀어보자 
	
	public static int bfs(Node2 root) {
		
		Queue<Node2> q = new LinkedList<>();
		
		q.offer(root);
		int level = 0;
		
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i=0; i<len; i++) {
				Node2 cur = q.poll();
				if(cur.lt == null && cur.rt == null) return level;
				if(cur.lt != null) q.offer(cur.lt);
				if(cur.rt != null) q.offer(cur.rt);
			}
			level++;
		}
		
		return 0;
		
	}

	public static void main(String[] args) {
		
			
		// Tree 말단 노드까지의 가장 짧은 경로 
		// 루트노드 1에서 말단노드까지 길이 중 가장 짧은 길이를 구하시오 
		Node2 root = new Node2(1);
		root.lt = new Node2(2);
		root.rt = new Node2(3);
		root.lt.lt = new Node2(4);
		root.lt.rt = new Node2(5);
		
		System.out.println(bfs(root));
			


	}

}
