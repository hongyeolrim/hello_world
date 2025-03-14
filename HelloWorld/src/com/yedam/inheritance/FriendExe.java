package com.yedam.inheritance;

/*
 * 상속
 * 친구1: 이름, 연락처
 * 친구2: 이름, 연락처, 학교, 학과
 * 친구3: 이름, 연락처, 회사, 부서
 */
public class FriendExe {
	public static void main(String[] args) {

		Friend f1 = new Friend();
		f1.setName("홍열림");
		f1.setTel("010-1111-2222");

		UnivFriend f2 = new UnivFriend();
		f2.setName("김자식");
		f2.setTel("010-2222-3333");
		f2.setUnivName("와플대학");
		f2.setMajor("사과잼와플학과");

		CompanyFriend f3 = new CompanyFriend("김오레오", "010-5555-5555", "과자회사", "마케팅부서");

		Friend[] friends = new Friend[10];
		// 상속 관계라서 타입이 달라도 값 담아놓기 가능
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}

		// 형변환
		int num = 20;
		double num2 = num; // 작은 형태의 데이터를 큰 데이터 형태에 담아줌, 그리고 자동형변환 => promotion
		num = (int) num2; // 큰 형태의 데이터를 작은 형태에 넣으려고하면 강제로 형변환 => casting

		Friend f4 = new CompanyFriend("김무열", "010-0000-0000", "배우회사", "연기부서");
		CompanyFriend cf = (CompanyFriend) f4; // 부모자식간이면 casting 가능
//        cf = (CompanyFriend) new Friend("알렉시스", "010-3333-3333"); 이렇게 하면 오류나옴

		Friend f5 = new Friend("군고구마", "010-8888-8888");
		if (f5 instanceof CompanyFriend) {
			cf = (CompanyFriend) f5;
			System.out.println(cf.getCompany());
		} else {
			System.out.println("casting 할 수 없습니다");
		}
	} // end of main
}
