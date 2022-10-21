package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1.  Student2 클래스 구현하기
    멤버변수 : 이름,국어점수, 영어점수, 수학점수
    멤버메서드 
         String toString() : 각멤버변수값,총점,평균 출력
         int getTotal() : 점수의 합 리턴
         int compareTo() : 이름의 오름차순으로 정렬되도록 구현
2. 구동 클래스 완성하기
    다음 결과가 나오도록 구동 클래스 구현하기    
        
[결과]
기본정렬방식
김삿갓:국어(95),영어(85),수학(75),총점(255),평균(85.00)
이몽룡:국어(80),영어(95),수학(95),총점(270),평균(90.00)
임꺽정:국어(60),영어(75),수학(100),총점(235),평균(78.33)
홍길동:국어(90),영어(80),수학(70),총점(240),평균(80.00)
총점기준 내림차순 정렬
이몽룡:국어(80),영어(95),수학(95),총점(270),평균(90.00)
김삿갓:국어(95),영어(85),수학(75),총점(255),평균(85.00)
홍길동:국어(90),영어(80),수학(70),총점(240),평균(80.00)
임꺽정:국어(60),영어(75),수학(100),총점(235),평균(78.33)
국어 점수내림차순 정렬
김삿갓:국어(95),영어(85),수학(75),총점(255),평균(85.00)
홍길동:국어(90),영어(80),수학(70),총점(240),평균(80.00)
이몽룡:국어(80),영어(95),수학(95),총점(270),평균(90.00)
임꺽정:국어(60),영어(75),수학(100),총점(235),평균(78.33)
영어 점수내림차순 정렬
이몽룡:국어(80),영어(95),수학(95),총점(270),평균(90.00)
김삿갓:국어(95),영어(85),수학(75),총점(255),평균(85.00)
홍길동:국어(90),영어(80),수학(70),총점(240),평균(80.00)
임꺽정:국어(60),영어(75),수학(100),총점(235),평균(78.33)
수학 점수내림차순 정렬
임꺽정:국어(60),영어(75),수학(100),총점(235),평균(78.33)
이몽룡:국어(80),영어(95),수학(95),총점(270),평균(90.00)
김삿갓:국어(95),영어(85),수학(75),총점(255),평균(85.00)
홍길동:국어(90),영어(80),수학(70),총점(240),평균(80.00)
 */
class Student2 implements Comparable<Student2> {
	String name;
	int kor, eng, math;

	public Student2(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getTotal() { //총점
		return kor + eng + math;
	}
	public String toString() { //출력
		return String.format
       ("%s:국어(%d),영어(%d),수학(%d),총점(%d),평균(%.2f)",
    		   name, kor, eng, math, getTotal(),
				getTotal() / 3.0);
	}
	//기본정렬 방식 
	@Override
	public int compareTo(Student2 o) {
		return name.compareTo(o.name);
	}
}

public class Test1 {
	public static void main(String[] args) {
		List<Student2> list = new ArrayList<Student2>();
		list.add(new Student2("홍길동", 90, 80, 70));
		list.add(new Student2("김삿갓", 95, 85, 75));
		list.add(new Student2("이몽룡", 80, 95, 95));
		list.add(new Student2("임꺽정", 60, 75, 100));

		System.out.println("기본정렬방식");
		Collections.sort(list);
		for(Student2 s : list) System.out.println(s);

		System.out.println("총점기준 내림차순 정렬");
		Collections.sort(list,
				   (s1,s2)->s2.getTotal() - s1.getTotal());
		for(Student2 s : list) System.out.println(s);

		System.out.println("국어 점수내림차순 정렬");
		Collections.sort(list,(s1,s2)->s2.kor - s1.kor);
		for(Student2 s : list) System.out.println(s);

		System.out.println("영어 점수내림차순 정렬");
		Collections.sort(list,(s1,s2)->s2.eng - s1.eng);
		for(Student2 s : list) System.out.println(s);

		System.out.println("수학 점수내림차순 정렬");
		Collections.sort(list,(s1,s2)->s2.math - s1.math);
		for(Student2 s : list) System.out.println(s);

	}

}