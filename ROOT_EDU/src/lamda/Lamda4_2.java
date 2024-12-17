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

		// list�� ��� ��Ҹ� ���
		list.forEach(i -> System.out.print(i + ","));

		// ������ �ؿ� ó�� �����ڳ���~
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}

		System.out.println();

		// list���� 2�Ǵ� 3�� ����� �����Ѵ�.
		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);

		list.replaceAll(i -> i * 10); // list�� �� ��ҿ� 10�� ���ؿ�

		System.out.println(list);

		Map<String, String> map = new HashMap<>();

		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		// map�� ��� ��Ҹ� {k, v}�� �������� ���
		map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();

		// ������ �ؿ� ó�� �������
		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// ** ���ٽ��� ������ ���� �÷��� �����ӿ�ũ �ڵ尡 �����������

	}

}
