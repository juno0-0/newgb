import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TEST {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
		bw.write("ABCDEFGHIJK가나다라\n마");
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String line = new String(Files.readAllBytes(Paths.get("test.txt")));
		System.out.println(line.charAt(line.length()-2));
	}
}
