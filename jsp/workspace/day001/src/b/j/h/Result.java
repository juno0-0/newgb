package b.j.h;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")//요청된 URL 매핑 - 요청된 전송방식에 맞는 doGet() 또는 doPost()가 실행된다.
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;//직렬화
    Calc c = new Calc();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//전달받은 데이터 인코딩 설정
		response.setCharacterEncoding("UTF-8");//전달할 데이터 인코딩 설정
		
		response.setContentType("text/html; charset=UTF-8");//응답할 페이지 타입 설정	
		
		//공백을 없애기 위해 문자열 안에 있는 " "을 ""로 대체한다.
		String input = request.getParameter("su").replaceAll(" ", "");
		PrintWriter out = response.getWriter();
		String opers = "+-*/";//4칸 문자 배열
		char oper = ' ';
		int check = 0;
		String[] arTemp = null;
		int num1 = 0, num2 = 0;
		String resultMsg = null;
		
		out.println("<html><body><h1>서블릿으로 만든 페이지</h1>");
		
		//수식 내의 연산자를 찾아주는 로직
		for(int i=0; i<opers.length(); i++) {
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == opers.charAt(i)) {
					//연산자를 찾았다면 oper에 저장
					oper = input.charAt(j);
					//수식 내의 연산자 개수
					check++;
				}
			}
		}
		
		out.println("<p>결과 : ");
		if(check == 1) {//수식 내의 연산자가 1개 있다는 뜻
			try {
				//찾은 연산자를 기준으로 양 옆을 잘라준다.
				arTemp = input.split("\\"+oper);
				num1 = Integer.parseInt(arTemp[0]);//첫번째 정수
				num2 = Integer.parseInt(arTemp[1]);//두번째 정수
				switch(oper) {
				case '+':
					resultMsg = c.add(num1, num2) + "";
					break;
				case '-':
					resultMsg = c.minus(num1, num2) + "";
					break;
				case '*':
					resultMsg = c.mul(num1, num2) + "";
					break;
				case '/':
					try {
						resultMsg = c.div(num1, num2) + "";
					} catch (Exception e) {
						resultMsg = "0으로 나눌 수 없습니다.";
					}
					break;
				}
			} catch (NumberFormatException e) {
				resultMsg = "정수의 연산만 가능합니다.";
			} catch (ArrayIndexOutOfBoundsException e) {
				resultMsg = "양식에 맞게 작성해주세요.";
			}
		} else if(check > 1) { //연산자가 2개 이상이라는 뜻
			resultMsg = "두 정수의 연산만 가능합니다.";
		}else {//check == 0
			resultMsg = "연산자를 찾지 못했습니다.";
		}
		out.println(resultMsg + "</p>");
		out.println("<a href='calc'>JSP 페이지로 이동</a></body></html>");
		out.close();
		
		/*String[] temp = request.getParameter("su").split("\\+|\\-|\\*|\\/");
		PrintWriter out = response.getWriter();
		String msg = "<html><body><h1>결과</h1>";
		int n = 0;
		String operator = request.getParameter("su").substring(1, 2);
		
		switch(operator) {
			case "+":
				n = c.add(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));	
				break;
			case "-":
				n = c.minus(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				break;
			case "*":
				n = c.mul(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				break;
			case "/":
				try {
					n = c.div(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				} catch (ArithmeticException e) {
					out.write("<a href='calc'>분모가 0입니다.</a></body></html>");
					out.close();
					return;
				}	
				break;
			default:
				break;
		}
		msg += "<a href='calc'>" + n + "</a></body></html>";
		out.write(msg);
		out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
