package lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//java.util.function 패키지를 알아봐요 
// - 자주 사용되는 다양한 함수형 인터페이스를 제공하고 있어요 우리가 가지고 사용하고 있는대 이미 만들어지는걸 공통으로 사용하면 개발자들이 표준을 가지고 남이짠 소스를 이해하기 쉬워요
// 
// 
//
//함수형 인터페이스               메서드                    설명
//java.lang.Runnable      void run()               매개변수도 없고, 반환값도 없음
//Supplier<T>             T get() -> T             매개변수는 없고, 반환값만 있음
//Consumer<T>             T -> void accept(T t)    Supplier와 반대로 매개변수만 있고, 반환값이 없음
//Function<T,R>           T -> R apply(T t) -> R   일반적인 함수, 하나의 매개변수를 받아서 결과를 반환
//Predicate<T>            T -> boolean test(T t) -> boolean   조건식을 표현하는데 사용됨. 매개변수는 하나, 반환 타입은 boolean
//
//
//Predicate<String> isEmptyStr = s -> s.length() == 0;
//String s = "";
//if(isEmptyStr.test(s))  // if(s.length() == 0)

//
//-- 매개변수가 2개인 함수형 인터페이스 
//
//BiConsumer<T, U>          T,U -> void accept(T t, U u)          두개의 매개변수만 있고, 반환값이 없음
//BiPredicate<T, U>         T,U -> boolean test(T t, U u) -> boolean         조건식을 표현하는데 사용됨. 매개변수는 둘, 반환값은 boolean
//BiFunction<T, U>          T,U -> R apply(T t, U u) -> R         두 개의 매개변수를 받아서 하나의 결과를 반화 
//
//만약 3개를 받고 싶다면? 우리가 정의하면되요 
//
//@FunctionalInterface
//interface TriFunction<T, U, V, R> {
//	R apply(T t, U u, V v);   // 매개변수 3개 
//}
//
//-- 매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스 
//UnaryOperator<T>           T -> apply(T t)   -> T            Function의 자손, Function과 달리 매개변수와 결과의 타입이 같다 T를 넣으면 T가 나온다
//BinaryOperator<T>          T,T -> T apply(T t, T t) -> T     BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같다 
//
//예를들어서 아래와 같은대 t를 넣으면 t가 나옴 
//@FunctionalInterface
//public interface UnaryOperator<T> extends Function<T, T> {
//	static <T> UnaryOperator<T> identity() {
//		return t -> t;
//	}
//}

// 예제를 볼게요 











public class Lamda3 {
	public static void main(String[] args) {

		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; // 1 ~ 100 난수
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		Predicate<Integer> p = i -> i % 2 == 0; // 짝수인지 검사
		Function<Integer, Integer> f = i -> i / 10 * 10; // i의 일의 자리를 없앰

		List<Integer> list = new ArrayList<>();

		makeRandomList(s, list); // list를 랜덤값으로 담는다
		System.out.println(list);
		printEvenNum(p, c, list); // 짝수를 출력
		System.out.println();
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);

	}

	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());

		for (T i : list) {
			newList.add(f.apply(i)); // 일의 자리를 없애서 새로운 LIST에 저장
		}

		return newList;
	}

	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			if (p.test(i)) // 짝수인지 검사
				c.accept(i);
		}
		System.out.print("]");
	}

	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get()); // Supplier로 부터 1~100의 난수를 받아서 list에 추가
		}
	}

}
