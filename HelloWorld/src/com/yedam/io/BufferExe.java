package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferExe {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("c:/Users/admin/Downloads/jdk-21_windows-x64_bin.exe");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream("c:/temp/jdk-21_windows-x64_bin_copy.exe");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			while (true) {
				int data = bis.read();
				if (data == -1) {
					break;
				}
				bos.write(data);
			}
		} catch (IOException e) { // 파일 관련 모든 예외 처리
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
