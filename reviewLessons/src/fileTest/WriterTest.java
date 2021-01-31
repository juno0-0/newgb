package fileTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("writer.txt"));
		bw.write("안녕하세요?");
		bw.write("\n테스트중입니다.");
		bw.write("\n안녕히계세요.");
		bw.close();
	}	
}
