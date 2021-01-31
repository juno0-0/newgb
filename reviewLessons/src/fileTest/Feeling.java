package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileManager.Location;

public class Feeling {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw;
		
		bw = new BufferedWriter(new FileWriter("feel.txt"));
		bw.write("기쁨\n");
		bw.write("슬픔\n");
		bw.write("화남\n");
		bw.write("우울함\n");
		bw.flush();
		bw.close();
		
		// 추가하기 
		// 몽롱함
		bw = new BufferedWriter(new FileWriter("feel.txt", true));
		bw.write("몽롱함\n");
		bw.flush();
		bw.close();
		
		// 수정하기
		// 기쁨을 신남으로 수정
		BufferedReader br = new BufferedReader(new FileReader("feel.txt"));
		String line = "";
		String temp = "";
		
		boolean check = false;
		while((line = br.readLine()) != null) {
			if(line.equals("기쁨")) {
				temp += "신남\n";
				check = true;
				continue;
			}
			temp += line + "\n";
		}
		br.close();
		
		bw = new BufferedWriter(new FileWriter("feel.txt"));
		if(check) {
			bw.write(temp);
		}
		bw.flush();
		bw.close();
		
		// 삭제하기
		// 우울함 삭제하기
		br = new BufferedReader(new FileReader("feel.txt"));
		try {
			while((line = br.readLine()) != null) {
				if(line.equals("우울함")) {continue;}
				temp += line + "\n";
			}
			br.close();
			
			bw = new BufferedWriter(new FileWriter("feel.txt"));
			bw.write(temp);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		br = new BufferedReader(new FileReader("feel.txt"));
		List<String> list = new ArrayList<String>();
		while((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();
		
		System.out.println(list);
		
	}
}
