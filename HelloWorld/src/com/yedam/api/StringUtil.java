package com.yedam.api;

public class StringUtil {
	// 1.성별
	// ssn(주민등록번호) 형식:
	// "9503061234567"
	// "990603 2345678"
	// "030502-3456789"
	// 문자열에 숫자만 남겨서 인덱스 6

	// "남"또는 "여"반환
	static String getGender(String ssn) {
		String gen1 = "남";
		String gen2 = "여";

		String newSsn = ""; // 숫자만 저장할 새로운 문자열
		for (int i = 0; i < ssn.length(); i++) {
			char ch = ssn.charAt(i);
			if (ch >= '0' && ch <= '9') { // 숫자인 경우만 추가
				newSsn += ch;
			}
		}

		char genderCode = newSsn.charAt(6);

		switch (genderCode) {
		case '1':
		case '3':
			return gen1;
		case '2':
		case '4':
			return gen2;
		default:
			return "알 수 없음";
		}
	}

	// 2.파일명
	static String getFileName(String file) {
		int dotIndex = file.indexOf("."); // '.'의 위치 찾기
		int slashIndex = file.lastIndexOf("/");
		String fileName = file.substring(slashIndex + 1, dotIndex); // slashIndex + 1 부터 시작해서 .의 앞부분까지만 잘라내기
		return fileName;

	}

	// 3.파일확장자
	static String getExtName(String file) {
		int dotIndex = file.indexOf("."); // '.'의 위치 찾기
		String extName = file.substring(dotIndex + 1); // dotIndex + 1 부터 시작해서 끝까지 자름
		return extName;
	}
}
