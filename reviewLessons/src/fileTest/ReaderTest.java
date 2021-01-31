package fileTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderTest {
	public static void main(String[] args) throws FileNotFoundException {
		
		//BufferedReader를 사용해서 읽어오기
		BufferedReader br = new BufferedReader(new FileReader("writer.txt"));
		String line = "";
		String temp = "";
		try {
			while((line = br.readLine()) != null) {
				temp += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}
		
		System.out.println(temp);
		
		
		
		// Files.readAllBytes() 사용
		// 파일에 있는 모든 내용을 바이트로 변환해서 불러온다.
//		String contents = new String(Files.readAllBytes(Paths.get("writer.txt")));
//		String[] arStr = contents.split("\n");
//		for(String s:arStr) {
//			System.out.println(s);
//		}
	}
}
