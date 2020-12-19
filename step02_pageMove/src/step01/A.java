package step01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//http:/ip:port/project/a
//http:/ip:port/project/b
@WebServlet("/a")
public class A extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("A 입니다");
	
	//step01 : A forward 라는 기술로 B로 이동
	//요청 - http://localhost/step02_pageMove/a
	//응답 완료 - http://localhost/step02_pageMove/a
	//request.getRequestDispatcher("b").forward(request, response);
	
	
	//step02 : A redirect 라는 B로 이동
	//요청 - http://localhost/step02_pageMove/a
	//응답 : http://localhost/step02_pageMove/b
	response.sendRedirect("b");
	}

}
