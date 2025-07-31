package edu.java.file06;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.file04.MemberVO;

// 프로그램 ==> ObjectOutputStream ==> BufferedOutputStream
// ==> FileOutputStream ==> 파일

public class FileMain06 {

	// * 파일에 데이터를 저장하는(작성하는) 과정
	// 1. 데이터를 접근할 파일을 생성
	// 2. 파일에 접근할 통로를 생성
	// 3. 파일에 저장할 데이터를 구성
	// 4. 구성된 데이터를 파일에 저장
	// 5. 사용한 통로를 닫음
	
	public static void main(String[] args) {
		System.out.println("ArrayList<MemberVO> 객체를 파일에 저장하는 코드");
		
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("temp/list.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			List<MemberVO> list = new ArrayList<MemberVO>();
			long startTime = System.currentTimeMillis();
			for(int i = 0; i < 1000000; i++) {
				String id = "member" + i;
				String pw = "pw" + i;
				MemberVO vo = new MemberVO(i, id, pw);
				list.add(vo);
			}
			oout.writeObject(list);
			long endTime = System.currentTimeMillis();
			System.out.println("경과시간: " + (endTime - startTime));
			System.out.println("데이터 저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
