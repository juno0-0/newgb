package com.koreait.app.board.dao;

import java.util.Enumeration;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.board.vo.FilesVO;
import com.koreait.mybatis.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class FilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public FilesDAO() {
		session = sessionf.openSession(true);
	}
	
	//첨부파일 등록하기
	public boolean insertFiles(int boardNum, MultipartRequest multi) {
		boolean check = true;
		FilesVO vo = new FilesVO();
		
		//Iterator같은 것
		//파일 순서가 없는 것에 순서를 부여해주는 것
		//사용자가 업로드한 원본 파일명
		Enumeration<String> files = multi.getFileNames();
		
		//files.hasMoreElements() : 없을 때 까지 반복
		while(files.hasMoreElements()) {
			//하나씩 가져오는 것
			String data = files.nextElement();
			//getFilesystemName() : 서버에 동일한 이름이 있는지 검사후 있으면 변경된 시스템 파일명, 없으면 원본 파일명을 가져온다.
			String systemName = multi.getFilesystemName(data);
			if(systemName == null) {continue;}
			
			vo.setFileName(systemName);
			vo.setBoardNum(boardNum);
			
			if(session.insert("Files.insertFile", vo) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
}
