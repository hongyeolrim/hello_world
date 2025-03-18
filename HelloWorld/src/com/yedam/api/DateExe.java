package com.yedam.api;

//*****결론*****
//✔ SimpleDateFormat과 Date는 문자열이 아님.
//✔ SimpleDateFormat은 날짜 형식을 지정하는 객체.
//✔ Date는 시간을 저장하는 숫자 데이터 기반 객체.
//✔ 날짜를 비교하거나 연산할 때는 문자열 변환이 필요 없음.
//✔ 사람이 읽거나 출력할 때는 문자열로 변환해야 함 (format()).

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Java에서 날짜와 시간을 다루는 방법을 보여주는 예제
//현재 날짜와 시간 가져오기 → new Date()
//날짜를 특정 형식(문자열)으로 변환 → SimpleDateFormat.format(Date)
//문자열을 날짜 객체로 변환(파싱) → SimpleDateFormat.parse(String)
//예외 처리의 필요성 (parse()는 잘못된 입력을 받을 수 있음)

//전체 코드의 흐름
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//→ "yyyy-MM-dd HH:mm:ss" 형식으로 날짜를 표현할 객체를 만들었어.

//Date today = new Date();
//→ 현재 날짜와 시간을 저장한 Date 객체(today)를 만들었어.

//String formatStr = sdf.format(today);
//→ sdf.format(today)가 today(날짜)를 "yyyy-MM-dd HH:mm:ss" 형식의 문자열(String) 로 변환해.
//→ 변환된 결과를 formatStr에 저장해.

//System.out.println(formatStr);
//→ 변환된 문자열을 출력.

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.toString());
//Date 클래스는 현재 날짜와 시간을 나타내는 객체를 생성하는 데 사용됨
//new Date()는 현재 시스템의 날짜와 시간을 가져옴
//today.toString()은 Date 객체를 기본 문자열 형식으로 변환해서 출력

		// "yyyy-MM-dd HH:mm:ss" 이 부분은 문자열이지만,
		// sdf 자체는 문자열이 아니라 날짜 형식을 지정하는 객체야
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatStr = sdf.format(today); // today를 문자열로 변환하여 formatStr에 저장
		System.out.println(formatStr);

//		SimpleDateFormat 클래스를 사용해 날짜를 특정 형식으로 변환 (포맷팅)
//		상세 설명 :
//		sdf는 SimpleDateFormat 타입의 객체
//		SimpleDateFormat은 날짜(Date) 객체를 우리가 원하는 형식의 날짜로 변환해 주는 역할

//		sdf.format(today)는 today를 문자열로 변환
//      상세 설명 :
//		sdf.format(today)는 오늘 날짜(today)를 특정한 형식의 문자열로 변환하는 메서드 호출

// format()을 사용하면 사람이 읽을 수 있는 날짜 형식으로 변환할 수 있음.
// 💡 즉, format()은 "날짜(Date) → 문자열(String)" 변환기!

		try {
			Date tday = sdf.parse("2000-01-01 10:00:00");
			System.out.println(tday); // (문자열 "2000-01-01 10:00:00"을 Date로 변환해서 출력)
		} catch (ParseException e) {
			e.printStackTrace();
		}
//      sdf.parse("2000-01-01 10:00:00") → 문자열을 Date 객체로 변환.
//		tday 변수에 변환된 날짜 저장.
//		System.out.println(tday);로 변환된 날짜 출력.

//		try ~ catch를 사용한 이유:
//		parse() 메서드는 예외(ParseException)가 발생할 가능성이 있음.
//		예를 들어 "2000-99-99 99:99:99"처럼 존재하지 않는 날짜를 넣으면 예외 발생.

	}
}

//<파싱(Parsing)이란?>
//파싱(Parsing)은 어떤 데이터를 분석하고 원하는 형태로 변환하는 과정이야

//1. 텍스트를 숫자로 변환하는 경우
//String numberStr = "123";
//int number = Integer.parseInt(numberStr); // 문자열 "123"을 정수 123으로 변환

//2. 문자열을 객체로 변환하는 경우
//{"name": "Alice", "age": 25}

//3. HTML이나 XML 문서를 분석하는 경우
//웹 크롤링할 때 HTML 데이터를 가져와서 필요한 부분을 추출하는 것도 파싱이야

//<캐스팅(Casting)이란?>
//기본 타입 간의 변환 (예: int → double)
//객체 타입 변환 (업캐스팅, 다운캐스팅) (예: 부모-자식 클래스 간 변환 ====> Parent → Child)

//<언박싱(Unboxing)이란??
//Wrapper 클래스(객체) → 기본 타입으로 변환하는 것
//예를 들어, Integer 객체를 int 타입으로 변환하는 것
//언박싱은 "형 변환"이라기보다는 박스(객체)에서 값을 꺼내는 과정이야