package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.BoxOfficeVO;

public class BoxOfficeDAO {
	// private 추가(랭킹이 전달되지 않았을 때)
	private boolean append(BoxOfficeVO film) throws IOException {

		// 외부에서 전달될 영화 정보가 없을 때
		if (film == null) {
			return false;
		}

		// 마지막 랭킹을 알아야 한다.
		BufferedReader br = DBConnecter.getReader();

		// 해당 경로에 읽어올 파일이 없을 때
		if (br == null) {return false;}

		// 메모장 각 줄(라인) 문자열을 저장할 변수
		String line = null;

		// 마지막 랭킹 번호를 저장할 변수
		int lastRanking = 0;

		// while문 종료 시 lastRanking에는 마지막 영화 순위가 저장된다.
		// readLine() : 한줄 가져오는 것, \n은 안가져온다.
		while ((line = br.readLine()) != null) {
			lastRanking++;// 마지막 순위 구하기
		}
//		System.out.println(lastRanking);
		br.close();

		// 텍스트파일에서 각 컬럼의 구분은 \t로 구성되어 있다.
		// 파일의 가장 마지막 문자가 \n인지 검사(readAllBytes() 사용)
		String contents = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath())));// 메모장 전체 문자열
		// 메모장 양식에 맞춰서 추가할 요소를 담아 줄 임시저장공간
		String temp = "";

		// 가장 마지막에 줄바꿈이 있는지 검사
		if (contents.charAt(contents.length() - 1) != '\n') {// contents.length()에 -1을 하는 이유는
			// 줄바꿈이 없다면 \n을 추가하고 시작한다.						길이가 100이면 0~99까지이기 때문이다.
			temp += "\n";
		}

		// 새롭게 추가될 영화순위는 마지막 순위 +1이 된다.
		temp += lastRanking + 1 + "\t" 
				+ film.getFilmName() + "\t" 
				+ film.getReleaseDate() + "\t" 
				+ film.getIncome()+ "\t" 
				+ film.getGuestCnt() + "\t" 
				+ film.getScreenCnt() + "\n";// 마지막 \n은 추가해도 되고 빼도 된다.

		BufferedWriter bw = DBConnecter.getAppend();
		bw.write(temp);
		bw.close();

		return true;
	}

	// private 삽입(랭킹이 전달되었을 때)
	private boolean insert(BoxOfficeVO film) throws IOException {

		if (film == null) {return false;}

		//전달받은 삽입할 랭킹을 newRanking에 담아준다.
		int newRanking = film.getRanking();

		BufferedReader br = DBConnecter.getReader();
		if(br==null) {return false;}
		
		String line = null;
		String temp = "";

		//삽입 여부 FLAG
		boolean check = false;

		while ((line = br.readLine()) != null) {
			// line은 원본
			// newRanking에 저장되있는건 신규

			// 삽입할 순위를 기존 데이터와 비교
			if (Integer.parseInt(line.split("\t")[0]) == newRanking) {
				// 현재 순위와 삽입할 순위가 일치하면
				// 기존 정보 이전에 새로운 삽입할 정보를 temp에 넣어준다.
				// 2등에 넣을꺼면 기존의 2등보다 먼저 temp에 넣는 것!
				temp += film.getRanking() + "\t" 
						+ film.getFilmName() + "\t" 
						+ film.getReleaseDate() + "\t"
						+ film.getIncome() + "\t" 
						+ film.getGuestCnt() + "\t" 
						+ film.getScreenCnt() + "\n";// 마지막 \n은
				
				check = true;
				//삽입 완료
			}

			if (check) {
				// temp에다가 기존의 랭킹을 지우고 랭킹을 만들어서 넣어주고 나머지 정보에서 기존 랭킹만 빼고 연결한다.
				// check가 true로 바뀐 순간부터는 그 이후 순위를 1씩 증가해서 새롭게 매긴 것
				// line.substring(line.indexOf("\t")) : 순위를 제외한 나머지 정보(\t부터 가지고 있다.)
				temp += ++newRanking + line.substring(line.indexOf("\t")) + "\n";
			} else {
				// 삽입 전에는 순위를 그대로 유지해야 한다.
				temp += line + "\n";
			}
		}
		br.close();

		BufferedWriter bw = DBConnecter.getAppend();
		bw.write(temp);
		bw.close();

		// 삽입 후 나머지 랭킹에 모두 +1을 하여 수정해준다.
		// 삽입 전에는 순위를 그대로 유지해야 한다.

		return true;
	}

	// INSERT
	public boolean insertOrAppend(BoxOfficeVO film) throws IOException {
		// 랭킹의 유무로 추가와 삽입을 판단한다.
		if (film.getRanking() == 0) {
			// 추가, 마지막 줄에 추가
			if(append(film)) {return true;}
		} else {
			// 삽입, 그 위치에 삽입
			// 전달받은 랭킹이 마지막 순위보다 클 때(오류)
			// ex) 1~100까지 있는데 103위에 삽입하라고 하는 것
			String contents = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath())));
			String[] arTemp = contents.split("\n");
			//마지막 순위와 전달받은 순위 비교
			if(Integer.parseInt(arTemp[arTemp.length - 1].split("\t")[0]) < film.getRanking()) {return false;}
			//Integer.parseInt(arTemp[arTemp.length - 1].split("\t")[0] 전체가 랭킹이라는 정수
			if(insert(film)) {return true;}
		}

		return false;
	}

	// 수정(영화제목만 수정가능)
	public boolean update(String filmName, String newFilmName) throws IOException {
		
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		String temp = null;
		String line = null;
		
		//수정 완료 여부 FLAG
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			// 메모장에서 한 줄씩 가져온 후 수정할 영화제목을 비교하여 검사한다.
			//equals()는 똑같은 이름만 바꿈
			//contains하면 이름이 포함된거 전부 다 바꿈, 타이타닉, 타이타닉2, 타이타닉3
			if(line.split("\t")[1].equals(filmName)) {
				
				
				//486	캐치 미 이프 유 캔	2003-01-24	0	1,807,612	S	44
				
				//substring : 인덱스번호부터 리턴한다.
				//				인덱스가 5면 5번부터 쭉 출력
				
				String stub = line.substring(line.indexOf("\t")+1);//원래 \t부터인데 +1을 해서 영화 제목부터 끝까지가 들어감
				// 일치하는 영화제목이 있다면 새로운 영화제목으로 변경 한다.
				//영화 제목부터 있던 애를 다시 substring(stub.indexOf("\t")) 하면 영화 제목이 날아감
				temp += line.split("\t")[0] + "\t" + newFilmName + stub.substring(stub.indexOf("\t"));
				check = true;
				continue;
			}
			temp += line + "\n";
		}
		br.close();
		
		// 수정이 되었다면 덮어 쓴 후 true 리턴
		if(check) {
			BufferedWriter bw = DBConnecter.gerWriter();
			bw.write(temp);
			bw.close();
			return true;
		}

		
		/*
		String temp = "";
		BufferedReader br = DBConnecter.getReader();
		if(br==null) {return false;}
		String line = "";
		while((line = br.readLine())!=null) {
			String[] arTemp = line.split("\t");
			if(arTemp[1].equals(filmName)) {
				arTemp[1] = newFilmName;
				for(int i = 0; i<6; i++) {					
					if(i==5) {
						temp += arTemp[i] + "\n";						
					}
					temp += arTemp[i] + "\t";
				}
				continue;
			}else {
				temp += line+"\n";
			}
		}
		*/
		
		return false;
	}

	// 삭제
	public boolean delete(String filmName) throws IOException{
		
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		
		String line = null;
		String temp = "";
		int ranking = 0;
		
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			ranking++;
			if(line.split("\t")[1].equals(filmName)) {
				ranking--;
				check = true;
				continue;
			}
			temp += ranking + line.substring(line.indexOf("\t")) + "\n";
		}
		br.close();
		
		if(check) {
			BufferedWriter bw = DBConnecter.gerWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		
		return false;
	}

	//여기부터 복습 좀 다시 하기
	
	// 검색
	public ArrayList<BoxOfficeVO> select(String keyword) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		ArrayList<BoxOfficeVO> filmList = new ArrayList<>();
		if(br==null) {return null;}
		
		String line = null;

		while((line = br.readLine()) != null) {
			String[] arTemp = line.split("\t");
			if(line.split("\t")[1].contains(keyword)) {
				BoxOfficeVO film = new BoxOfficeVO();
				
				film.setRanking(Integer.parseInt(arTemp[0]));
				film.setFilmName(arTemp[1]);
				film.setReleaseDate(arTemp[2]);
				film.setIncome(Long.parseLong(arTemp[3]));
				film.setGuestCnt(Integer.parseInt(arTemp[4]));
				film.setScreenCnt(Integer.parseInt(arTemp[5]));
				
				filmList.add(film);
			}
		}
		br.close();
		return filmList;
	}
	
	// 목록
	public ArrayList<BoxOfficeVO> selectAll() throws IOException{
		BufferedReader br = DBConnecter.getReader();
		ArrayList<BoxOfficeVO> filmList = new ArrayList<>();
		if(br==null) {return null;}
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			String[] arTemp = line.split("\t");
			BoxOfficeVO film = new BoxOfficeVO();
				
			film.setRanking(Integer.parseInt(arTemp[0]));
			film.setFilmName(arTemp[1]);
			film.setReleaseDate(arTemp[2]);
			film.setIncome(Long.parseLong(arTemp[3]));
			film.setGuestCnt(Integer.parseInt(arTemp[4]));
			film.setScreenCnt(Integer.parseInt(arTemp[5]));
				
			filmList.add(film);
		}
		br.close();
		return filmList;
	}
}
