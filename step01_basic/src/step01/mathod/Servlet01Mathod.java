package step01.mathod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* client 가 요청하는 url값 설정 에노테이션
 * http://it:port/project명/[디렉터리]/file명.html
 * http://it:port/project명/[디렉터리]/servletURL매핑값
 * http://localhost/step01_basic/encore01
 */
@WebServlet("/encore01")
public class Servlet01Mathod extends HttpServlet {


	//get 방식 요청시 자동 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		//요청 객체에 한글이 포함되어 있을 경우 깨짐 현상 방지를 위한 설정
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("name"));
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//접속한 client에게 한글 응답
		//mime type & 한글 응답이 가능한 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(id.equals("SMITH") && pw.equals("11")) {
			//forward
			request.getRequestDispatcher("success").forward(request, response);
		}else {
			//redirect
			response.sendRedirect("fail");
		}


	}



//	//post 방식 요청시 자동 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("encore01 doPost()");
	
	//요청 객체에 한글이 포함되어 있을 경우 깨짐 현상 방지를 위한 설정
			request.setCharacterEncoding("utf-8");
			System.out.println(request.getParameter("name"));
			
		String id = request.getParameter("id"); //id key 자체가 없을 경우 null
		String pw = request.getParameter("pw");

		
		if(id.equals("SMITH") && pw.equals("11")) {
			//forward
			request.getRequestDispatcher("success").forward(request, response);
		}else {
			//redirect
			response.sendRedirect("fail");
		}
	}

}
