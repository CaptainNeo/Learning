package lamda;

import java.util.function.Function;
import java.util.function.Supplier;

//
//- 생성자의 메서드 참조
//생성자와 메서드 참조 
//Supplier<Doodoo> d = () -> new Doodoo();
//
//Supplier<Doodoo> d = Doodoo::new;
//
//Function<Integer, Doodoo> d = (i) -> new Doodoo(i);
//
//Function<Integer, Doodoo> d = Doodoo::new;
//
//위와같이 사용하는 이유중 하나로 배열과 메서드 참조를 잘 사용해요 ~~ 
//
//Function<Integer, int[]> f = x -> new int[x];		// 람다식
//
//Function<Integer, int[]> f2 = int[]::new;	// 메서드 참조

public class Lamda6 {
	public static void main(String[] args) {

		// Supplier는 입력 X, 출력 O
//		Supplier<Doodoo2> s = () -> new Doodoo2();

		Supplier<Doodoo2> s = Doodoo2::new;

		Doodoo2 d = s.get();

		System.out.println(d);

		Function<Integer, Doodoo3> f = (i) -> new Doodoo3(i);

		Doodoo3 dd = f.apply(120);

		System.out.println(dd.iv);

		System.out.println(f.apply(222).iv);

		// 배열을 만들어 볼게요

		Function<Integer, int[]> f2 = int[]::new; // 메서드 참조

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