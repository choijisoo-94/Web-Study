package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encore2")
public class Two extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		//쿠키 정보 획득 - 접속된 client 시스템에서 해당 소스가 포함된 project로 인해 발생된
		//쿠키만 획득
		Cookie [] all = request.getCookies();
		for(Cookie c : all) {
			//out.println(c.getName() + "<br>");
			if(c.getName().equals("id")) { //쿠키 생성시 value 
				out.println(c.getValue());
				c.setValue(null);
				response.addCookie(c);
			}
		}

		//? 코드로 client 시스템에 저장되어 있던 id 값에 매핑된 value값 삭제하기
//		Cookie cookie = new Cookie("id", null);
//
//		cookie.setMaxAge(0);
//
//		response.addCookie(cookie);

		//? encore3라는 Three 라는 servlet 만들어서 cookie 정보 확인
//		response.sendRedirect("encore3");
		out.println("<a href='encore3'>쿠키 삭제 확인</a>");
	}
}

