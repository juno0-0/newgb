package com.bjh.app.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;

public class FileDownloadAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2_review\\WebContent\\app\\upload";
		String fileName = req.getParameter("fileName");
		PrintWriter writer = resp.getWriter();
		
		InputStream in = null;
		OutputStream out = null;
		File file = null;

		boolean check = true;
		
		try {
			file = new File(saveFolder, fileName);
			//파일이 없을 경우를 대비해 try catch를 잡아준다.
			in = new FileInputStream(file);
		} catch (Exception e) {
			System.out.println("파일이 존재하지 않음");
			check = false;
			e.printStackTrace();
		}
		
		//브라우저 정보를 가져오는 역할
		String client = req.getHeader("User-Agent");
		
		//사용하기 전에 설정을 초기화
		resp.reset();
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Description", "JSP Generated Data");
		
		if(check) {
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
				if(client.indexOf("MSIE") != -1) {
					resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
				}else {
					resp.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
					resp.setHeader("Content-Type", "application/octet-stream;charset=UTF-8");
				}
				resp.setHeader("Content-Length", ""+file.length());
				
				writer.flush();
				out = resp.getOutputStream();
				
				byte[] b = new byte[(int)file.length()];
				int len = 0;
				
				while((len = in.read(b)) > 0) {
					out.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(in != null) {in.close();}
					if(out != null) {out.close();}
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return null;
	}
}
