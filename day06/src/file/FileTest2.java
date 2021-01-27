package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest2 {
	public static void main(String[] args) throws IOException{
		String contents = new String(Files.readAllBytes(Paths.get("test.txt")));
		
		System.out.println(contents);
		System.out.println(contents.split("\n")[0]);
		//전체가 나오면 \n을 못찾았다는 이야기라서 그럴 경우 \r\n을 해야한다.
		
	}
}
