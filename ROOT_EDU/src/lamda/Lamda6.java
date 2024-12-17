package lamda;

import java.util.function.Function;
import java.util.function.Supplier;

//
//- �������� �޼��� ����
//�����ڿ� �޼��� ���� 
//Supplier<Doodoo> d = () -> new Doodoo();
//
//Supplier<Doodoo> d = Doodoo::new;
//
//Function<Integer, Doodoo> d = (i) -> new Doodoo(i);
//
//Function<Integer, Doodoo> d = Doodoo::new;
//
//���Ͱ��� ����ϴ� ������ �ϳ��� �迭�� �޼��� ������ �� ����ؿ� ~~ 
//
//Function<Integer, int[]> f = x -> new int[x];		// ���ٽ�
//
//Function<Integer, int[]> f2 = int[]::new;	// �޼��� ����

public class Lamda6 {
	public static void main(String[] args) {

		// Supplier�� �Է� X, ��� O
//		Supplier<Doodoo2> s = () -> new Doodoo2();

		Supplier<Doodoo2> s = Doodoo2::new;

		Doodoo2 d = s.get();

		System.out.println(d);

		Function<Integer, Doodoo3> f = (i) -> new Doodoo3(i);

		Doodoo3 dd = f.apply(120);

		System.out.println(dd.iv);

		System.out.println(f.apply(222).iv);

		// �迭�� ����� ���Կ�

		Function<Integer, int[]> f2 = int[]::new; // �޼��� ����

		int[] arr = f2.apply(100);

		System.out.println("arr.length=" + arr.length);

	}
}

class Doodoo2 {

}

class Doodoo3 {
	int iv;

	Doodoo3(int iv) {
		this.iv = iv;
	}
}