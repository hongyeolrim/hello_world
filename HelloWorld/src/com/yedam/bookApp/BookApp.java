package com.yedam.bookApp;

public class BookApp {
	public static void main(String[] args) {
		BookMain mainApp1 = BookMain.getInstance();
//		mainApp.main(args);
		BookMain mainApp2 = BookMain.getInstance();
		
		mainApp1.add();
		mainApp1.list();
		
		mainApp2.list();
	}
}
