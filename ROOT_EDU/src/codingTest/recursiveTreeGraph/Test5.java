package codingTest.recursiveTreeGraph;


class Node {
	int data;
	Node lt, rt;
	public Node(int val) {
		data = val;
		lt=rt=null;
	}
}

public class Test5 {
	public static void dfs(Node root) {
		if(root == null) return;
		else {
//			System.out.print(root.data + " ");  // 전희순회
			dfs(root.lt);
//			System.out.print(root.data + " ");  // 중위순회
			dfs(root.rt);
			System.out.print(root.data + " ");  // 후위순회
		}
		
		
	}

	public static void main(String[] args) {
		
		// 이진트리 순회(깊이우선탐색)
		// 전위순회, 중위순회, 후위순회 
		
		Node root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		root.rt.lt = new Node(6);
		root.rt.rt = new Node(7);
		
		dfs(root);
		
		

	}

}
