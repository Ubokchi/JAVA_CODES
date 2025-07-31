package edu.java.contact04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO{

	// 싱글톤 디자인 패턴 적용
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {}

	// 3. public static 메소드
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	} 

	private final int MAX = 100; 
	private ArrayList<ContactVO> list = new ArrayList<ContactVO>(); 

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";
	private static final String FILE_PATH = DATA_DIR + File.separator + DATA_FILE;

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir; // 폴더
	private File dataFile; // 파일

	public int getSize() {
		return list.size();
	}

	// data 폴더가 있는지 검사하고, 없으면 생성하는 메소드
	private void initDataDir() {
		dataDir = new File(DATA_DIR);
	    if (!dataDir.exists()) {
	    	dataDir.mkdirs();
	    }
	} 

	// 데이터 파일이 존재하는지 엄사하고, 
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
	private void initDataFile() {
	    initDataDir();

	    dataFile = new File(FILE_PATH);
	    if (!dataFile.exists()) {
	        try {
	            dataFile.createNewFile();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    readDataFromFile();
	}

	// 멤버 변수 list 객체를 data/contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("data/contact.data");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			oout.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// data/contact.data 파일에서 ArrayList 객체를 읽어와서
	//멤버 변수 list에 저장(읽기)
	private void readDataFromFile() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("data/contact.data");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);

			list = (ArrayList<ContactVO>) oin.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public int insert(ContactVO vo) {
		initDataFile();
		if(list.size() == MAX) {
			return 0;
		} else {
			list.add(vo);
			writeDataToFile();
		}
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.set(index, vo);
		writeDataToFile();
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		writeDataToFile();
		return 1;
	}

}




