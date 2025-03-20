package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharacterExe {
	public static void main(String[] args) {
		Scanner scn = null;
		try {
			scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while (true) {
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" ");
				System.out.println("코드: " + msgAry[0] + ", 상품명: " + msgAry[1] + ", 가격: " + msgAry[2]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}
		scn.close();
		System.out.println("end of prog.");
	}

	static void read() {
		try {
			Reader reader = new FileReader(
					"D:\\Dev\\git\\hello_world\\HelloWorld\\src\\com\\yedam\\io\\StreamExe.java");
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void write() {
		try {
			Writer writer = new FileWriter("c:temp/data.txt");
			writer.write('a');
			writer.write('b');
			writer.write('c');

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void write2() {
		Scanner scn = new Scanner(System.in);
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while (true) {
				System.out.print("입력>> ");
				String msg = scn.nextLine();
				if (msg.equals("quit")) {
					break;
				}
				writer.write(msg + "\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
	}
}
