package calc.example;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Calc c = new Calc();
		String temp = request.getParameter("input").replaceAll(" ", "");
		String opers = "+-*/";
		String msg = "";
		char oper = ' ';
		int num1 = 0, num2 = 0, check = 0;
		
		out.println("<html><body><h3>결과</h3>");
		
		for (int i = 0; i < opers.length(); i++) {
			for (int j = 0; j < temp.length(); j++) {
				if(temp.charAt(j) == opers.charAt(i)) {
					oper = temp.charAt(j);
					check++;//연산자의 갯수
				}
			}
		}
		if(check == 1) {
			try {
				String[] arTemp = temp.split("\\"+oper);
				num1 = Integer.parseInt(arTemp[0]);
				num2 = Integer.parseInt(arTemp[1]);
				switch(oper) {
				case '+':
					msg = c.add(num1, num2)+"";
					break;
				case '-':
					msg = c.sub(num1, num2)+"";
					break;
				case '*':
					msg = c.mul(num1, num2)+"";
					break;
				case '/':
					try {
						msg = c.div(num1, num2)+"";
					} catch (ArithmeticException e) {
						msg = "0으로 나눌 수 없습니다.";
					} catch (ArrayIndexOutOfBoundsException e) {
						msg = "양식에 맞게 작성해주세요.";
					}
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(check > 1){
			msg = "두 정수의 연산만 가능합니다.";
		}else {//check == 0
			msg = "연산 기호를 찾을 수 없습니다.";
		}
		
		out.println("<a href='calc'>"+msg+"</a></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
