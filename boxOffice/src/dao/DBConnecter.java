package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Alt + shift + r : 이름 전체 변경
public class DBConnecter {
	private static final String PATH = "boxOffice.txt";//경로

	public static String getPath() {
		return PATH;
	}//final이라서 setter는 만들 수 없음
	
	//static으로 만드는 이유는 사용하기 편하려고
	//데이터 추가
	public static BufferedWriter getAppend() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
		return bw;
		//close는 메소드를 사용하는 곳에서 한다.
	}
	
	//데이터 가져오기
	public static BufferedReader getReader() throws IOException{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(PATH));
		} catch (FileNotFoundException e) {}// 파일이 없을 경우 예외 발생
		return br;
	}
	
	//데이터 덮어쓰기
	public static BufferedWriter gerWriter() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
		return bw;
	}
	
	
}
