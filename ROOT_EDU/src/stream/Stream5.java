package stream;

import java.util.Optional;
import java.util.OptionalInt;

//Optional<T>
// - ���׸� T Ÿ�� ��ü�� ����Ŭ���� (Integer, Long)
// - TŸ���� ���������� ���� �� �־�� ��� ������ ��ü����, !! �߿� NULL �� ����
// 
// 1. null�� �����ٷ�°��� �����ؿ� null point exception�� �߻��� �� �־�� 
// �׷��� ���������� Optional�� ����ؿ� 
// 
// 2. null�� �ٷ�ٸ� null üũ�� �ؾ��ϴ´� if���� �ʼ����� �ڵ尡 ������������ 
// 
// �̷��������� �ذ��ϱ� ���� Optional�� ����ؼ� ���������� �ٷ�� �����߾�� 
// 
//Object result = getResult(); <---��ȯ���� �ϳ��� null �̰ų� ��ü����?? 
//�׷� result.toStr()  �̶�� ������ null point exception�� �߻��ϰ��� 
//
//�׷� �츮�� �Ʒ��� ���� ����� 
//if(result != null) {
//	print(result.toStr());
//}
//
//Optional�� ����ִ°ſ��� �׷��� Optional���� �ּҰ� �ֱ⶧���� �׻� null �� �ƴϿ��� (ox120)
//

//Optional<T> ��ü�� �� �������� 
//- get(), orElse(), orElseGet(), orElseThrow()
//
//Optional<String> optVal = Optional.of("abc");
//String str1 = optVal.get();	// optVal�� ����� ���� ��ȯ. null�̸� ���� �߻�
//String str2 = optVal.orElse("")	// optVal�� ����� ���� null�϶��� ""�� ��ȯ
//String str3 = optVal.orElseGet(String::new);	// ���ٽ� ��밡�� () -> new String()
//String str4 = optVal.orElseThrow(NullPointerException::new);		// ���̸� ���ܹ߻�

//ifPresent() - Optional��ü�� ���� null �̸� false, �ƴϸ� true�� ��ȯ
//
//Optional.ofNullable(str).ifPresent(System.out::println); <-- ifPresent�� ���� �ƴҶ��� �۾����� ���̸� �ƹ��͵� �� �� 

// isPresent() - Optional��ü ���� ������ �ִٸ� true ���ٸ� false   <-- ifPresent�� �޸� boolean�� ���ϰ����� �� 

//OptionalInt, OptionalLong, OptionalDouble   <-- �⺻�� ���� ���δ� ����Ŭ������ ����� �� �־�� ����������� ������ 

//�ǽ��غ��Կ�~~

public class Stream5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = null;
//		System.out.println("arr.length="+arr.length);  <-- ����

		int[] arr = new int[0];
		System.out.println("arr.length=" + arr.length);

		// Optional<String> opt = Optional.empty(); // �ٶ������� ����
		Optional<String> opt = Optional.empty();

		String str = "�ε�";
		try {
			str = opt.get();
		} catch (Exception e) {
			str = "���� �߻��̿���";
		}

		System.out.println("str=" + str);

		String str2 = opt.orElse("���̿��� �׷��� ���� ����Ұſ���"); // Optional�� ����� ���� null�̸� ��ȯ
		System.out.println("str2=" + str2);

		String str3 = opt.orElseGet(() -> new String("dsf")); // ���ٽ�
		System.out.println("str3=" + str3);

		String str4 = opt.orElseGet(String::new).concat("dddddd"); // �޼ҵ�����
		System.out.println("str4=" + str4);

		/////////////////////////////////////////////////////////////////////////

		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length);
		System.out.println("optStr=" + optStr.get());
		System.out.println("optInt=" + optInt.get());

		int result1 = Optional.of("234").filter(x -> x.length() > 2).map(Integer::parseInt).get();
		System.out.println("result1=" + result1);

		int result2 = Optional.of("").filter(x -> x.length() > 0).map(Integer::parseInt).orElse(999);

		System.out.println("result2=" + result2);

		Optional.of("456").map(Integer::parseInt).ifPresent(x -> System.out.println("result3=" + x));

		OptionalInt optInt1 = OptionalInt.of(0); // 0�� ����
		OptionalInt optInt2 = OptionalInt.empty(); // �� ��ü�� ����

		System.out.println(optInt1.isPresent());
		System.out.println(optInt2.isPresent());

	}

}
