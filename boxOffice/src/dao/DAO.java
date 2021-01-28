package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.VO;

public class DAO {
	// 추가
	// vo에 랭킹이 비어있을 경우
	public boolean append(VO vo) throws IOException {
		// 매개변수로 받은 객체가 비어있으면 false
		if (vo == null) {
			return false;
		}

		// 마지막 번호 찾기
		int lastCnt = 0;
		String line = null;
		String temp = "";

		BufferedReader br = DB.getReader();
		
		if(br==null) {return false;}
		
		while ((line = br.readLine()) != null) {
			// while문이 종료되면 lastCnt에는 마지막 번호가 들어있다.
			lastCnt++;
		}
		br.close();

		// readLine()은 \n을 가져오지 않기 때문에 확인하고 \n을 넣어준다.
		// readAllBytes() : 모든 데이터를 바이트로 바꿔서 바이트 배열로 리턴
		String contents = new String(Files.readAllBytes(Paths.get(DB.getPath())));
		if (contents.charAt(contents.length() - 1) != '\n') {
			temp += "\n";
		}
		
		// 임시변수에 자료 넣어주기
		temp += lastCnt + "\t"
				+ vo.getMovieName() + "\t"
				+ vo.getDate() + "\t"
				+ vo.getIncome() + "\t"
				+ vo.getPerson() + "\t"
				+ vo.getScreen() + "\n";
		
		BufferedWriter bw = DB.getInsert();
		bw.write(temp);
		bw.close();

		return true;
	}
	
	// 삽입
	// vo에 랭킹이 초기화되어 있을 경우
	public boolean insert(VO vo) throws IOException {
		
		if(vo==null) {return false;}
		
		int rank = vo.getRanking();
		String line = null;
		String temp = "";
		
		boolean check = false;
		
		BufferedReader br = new BufferedReader(new FileReader(DB.getPath()));
		if(br==null) {return false;}
		while((line = br.readLine()) != null) {
			if(Integer.parseInt(line.split("\t")[0])==rank) {
				temp += vo.getRanking() + "\t"
						+ vo.getMovieName() + "\t"
						+ vo.getDate() + "\t"
						+ vo.getIncome() + "\t"
						+ vo.getPerson() + "\t"
						+ vo.getScreen() + "\n";
				
				check = true;
			}
			
			if(check) {
				temp += ++rank + line.substring(line.indexOf("\t"))+"\n";
			}else {
				temp += line + "\n";
			}
		}
		br.close();
		
		BufferedWriter bw = DB.getWriter();
		bw.write(temp);
		bw.close();
		
		return true;
	}
	// INSERT
	public boolean appendOrInsert(VO vo) throws IOException {
		if(vo.getRanking()==0) {
			//추가
			if(append(vo)) {return true;}//추가 성공!
		}else {
			//삽입
			//랭킹이 기존 데이터 개수보다 크면 오류가 발생하니 확인하기
			String contents = new String(Files.readAllBytes(Paths.get(DB.getPath())));
			String[] arTemp = contents.split("\n");
			if(Integer.parseInt(arTemp[arTemp.length - 1].split("\t")[0]) < vo.getRanking()) {return false;}
			if(insert(vo)) {return true;}
		}
		return false;
	}
	
	// 수정
	public boolean update(String oldName, String newName) throws IOException {
		BufferedReader br = DB.getReader();
		if(br==null) {return false;}
		String line = null;
		String temp = "";
		
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			//split으로 이름 구해서 비교하기
			if(line.split("\t")[1].equals(oldName)){
				//substing으로 \t부터지만 +1을 해서 이름부터 stub에 저장하기
				String stub = line.substring(line.indexOf("\t")+1);
				//stub에서 한번더 substring을 사용해서 이름 뒤에 \t부터 사용하기
				temp += line.split("\t")[0] + "\t" + newName + stub.substring(stub.indexOf("\t"));
				//수정 성공
				check = true;
				//수정했으면 처음으로 돌아가서 다음 자료를 temp에 담기
				continue;
			}
			temp += line + "\n";
		}
		br.close();
		
		if(check) {
			//수정을 했으면 여기로 들어옴
			BufferedWriter bw = DB.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		//수정이 안되서 if문에 못들어간 것
		return false;
	}
	
	// 삭제
	public boolean delete(String name) throws IOException {
		String line = null;
		String temp = "";
		int ranking = 0;
		
		boolean check = false;
		
		BufferedReader br = DB.getReader();
		if(br==null) {return false;}
		while((line = br.readLine()) != null) {
			ranking++;
			if(line.split("\t")[1].equals(name)) {
				//삭제되면 ranking이 감소하고 다시 while로 올라가서 1증가하고 그 자리에 다음 데이터를 넣는 것
				ranking--;
				check = true;
				continue;
			}
			temp += ranking + line.substring(line.indexOf("\t")) + "\n";
		}
		br.close();
		
		if(check) {
			BufferedWriter bw = DB.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		
		return false;
		
	}
	
	// 이름으로 검색
	public ArrayList<VO> search(String name) throws IOException {
		ArrayList<VO> al = new ArrayList<>();
		String line = null;
		String temp = "";
		BufferedReader br = DB.getReader();
		if(br == null) {return null;}
		while((line = br.readLine()) != null) {
			//검색한 자료가 여러 개가 나오지만 정확한 개수를 알 수 없어서 ArrayList를 사용
			if(line.split("\t")[1].contains(name)) {
				String[] arTemp = line.split("\t");
				VO vo = new VO();
				vo.setRanking(Integer.parseInt(arTemp[0]));
				vo.setMovieName(arTemp[1]);
				vo.setDate(arTemp[2]);
				vo.setIncome(Long.parseLong(arTemp[3]));
				vo.setPerson(Integer.parseInt(arTemp[4]));
				vo.setScreen(Integer.parseInt(arTemp[5]));
				al.add(vo);
			}
		}
		br.close();
		//받는 곳에서 al이 null이면 찾는게 없다고 하면 된다.
		return al;
	}
	
	// 목록
	public ArrayList<VO> list() throws NumberFormatException, IOException{
		ArrayList<VO> al = new ArrayList<>();
		String line = null;
		String temp = "";
		BufferedReader br = DB.getReader();
		if(br==null) {return null;}
		while((line = br.readLine()) != null) {
			String[] arTemp = line.split("\t");
			VO vo = new VO();
			vo.setRanking(Integer.parseInt(arTemp[0]));
			vo.setMovieName(arTemp[1]);
			vo.setDate(arTemp[2]);
			vo.setIncome(Long.parseLong(arTemp[3]));
			vo.setPerson(Integer.parseInt(arTemp[4]));
			vo.setScreen(Integer.parseInt(arTemp[5]));
			al.add(vo);
		}
		br.close();
		//받는 곳에서 al이 null이면 찾는게 없다고 하면 된다.
		return al;
	}
	
}
