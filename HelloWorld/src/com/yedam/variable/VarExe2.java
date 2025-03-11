package com.yedam.variable;

class Student {
	String name;
	int score;
	double height;
}
public class VarExe2 {
	public static void main(String[] args) {
		String name = "홍열림";
		int score = 100; //변수에 데이터를 동시에 2개 넣는 건 안 되는데(덮어씌우면 하나는 사라지니까)
		                 //복합적인 데이터 구조는 클래스라는 데이터 유형에 담을 수 있어
		
		Student s1 = new Student(); //인스턴스 생성
		                            //클래스명 + 변수명 + = + new 클래스명();
		s1.name = "알렉시스";
		s1.score = 90;   
		s1.height = 176.4;
		//이렇게 값을 여러 개 넣을 수 있어
		
		Student s2 = new Student();
		s2.name = "마크";
		s2.score = 92;   
		s2.height = 177;
		
		//이 밑은 배열이야
		int[] scores = {89, 77, 60, score}; //정수를 담을 수 있는 배열
		                                    //score는 내가 이미 만들어놓은 변수야
        int sum = 0;
        for(int i = 0; i < scores.length; i++) {
        	sum = sum + scores[i];
        }
        System.out.println("합: " + sum);
        
		String[] names = {"해린", "하니", "민지", name};
		 for(int i = 0; i < names.length; i++) {
			 System.out.println("이름은=> " + names[i]);
	        }
		 
		Student[] students = {s1, s2}; //클래스 배열이야
		for(int i = 0; i < students.length; i++) {
			System.out.println("이름: " + students[i].name
					           + ", 점수: " + students[i].score
					           + ", 키: " + students[i].height);
		}
		
	} //end of main

}
