package edu.java.file05;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import edu.java.file04.MemberVO;

// 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일(HDD)
public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInput oin = null;

		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);

			// 퀴즈) oin 객체에 저장되어 있는 MemberVO 데이터를 모두 출력하시오
			while (true) {
				try {
					MemberVO vo = (MemberVO)oin.readObject();
					System.out.println(vo);
				} catch (EOFException e) {
					break;
				}
			}

			System.out.println("데이터 출력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	} // end main()

} // end FileMain05