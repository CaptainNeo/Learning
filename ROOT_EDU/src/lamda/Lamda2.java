package lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//�Լ��� �������̽� 
// - �Լ��� �������̽� > �� �ϳ��� �߻� �޼��常 ����� �������̽� 
//@FunctionalInterface <-- �������� ����Ʈ �����Ϸ��� �ùٸ��� �ۼ��ϴ��� Ȯ������� 
// interface Iamfunction {
//	 public abstrac int max(int a, int b);
// }
//
//���� �Ʒ�ó�� �����ϸ� 
//Iamfunction f = new Iamfunction() {
//	public int max(int a, int b) {
//		return a > b ? a : b;
//	}
//}
//
//int value = f.max(3, 5);  // Iamfunction�� max()�� �־ ��밡�� 
//
//���� ���̽��� ��� 
//
// - �Լ��� �������̽� Ÿ���� ���������� ���ٽ��� ������ �� ���� 
// (��, �Լ��� �������̽��� �޼���� ���ٽ��� �Ű����� ������ ��ȯŸ���� ��ġ�ؾ� ��)
// 
//
// Iamfunction f = (a, b) -> a > b ? a: b;
// 
// int value = f.max(3, 5);	// �����δ� ���ٽ�(�͸� �Լ�) ȣ���

// �ǽ��� �غ���~~



















public class Lamda2 {

	public static void main(String[] args) {

//	Object obj = (a, b) -> a > b ? a: b; 	// ���ٽ�, �͸�ü

		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};

//	int v = obj.max(3,5);

		IamFunction iamF = new IamFunction() {

			@Override
			public int max(int a, int b) { // �������̵� -- ���������� default �� �ƴ� public
				// TODO Auto-generated method stub
				return a > b ? a : b;
			}

		};

		int v2 = iamF.max(9, 2); // �Լ��� �������̽�
		System.out.println("value=" + v2);

		// ���� ���ٽ��� �Ẽ�Կ�
		// ���ٽ�(�͸�ü)�� �ٷ�� ���� ���������� Ÿ���� �Լ��� �������̽��� �ؿ�
		IamFunction lamdaRef = (a, b) -> a > b ? a : b;
		int v3 = lamdaRef.max(3, 5);
		System.out.println(v3);

		// ���� �� �͸� ��ü�� ���ٽ����� ��ü�ϴ� ������ ����� ���Կ�
		// Comparator<String>

		List<String> list = Arrays.asList("���ε�", "���ε�", "�ٵε�", "�ϵε�", "��ε�");

		Collections.sort(list, (s1, s2) -> s2.compareTo(s1)); // ������ ����

		System.out.println(list);

		// ��� �Ʒ��� ���� ����� �߾�� ���ٽ��� ����ؼ� ������ ������ �����ϰ� ���Եǰ� ���������
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.compareTo(s1);
			}

		});

		// ��ó�� �����Ѱ� �Ű������� ���ٽ��� �ްڴٴ°��� �Լ��� �������̽� Ÿ���� �Ű������� ���� ��
		Doodoo d = () -> System.out.println("���� ���ٽ� ��ȯ�̾�");

		aMethod(d); // �Լ��� �������̽� Ÿ���� �Ű����� ��밡��

		Doodoo dd = bMethod(); // �Լ��� �������̽� Ÿ���� ��ȯŸ�Ե� �����ؿ�

		System.out.println(dd); // ���ٽ�

	}

	static void aMethod(Doodoo d) {
		d.doodooMethod();
	}

	static Doodoo bMethod() {
//		Doodoo f = () -> {};
//		return f;
		return () -> {
		};
	}

	// ���ݸ� �� �����غ�����

}

@FunctionalInterface // �Լ��� �������̽��� �� �ϳ��� �߻� �޼��常 ������ �ؿ� ~ ��Ģ�̿��� �ܿ��� ���� �׳� �׷����� �ؿ� ��
interface IamFunction {
//	public abstract int max(int a, int b);  // ���ܾ��� public abstrac �̹Ƿ� ��������
	int max(int a, int b);
//	public abstract int max2(int a, int b)
}

@FunctionalInterface
interface Doodoo {
	void doodooMethod();

}