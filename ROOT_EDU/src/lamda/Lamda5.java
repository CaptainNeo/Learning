package lamda;

import java.util.function.Function;

//메서드 참조(method reference)
//
//- 하나의 메서드만 호출하는 람다식은 '메서드 참조'로 간단히 할 수 있다 . 
//
//종류                     람다                                     메서드참조
//
//static메서드참조          (x) -> ClassName.method(x)              ClassName::method
//인스턴스메서드 참조           (obj, x) -> obj.method(x)              ClassName::method
//특정 객체 인스턴스메서드 참조    (x) -> obj.method(x)                   obj::method
//
//
//Integer method (String s) {
//	return Integer.parseInt(s);
//}
//
//위의 내용을 아래처럼 사용 가능
//int result = Integer.parseInt("123");
//
//Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//
//여기서 메서드 참조 식으로 코딩하면 
//
//Function<String, Integer> f = Integer::parseInt;	// 메서드 참조
//

public class Lamda5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f = Integer::parseInt; // 메서드 참조
		System.out.println(f.apply("222") + 78);

	}

}
