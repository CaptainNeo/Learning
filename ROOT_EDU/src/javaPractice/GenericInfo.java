package javaPractice;

class EmplyeeInfo {
	public int rank;
	EmplyeeInfo(int rank) {
		this.rank = rank;
	}
}

class Person<T, S> {
	public T info;
	public S id;
	Person(T info, S id) {
		this.info = info;
		this.id   = id;
	}
	
	public <U> void printInfo(U info) {
		System.out.println(info);
	}
}

public class GenericInfo {

	public static void main(String[] args) {
		EmplyeeInfo e = new EmplyeeInfo(1);
		Integer i = new Integer(10);
		Person p1 = new Person(e, i);
		p1.printInfo(e);

	}

}
