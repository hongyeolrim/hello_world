package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
//		Animal animal = new Animal(); //추상 클래스는 인스턴스 못 만들어서 오류남

		Animal animal = new Bird();
		animal.sound();
		animal.eat();
	}
}
