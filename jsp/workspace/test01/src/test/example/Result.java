package test.example;

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
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		Calc calc = new Calc();
		String input = request.getParameter("input").replaceAll(" ", "");
		String opers = "+-*/";
		String anwser = null;
		char oper = ' ';
		int num1 = 0, num2 = 0;
		String[] arTemp = null;
		int check = 0;
		
		for (int i = 0; i < opers.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == opers.charAt(i)) {
					oper = input.charAt(j);
					check++;
				}
			}
		}
		out.println("<html><body><h4>결과</h4>");
		out.println("<p>");
		if(check == 1) {
			try {
				arTemp = input.split("\\"+oper);
				num1 = Integer.parseInt(arTemp[0]);
				num2 = Integer.parseInt(arTemp[1]);
				switch(oper) {
					case '+':
						anwser = calc.add(num1, num2) + "";
						break;
					case '-':
						anwser = calc.sub(num1, num2) + "";
						break;
					case '*':
						anwser = calc.mul(num1, num2) + "";
						break;
					case '/':
					try {
						anwser = calc.div(num1, num2) + "";
					} catch (ArithmeticException e) {
						anwser = "0으로 나눌 수 없습니다.";
					}
						break;
				}
			} catch (NumberFormatException e) {
				anwser = "두 정수를 입력해주세요.";
			} catch (ArrayIndexOutOfBoundsException e) {
				anwser = "양식에 맞게 입력해주세요.";
			}
		}else if(check > 1) {
			anwser = "두 정수의 연산만 가능합니다.";
		}else {
			anwser = "연산자를 찾을 수 없습니다.";
		}
		out.println("<a href=calc>" + anwser + "</a></p>");
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
