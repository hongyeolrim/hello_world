package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

//int number = 10; // 그냥 숫자

//Integer wrappedNumber = Integer.valueOf(number); // 숫자를 포장한 객체
//double pi = 3.14;
//Double wrappedPi = Double.valueOf(pi); // 실수를 포장한 객체

//자동 포장
//Integer num = 20; // `int`를 자동으로 `Integer` 객체로 변환!
//원래는 Integer.valueOf(20);을 해야 하지만, Java가 자동으로 해줘!

//자동 언박싱
//int result = num + 10; // `Integer` 객체가 자동으로 `int`로 변환됨!
//원래는 num.intValue();를 해야 하지만, Java가 자동으로 해줘!   =====> 수식을 사용하면 자동으로 언박싱(Unboxing)

//포장이 필요한 이유 :
//1. 컬렉션(List, Set, Map)에서 기본 자료형을 저장할 때 필요해!
//Java의 **컬렉션(리스트, 맵 등)**은 기본 자료형을 직접 저장할 수 없고, 객체만 저장할 수 있어!

//2. 객체로 다뤄야 할 때 유용해!

//3. 객체이기 때문에 메서드를 사용할 수 있어!
//Integer num = 100;
//String str = num.toString(); // "100"이라는 문자열로 변환!

//4. null을 저장해야 할 때

public class WrapperExe {
	public static void main(String[] args) {
		int[] intAry = { 10, 20 };
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); // List<Integer>에 기본 자료형(10)을 넣으면 자동으로 박싱이 된다는 걸 알려주려는 것!

		// List는 인터페이스(Interface) - (규칙만 정의, 실제 동작 X)
		// ArrayList는 List의 자식 클래스(Class) - (구현 클래스, 실제 동작 O)

// < >를 쓰는 이유 :
// <>는 **제네릭(Generics)**을 나타내는 기호야
// 자료형(타입)을 고정하는 역할을 해!
// 위 코드에서는 List가 Integer만 저장하도록 제한하는 거야
// Integer만 저장하도록 제한하니까 타입 안정성이 보장됨!

		int num1 = 10;
		Integer num2 = new Integer(20);
		System.out.println(num1 == num2.intValue()); // 타입이 다르면 비교할 수 없음
		// Integer 객체는 직접 비교(==)하면 안 되고, 값 비교를 할 때 intValue()를 써야 한다는 걸 보여주려는 것!
	}
}
