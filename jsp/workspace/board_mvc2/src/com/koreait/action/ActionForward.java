package com.koreait.action;

public class ActionForward {
	private boolean isRedirect;//true면 Redirect false면 forward
	private String path;//경로
	
	//기본 생성자
	public ActionForward() {;}

	//getter & setter
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}