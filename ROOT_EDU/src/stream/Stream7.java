package stream;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//collect()와 Collectors 
//
//매개변수로 하는 스트림의 최종연산 
//
//Collect는 수집(collect)에 필요한 메서드를 정의해 놓은 인터페이스
//
//public interface Collector<T, A, R>   // T(요소)를 A에 누적한 다음, 결과를 R로 변환해서 반환 
//
//Collector클래스는 Collector인터페이스를 구현해놓았어요 
//
//변환 - mapping(), toList(), toSet(), toMap()...
//통계 - averagingInt(), maxBy() 
//문자열결합 - joining() 
//리듀싱 - reducing()
//그룹화와 분할 - grooupingBy(), partitioningBy(), collectingAndThen()
//
//
//collect() 최종연산
//Collector 인터페이스
//Collectors: 클래스 Collector를 구현 이것만 잘쓰면 되요 
//
//어떤 작업을 하는지 알아볼게요 
//
//스트림을 컬렉션으로 변환해요 
//toList()
//toSet()
//toMap()
//toCollection()
//
//잠간 아래 어떻게 쓰는건지 어떻게 메소드를 호출하는지 맛보기 보시고 실습해 볼게요 
//
//List<String> names = stuStream.map(Student::getName)
//                              .collect(Collectors.toList()); // Stream<String> -> List<String>
//
//ArrayList<String> list = names.stream()
//                              .collect(Collectors.toCollection(ArrayList::new));  // Stream<String> -> ArrayList<String>
//
//
//Map<String, Person> map = personStream.collect(Collectors.toMap(p->p.getRegId(),p -> p));  // Stream<Person> -> Map<String, Person>
//
//
//실습해 보아요~

public class Stream7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] stuArr = { new Student("김길동", true, 1, 1, 150), new Student("안성기", true, 1, 1, 200),
				new Student("왕종근", true, 1, 1, 400), new Student("이원종", true, 1, 2, 222),
				new Student("전혜진", false, 1, 2, 345), new Student("성민", true, 1, 2, 300),
				new Student("함소영", false, 1, 3, 300), new Student("최민식", true, 1, 3, 555),
				new Student("개그맨", true, 1, 3, 567), new Student("박지윤", false, 2, 1, 345),
				new Student("김옥빈", false, 2, 1, 123), new Student("민희", false, 2, 1, 99),
				new Student("설현", false, 2, 2, 8), new Student("김동혁", true, 2, 2, 0), new Student("허각", true, 2, 2, 7),
				new Student("윤소이", false, 3, 1, 12), new Student("신다은", false, 3, 1, 55),
				new Student("정다혜", false, 3, 1, 888), new Student("금보라", false, 3, 2, 777),
				new Student("서효림", false, 3, 2, 123), };

		System.out.println("성별로 그룹을 지어볼게요");
		Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale));

		List<Student> maleStudent = stuBySex.get(true);
		List<Student> femaleStudent = stuBySex.get(false);

		System.out.println("남자그룹으로 리스트 출력 시작");
		for (Student s : maleStudent)
			System.out.println(s);
		System.out.println("남자그룹으로 리스트 출력 종료");
		System.out.println();
		System.out.println("여자그룹으로 리스트 출력 시작");
		for (Student s : femaleStudent)
			System.out.println(s);
		System.out.println("여자그룹으로 리스트 출력 종료");

		System.out.println("=============반별로 그룹화=============");
		Map<Integer, List<Student>> stuByBan = Stream.of(stuArr).collect(Collectors.groupingBy(Student::getBan));

		for (List<Student> s : stuByBan.values()) {
			for (Student sObj : s) {
				System.out.println(sObj);
			}
		}

		System.out.println("=================성적별로 그룹화===================");
		Map<Student.LEVEL, List<Student>> stuByLevel = Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
			if (s.getScore() > 500)
				return Student.LEVEL.HIGH;
			else if (s.getScore() > 300)
				return Student.LEVEL.MID;
			else
				return Student.LEVEL.LOW;
		}));

		TreeSet<Student.LEVEL> keySet = new TreeSet<>(stuByLevel.keySet());

		for (Student.LEVEL key : keySet) {
			System.out.println("[[" + key + "]]");

			for (Student s : stuByLevel.get(key)) {
				System.out.println(s);
			}
			System.out.println();

		}

		System.out.println("================ 반별 그룹화 ====================");
		Stream<Student> stuStream = Stream.of(stuArr);

		Map<Integer, List<Student>> stuByHakAndBan = stuStream.collect(Collectors.groupingBy(Student::getHak));

		for (int ban : stuByHakAndBan.keySet()) {
			System.out.println(ban + "반 학생들 모여라");
			for (Student s : stuByHakAndBan.get(ban)) {
				System.out.println(s);
			}
			System.out.println();
		}

	}

}

class Student {
	String name;
	boolean isMale; // 성별
	int hak; // 학년
	int ban; // 반
	int score; // 점수

	Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
	}

	enum LEVEL {
		HIGH, MID, LOW
	} // 성적을 상 , 중, 하 세 단계로 분류

}
