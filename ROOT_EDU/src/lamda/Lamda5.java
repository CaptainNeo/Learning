package lamda;

import java.util.function.Function;

//�޼��� ����(method reference)
//
//- �ϳ��� �޼��常 ȣ���ϴ� ���ٽ��� '�޼��� ����'�� ������ �� �� �ִ� . 
//
//����                     ����                                     �޼�������
//
//static�޼�������          (x) -> ClassName.method(x)              ClassName::method
//�ν��Ͻ��޼��� ����           (obj, x) -> obj.method(x)              ClassName::method
//Ư�� ��ü �ν��Ͻ��޼��� ����    (x) -> obj.method(x)                   obj::method
//
//
//Integer method (String s) {
//	return Integer.parseInt(s);
//}
//
//���� ������ �Ʒ�ó�� ��� ����
//int result = Integer.parseInt("123");
//
//Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//
//���⼭ �޼��� ���� ������ �ڵ��ϸ� 
//
//Function<String, Integer> f = Integer::parseInt;	// �޼��� ����
//

public class Lamda5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f = Integer::parseInt; // �޼��� ����
		System.out.println(f.apply("222") + 78);

	}

}
