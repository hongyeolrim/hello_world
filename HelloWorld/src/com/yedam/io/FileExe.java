package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	public static void main(String[] args) {
		File file = new File("C:/temp/new.txt");
		File file1 = new File("C:/temp/images/img1/new");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			}
			if (!file1.exists()) {
				file1.mkdirs();
				System.out.println("폴더 생성 완료");
			}
			try (FileWriter fw = new FileWriter(file)) {
				fw.write("살려줘...");
				fw.write("제발...");
				if (file.exists()) {
					file.delete();
					System.out.println("Deleted");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
