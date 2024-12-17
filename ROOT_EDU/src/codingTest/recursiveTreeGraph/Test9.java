package codingTest.recursiveTreeGraph;

class Node2 {
	int data;
	Node2 lt, rt;
	
	Node2(int val) {
		this.data = val;
		lt=rt=null;
	}
}

public class Test9 {
	
	public static int dfs(int L, Node2 root) {
		
		if(root.lt == null && root.rt == null) return L;
		else return Math.min(dfs(L+1, root.lt) , dfs(L+1, root.rt));
		
	}

	public static void main(String[] args) {
		
		// Tree 말단 노드까지의 가장 짧은 경로 
		// 루트노드 1에서 말단노드까지 길이 중 가장 짧은 길이를 구하시오 
		Node2 root = new Node2(1);
		root.lt = new Node2(2);
		root.rt = new Node2(3);
		root.lt.lt = new Node2(4);
		root.lt.rt = new Node2(5);
		
		System.out.println(dfs(0, root));
		

	}

}
