package com.bjh.app.board.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bjh.app.board.vo.FilesVO;
import com.bjh.app.mybatis.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class FilesDAO {
	SqlSessionFactory session_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public FilesDAO() {
		session = session_f.openSession(true);
	}
	
	//파일첨부 등록
	public boolean insertFile(int boardNum, MultipartRequest multi) {
		boolean check = true;
		FilesVO f_vo = new FilesVO();
		
		Enumeration<String> files = multi.getFileNames();
		while(files.hasMoreElements()) {
			//files에 있는 이름을 가져와서
			String data = files.nextElement();
			//기존의 이름과 비교 후 중복이면 새로운 이름, 중복이 아니면 원본 이름
			String systemName = multi.getFilesystemName(data);
			if(systemName == null) {continue;}
			f_vo.setFileName(systemName);
			f_vo.setBoardNum(boardNum);
			if(session.insert("Files.insertFile", f_vo) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	//첨부파일 보기
	public List<FilesVO> getFileList(int boardNum) {
		return session.selectList("Files.getFileList", boardNum);
	}
	
	//첨부파일 삭제
	public boolean deleteFile(int boardNum) {
		return session.delete("Files.deleteFile", boardNum) == 1;
	}
	
}
