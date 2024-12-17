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
		
		// Tree ���� �������� ���� ª�� ��� 
		// ��Ʈ��� 1���� ���ܳ����� ���� �� ���� ª�� ���̸� ���Ͻÿ� 
		Node2 root = new Node2(1);
		root.lt = new Node2(2);
		root.rt = new Node2(3);
		root.lt.lt = new Node2(4);
		root.lt.rt = new Node2(5);
		
		System.out.println(dfs(0, root));
		

	}

}
