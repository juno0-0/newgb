package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DB {
	private final static String PATH = "boxOffice.txt";

	//final이라서 setter는 만들 수 없음
	public static String getPath() {
		return PATH;
	}
	
	//데이터 불러오기
	public static BufferedReader getReader() {
		BufferedReader br = null;
		try {br = new BufferedReader(new FileReader(PATH));} catch (FileNotFoundException e) {;}
		return br;//닫는건 사용하는 쪽에서 닫을 수 있도록, 여기서 닫으면 사용부분에서 열어도 안열림
	}
	
	//데이터 덮어쓰기
	public static BufferedWriter getWriter() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
		return bw;
	}
	
	//데이터 추가하기
	public static BufferedWriter getInsert() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
		return bw;
	}
	
	
}
