package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMain03 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream("temp/big_text.txt");
			out = new FileOutputStream("temp/big_copy.txt");

			int data = 0;
			int byteCopied = 0;
			
			byte[] buffer = new byte[1024 * 1024]; // 1MB 공간
			
			// 1KB = 1024 Bytes
			// 1MB = 1024 * 1024 Bytes
			// 1GB = 1024 * 1024 * 1024 Bytes
			long startTime = System.currentTimeMillis();
			
			while(true) {
				// read(byte[]): 
				// 파일에서 읽은 데이터를 매개변수 배열 b에 저장
				// 실제로 읽은 바이트 수를 리턴, 파일 끝은 -1을 리턴
				data = in.read(buffer);
				if(data == -1) {
					break;
				}

				// write(byte[] b):
				// - 매개변수 배열 b의 내용을 한 번에 파일에 씀
				out.write(buffer);

				byteCopied += data;
			}

			System.out.println(byteCopied + "바이트 복사됨");
			
			long endTime = System.currentTimeMillis();
			System.out.println("복사 경과 시간: " + (endTime - startTime));
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
