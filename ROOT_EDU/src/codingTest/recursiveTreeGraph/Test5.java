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
//			System.out.print(root.data + " ");  // �����ȸ
			dfs(root.lt);
//			System.out.print(root.data + " ");  // ������ȸ
			dfs(root.rt);
			System.out.print(root.data + " ");  // ������ȸ
		}
		
		
	}

	public static void main(String[] args) {
		
		// ����Ʈ�� ��ȸ(���̿켱Ž��)
		// ������ȸ, ������ȸ, ������ȸ 
		
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
