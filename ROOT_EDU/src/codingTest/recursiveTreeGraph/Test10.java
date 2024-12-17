package codingTest.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Test10 {
	
	// Test9�� BFS�� Ǯ��� �´� BFS�� Ǯ��� 
	
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
		
			
		// Tree ���� �������� ���� ª�� ��� 
		// ��Ʈ��� 1���� ���ܳ����� ���� �� ���� ª�� ���̸� ���Ͻÿ� 
		Node2 root = new Node2(1);
		root.lt = new Node2(2);
		root.rt = new Node2(3);
		root.lt.lt = new Node2(4);
		root.lt.rt = new Node2(5);
		
		System.out.println(bfs(root));
			


	}

}
