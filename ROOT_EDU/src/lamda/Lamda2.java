package lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//함수형 인터페이스 
// - 함수형 인터페이스 > 단 하나의 추상 메서드만 선언된 인터페이스 
//@FunctionalInterface <-- 생략가능 디폴트 컴파일러가 올바르게 작성하는지 확인해줘요 
// interface Iamfunction {
//	 public abstrac int max(int a, int b);
// }
//
//위를 아래처럼 구현하면 
//Iamfunction f = new Iamfunction() {
//	public int max(int a, int b) {
//		return a > b ? a : b;
//	}
//}
//
//int value = f.max(3, 5);  // Iamfunction에 max()가 있어서 사용가능 
//
//위를 베이스로 삼아 
//
// - 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음 
// (단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야 함)
// 
//
// Iamfunction f = (a, b) -> a > b ? a: b;
// 
// int value = f.max(3, 5);	// 실제로는 람다식(익명 함수) 호출됨

// 실습을 해봐요~~



















public class Lamda2 {

	public static void main(String[] args) {

//	Object obj = (a, b) -> a > b ? a: b; 	// 람다식, 익명객체

		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};

//	int v = obj.max(3,5);

		IamFunction iamF = new IamFunction() {

			@Override
			public int max(int a, int b) { // 오버라이딩 -- 접근제어자 default 가 아닌 public
				// TODO Auto-generated method stub
				return a > b ? a : b;
			}

		};

		int v2 = iamF.max(9, 2); // 함수형 인터페이스
		System.out.println("value=" + v2);

		// 이제 람다식을 써볼게요
		// 람다식(익명객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 해요
		IamFunction lamdaRef = (a, b) -> a > b ? a : b;
		int v3 = lamdaRef.max(3, 5);
		System.out.println(v3);

		// 예를 들어서 익명 객체를 람다식으로 대체하는 예제를 만들어 볼게요
		// Comparator<String>

		List<String> list = Arrays.asList("가두두", "나두두", "바두두", "하두두", "김두두");

		Collections.sort(list, (s1, s2) -> s2.compareTo(s1)); // 가나다 역순

		System.out.println(list);

		// 사실 아래와 같이 썻어야 했어요 람다식을 사용해서 복잡한 구문을 간다하게 쓰게되고 빨라졌어요
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.compareTo(s1);
			}

		});

		// 위처럼 가능한건 매개변수로 람다식을 받겠다는것은 함수형 인터페이스 타입의 매개변수로 예를 들어서
		Doodoo d = () -> System.out.println("내가 람다식 반환이야");

		aMethod(d); // 함수형 인터페이스 타입의 매개변수 사용가능

		Doodoo dd = bMethod(); // 함수형 인터페이스 타입의 반환타입도 가능해요

		System.out.println(dd); // 람다식

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

	// 조금만 더 이해해볼가용

}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 해요 ~ 규칙이에요 외우지 말고 그냥 그려러니 해요 ㅋ
interface IamFunction {
//	public abstract int max(int a, int b);  // 예외없이 public abstrac 이므로 생략가능
	int max(int a, int b);
//	public abstract int max2(int a, int b)
}

@FunctionalInterface
interface Doodoo {
	void doodooMethod();

}