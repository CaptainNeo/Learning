package javaPractice;

abstract class Info {
	public abstract int getLevel();
}

class EmployeeInfo extends Info {
	public int rank;
	EmployeeInfo(int rank) {
		this.rank = rank;
	}
	
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.getLevel();
	}
	
}

class Person2<T extends Info> {  // Info class �̰ų� Info�� ����� �ڽ�Ŭ���� �ΰ� ������ Ȯ��
	public T info;
	Person2(T info) {
		this.info = info;
	}
}

public class GenericInfo2 {

	public static void main(String[] args) {
		
		Person2 p1 = new Person2(new EmployeeInfo(1));
//		Person<String> p2 = new Person<String>("����");
				

	}

}
