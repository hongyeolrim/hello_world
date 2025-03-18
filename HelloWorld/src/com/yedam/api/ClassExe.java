package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.yedam.bookApp.Book;

//📌 1. Class 클래스란?

//✔️ "클래스 정보를 저장하는 클래스"
//우리가 만든 Car 같은 클래스는 자동차를 만들기 위한 설계도야.
//그런데 그 설계도 자체를 분석하거나 조작하고 싶을 때가 있어.
//그럴 때 Class 클래스를 사용해!
//✔️ 쉽게 말하면, "클래스에 대한 정보를 저장하고 설명해 주는 역할" 을 해!

//Class 클래스를 어떻게 사용해?
//클래스 정보를 가져오려면 getClass() 또는 Class.forName() 을 써!

//Car myCar = new Car();               // 자동차 객체 생성
//Class<?> carClass = myCar.getClass(); // 클래스 정보 가져오기
//System.out.println("클래스 이름: " + carClass.getName());
//System.out.println("간단한 이름: " + carClass.getSimpleName());

//Class 클래스의 주요 메서드
//Class 클래스에는 클래스에 대한 정보를 알 수 있는 다양한 메서드가 있어! ====> 객체를 모르고도 클래스 정보를 가져올 수 있어!

//<메서드>	                     <설명>
//getName()	      클래스의 전체 이름(패키지 포함) 가져오기
//getSimpleName()	  클래스의 간단한 이름(패키지 제외) 가져오기
//getSuperclass()	  부모 클래스 정보 가져오기
//getMethods()	  클래스의 모든 메서드 정보 가져오기
//getFields()	      클래스의 모든 필드(변수) 정보 가져오기
//getConstructors() 클래스의 모든 생성자 정보 가져오기

//Class 클래스는 언제 사용해?
//✔️ 1) 리플렉션(Reflection) 기능 사용
//→ 클래스 정보, 메서드 실행, 객체 생성 등을 동적으로 처리할 때!
//✔️ 2) 프레임워크 개발
//→ Spring, Hibernate 같은 프레임워크는 내부적으로 Class 클래스를 많이 사용해!
//✔️ 3) JDBC (데이터베이스 연결)
//→ Class.forName("com.mysql.jdbc.Driver") 처럼 드라이버를 동적으로 로드할 때!

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.yedam.bookApp.Book"); // ① 클래스 정보를 가져옴

			Method[] methods = cls.getDeclaredMethods(); // ② 클래스 안에 있는 모든 메서드를 가져옴
			System.out.println("📌 [메서드 목록]");
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i].getName()); // ③ 메서드 이름 출력
			}

			Field[] fary = cls.getDeclaredFields(); // ④ 클래스 안에 있는 생성자를 가져옴
			System.out.println("📌 [필드 목록]");
			for (int i = 0; i < fary.length; i++) {
				System.out.println(fary[i].getName());
			}
			Constructor<?>[] cons = cls.getConstructors();
			System.out.println("\n📌 [생성자 목록]");
			for (Constructor<?> constructor : cons) {
				System.out.println(constructor.getName()); // 생성자 이름 출력
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ⑥ 예외 처리: 클래스를 못 찾으면 오류 출력
		}
//		Class.forName()을 이용한 클래스 동적 로딩
//		Class.forName("패키지명.클래스명")을 사용하면 클래스 이름만 알고 있어도 정보를 가져올 수 있어!		
//      ClassnotFoundException

		Class<?> bookClass = Book.class;

		// Class<?>는 왜 ?를 쓰는 거야?
//		?는 "아직 정해지지 않은 타입" 을 의미해!
//	    즉, Class<?>는 "아무 클래스나 올 수 있다!" 라는 뜻이야.
//		Class<?> carClass = Car.class;  // Car 클래스 정보 저장
//		Class<?> stringClass = String.class;  // String 클래스 정보 저장

		System.out.println("클래스 이름: " + bookClass.getName());

		// 필드(변수) 정보 가져오기
		System.out.println("\n[필드 목록]");
		for (Field field : bookClass.getDeclaredFields()) {
			System.out.println(field.getName());
		}

		// 메서드 정보 가져오기
		System.out.println("\n[메서드 목록]");
		for (Method method : bookClass.getDeclaredMethods()) {
			System.out.println(method.getName());
		}

		// 생성자 정보 가져오기
		System.out.println("\n[생성자 목록]");
		for (Constructor<?> constructor : bookClass.getConstructors()) {
			System.out.println(constructor.getName());
		}

	}
}

//Class<?> vs Class<T> 차이점
//Class<?>	어떤 클래스든 저장 가능 (제한 없음)
//Class<Car>	오직 Car 클래스만 저장 가능
//Class<T>	특정 클래스만 저장 가능 (T 자리에 지정한 클래스만 가능)

//리플렉션(Reflection)이 뭐야?
//✅ "클래스를 직접 건드리지 않고도 클래스 정보를 가져오고, 실행할 수 있는 기능"
//✅ "내가 직접 코딩하지 않아도 프로그램이 알아서 클래스, 메서드를 찾아서 실행할 수 있는 기능"
//
//리플렉션을 쉽게 설명해볼게!
//👉 "네가 모르는 요리법을 레시피를 보고 따라하는 것" 🍳
//
//📌 비유로 이해해볼까?
//
//리플렉션 없음
//→ 직접 요리법을 알아야 요리를 만들 수 있음. (내가 직접 클래스와 메서드를 써야 함)
//리플렉션 있음
//→ 인터넷에서 요리법을 찾아서 따라 만들 수 있음. (프로그램이 클래스 이름만 알면 자동으로 실행 가능)
//✔ 즉, 리플렉션을 쓰면 직접 new를 쓰지 않아도 클래스와 메서드를 찾아서 실행할 수 있어!
