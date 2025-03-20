package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//Java에서는 데이터를 주고받을 때 스트림(Stream) 개념을 사용함
//스트림은 데이터를 바이트 단위 또는 문자 단위로 읽고 쓰는 흐름을 의미해

//1. OutputStream & InputStream (바이트 기반 스트림)
//사용 대상===>이미지,오디오,비디오,이진 파일 등

//(1) OutputStream (출력 스트림)
//데이터를 외부(파일, 네트워크 등)로 보낼 때 사용
//write(int b) :        1바이트 데이터를 출력
//write(byte[] b) : 	바이트 배열을 출력
//flush() :	            버퍼를 비워 즉시 출력
//close() :	            스트림을 닫음

//(2) InputStream (입력 스트림)
//외부(파일, 네트워크 등)에서 데이터를 읽어올 때 사용
//read() : 	        1바이트 데이터를 읽음
//read(byte[] b) :	바이트 배열로 데이터를 읽음
//available() :	    읽을 수 있는 데이터의 크기를 반환
//close() :      	스트림을 닫음

//2. Writer & Reader (문자 기반 스트림)
//Writer 와 Reader는 문자(16bit 유니코드) 단위로 데이터를 읽고 쓰는 스트림! 텍스트 데이터를 처리할 때 사용!
//사용 대상 ===> 텍스트 파일, 문자 데이터

//(1) Writer (문자 출력 스트림)
//문자 데이터를 외부(파일 등)로 출력할 때 사용
//write(int c) :        한 문자 출력
//write(char[] cbuf) :  문자 배열 출력
//write(String str) :   문자열 출력
//flush()	:             버퍼 비우기 
//close()	:             스트림 닫기

//(2) Reader (문자 입력 스트림)
//문자 데이터를 읽을 때 사용
//read() :                한 문자 읽기
//read(char[] cbuf) : 	문자 배열로 읽기
//close()	:               스트림 닫기

//3. BufferedReader & BufferedWriter (버퍼링으로 성능 향상)
//BufferedReader 와 BufferedWriter 는 데이터를 한 문자(char)씩 읽고 쓰는 것이 아니라, 한 번에 여러 문자(버퍼 단위)로 처리해서 성능을 향상시킴

//(1) BufferedReader
//read()	                                 한 문자 읽기
//read(char[] cbuf, int off, int len)	     여러 문자 읽기
//readLine()	                             한 줄 읽기 (줄바꿈 기준)
//close()	                                 스트림 닫기

//(2) BufferedWriter
//write(String str)	                    문자열 출력
//write(char[] cbuf, int off, int len)	여러 문자 출력
//newLine()	                            개행 문자 출력
//flush()	                                버퍼 강제 출력
//close()	                                스트림 닫기

//PrintWriter (편리한 출력, 자동 개행) 그냥 평소에 이거 쓰셈 / print(), println(), printf() 사용 가능
//BufferedWriter 는 대용량 처리할 때 쓰기

//✔ InputStream is → 물(데이터)을 가져오기 위해 물이 담긴 통(파일1)에 수도꼭지 연결해서 틈
//✔ OutputStream os → 물(데이터)을 최종적으로 옮겨 받을 '다른 통'(파일2)
//✔ byte[] buf = new byte[100] → 물을 옮기는 '바가지', 물을 작은 컵 같은데 옮기면 오래 걸리니까 큰 바가지에 담아서 옮기는 거임
//✔ is.read(buf) → 물이 담긴 통(파일1)에 연결된 수도꼭지에서 흘러나오는 물(데이터)을 바가지(buf)에 담는다
//✔ os.write(buf, 0, data) → 바가지(buf)에서 OutputStream(통)에 물을 옮겨 담는다
//✔is.close(); // 수도꼭지 잠그기 
//  os.flush(); // 바가지(buf)에서 물을 통(os)에 옮길 때, 혹시 남은 물이 있으면 마지막까지 완전히 박박 털어서 넣음
//  os.close(); // 데이터 받을 통 뚜껑 닫기 
//전부 다 닫아야 되는 이유 : 수도꼭지(is)를 안 잠그면 계속 물이 새고,
//파일 통(os)을 뚜껑을 안 닫으면 데이터가 제대로 저장되지 않을 수도 있음

public class StreamExe {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("c:/temp/img.jpg");
			OutputStream os = new FileOutputStream("c:/temp/img3.jpg");

			byte[] buf = new byte[100];

			while (true) {
				int data = is.read(buf);
				if (data == -1) {
					break;
				}
				os.write(buf, 0, data);
			}
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prg.");
	}

	static void read() {
		try {
			InputStream is = new FileInputStream("c:/temp/data.bin");
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void write() {
		try {
			OutputStream os = new FileOutputStream("c:/temp/data.bin");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
