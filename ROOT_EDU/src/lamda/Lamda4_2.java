package lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Lamda4_2 {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);

		// list의 모든 요소를 출력
		list.forEach(i -> System.out.print(i + ","));

		// 월래는 밑에 처럼 썻었자나용~
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}

		System.out.println();

		// list에서 2또는 3의 배수를 제거한다.
		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);

		list.replaceAll(i -> i * 10); // list의 각 요소에 10을 곱해요

		System.out.println(list);

		Map<String, String> map = new HashMap<>();

		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		// map의 모든 요소를 {k, v}의 형식으로 출력
		map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();

		// 월래는 밑에 처럼 썻었어용
		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// ** 람다식이 나오고 나서 컬렉션 프레임워크 코드가 간결해졌어요

	}

}
