package lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//java.util.function ��Ű���� �˾ƺ��� 
// - ���� ���Ǵ� �پ��� �Լ��� �������̽��� �����ϰ� �־�� �츮�� ������ ����ϰ� �ִ´� �̹� ��������°� �������� ����ϸ� �����ڵ��� ǥ���� ������ ����§ �ҽ��� �����ϱ� ������
// 
// 
//
//�Լ��� �������̽�               �޼���                    ����
//java.lang.Runnable      void run()               �Ű������� ����, ��ȯ���� ����
//Supplier<T>             T get() -> T             �Ű������� ����, ��ȯ���� ����
//Consumer<T>             T -> void accept(T t)    Supplier�� �ݴ�� �Ű������� �ְ�, ��ȯ���� ����
//Function<T,R>           T -> R apply(T t) -> R   �Ϲ����� �Լ�, �ϳ��� �Ű������� �޾Ƽ� ����� ��ȯ
//Predicate<T>            T -> boolean test(T t) -> boolean   ���ǽ��� ǥ���ϴµ� ����. �Ű������� �ϳ�, ��ȯ Ÿ���� boolean
//
//
//Predicate<String> isEmptyStr = s -> s.length() == 0;
//String s = "";
//if(isEmptyStr.test(s))  // if(s.length() == 0)

//
//-- �Ű������� 2���� �Լ��� �������̽� 
//
//BiConsumer<T, U>          T,U -> void accept(T t, U u)          �ΰ��� �Ű������� �ְ�, ��ȯ���� ����
//BiPredicate<T, U>         T,U -> boolean test(T t, U u) -> boolean         ���ǽ��� ǥ���ϴµ� ����. �Ű������� ��, ��ȯ���� boolean
//BiFunction<T, U>          T,U -> R apply(T t, U u) -> R         �� ���� �Ű������� �޾Ƽ� �ϳ��� ����� ��ȭ 
//
//���� 3���� �ް� �ʹٸ�? �츮�� �����ϸ�ǿ� 
//
//@FunctionalInterface
//interface TriFunction<T, U, V, R> {
//	R apply(T t, U u, V v);   // �Ű����� 3�� 
//}
//
//-- �Ű������� Ÿ�԰� ��ȯŸ���� ��ġ�ϴ� �Լ��� �������̽� 
//UnaryOperator<T>           T -> apply(T t)   -> T            Function�� �ڼ�, Function�� �޸� �Ű������� ����� Ÿ���� ���� T�� ������ T�� ���´�
//BinaryOperator<T>          T,T -> T apply(T t, T t) -> T     BiFunction�� �ڼ�, BiFunction�� �޸� �Ű������� ����� Ÿ���� ���� 
//
//������ �Ʒ��� ������ t�� ������ t�� ���� 
//@FunctionalInterface
//public interface UnaryOperator<T> extends Function<T, T> {
//	static <T> UnaryOperator<T> identity() {
//		return t -> t;
//	}
//}

// ������ ���Կ� 











public class Lamda3 {
	public static void main(String[] args) {

		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; // 1 ~ 100 ����
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		Predicate<Integer> p = i -> i % 2 == 0; // ¦������ �˻�
		Function<Integer, Integer> f = i -> i / 10 * 10; // i�� ���� �ڸ��� ����

		List<Integer> list = new ArrayList<>();

		makeRandomList(s, list); // list�� ���������� ��´�
		System.out.println(list);
		printEvenNum(p, c, list); // ¦���� ���
		System.out.println();
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);

	}

	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());

		for (T i : list) {
			newList.add(f.apply(i)); // ���� �ڸ��� ���ּ� ���ο� LIST�� ����
		}

		return newList;
	}

	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			if (p.test(i)) // ¦������ �˻�
				c.accept(i);
		}
		System.out.print("]");
	}

	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get()); // Supplier�� ���� 1~100�� ������ �޾Ƽ� list�� �߰�
		}
	}

}
