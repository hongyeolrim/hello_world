package com.yedam.bookApp;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int orderNo;

//생성자 정의, 보통은 필드 다음에 옴
	public Book() {

	} // 기본 생성자

	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	} // 내가 만든 생성자, 받을 값들의 종류를 지정해줬어
		// 생성자의 이름은 반드시 클래스 이름과 똑같이, 그래야 어떤 클래스에 속하는지 아니까
		// 생성자는 타입 지정을 안 해, 받을 매개값들의 타입만 지정해

	public Book(String title, String author, String publisher, int price, int orderNo) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.orderNo = orderNo;
	}

//값을 받아서 넣을 메소드
//void는 값을 받는 거고 리턴은 안 하기 때문에 씀
//매개변수를 꼭 넣어야함, 매개값을 받아와야 하니까
	public void setTitle(String title) {
		this.title = title; // title은 내가 받아온 매개값, this.title은 Book클래스의 필드값
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//이건 필드값에 접근하는 거야
//예를 들어 여기의 title은 필드값에 있는 title임
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

//입력된 값을 전부 한 번에 보여주는 메소드
//메시지를 반환하고 메소드 종료해야 하니까 return 넣음
//반환한다는 거는 출력이 된다는 거임
//질문 : 18000이라는 int가 포함되어 있는데, 그래도 String인가?
	public String showBookInfo() {
		String msg = "제목은 " + title + " / 저자는 " + author + "\n출판사는 " + publisher + " / 가격은 " + price + "원";
		return msg;
	}
	public String showListWithNo() {
		String list = orderNo + "제목: " + title + " / 저자: " + author + "\n출판사: " + publisher + " / 가격: " + price + "원";
		return list;
	}
	public String showList() {
		String list = "제목: " + title + " / 저자: " + author + "\n출판사: " + publisher + " / 가격: " + price + "원";
		return list;
	}
}