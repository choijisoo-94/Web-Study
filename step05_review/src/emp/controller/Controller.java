package emp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.model.EmpDAO;
import emp.model.domain.EmpDTO;

@WebServlet("/controller")
public class Controller extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String url = "successView";
		
		if(id.equals("SMITH") && pw.equals("11")) {
			try {
				ArrayList<EmpDTO> all = EmpDAO.empAll();
				
				if(all.size() != 0) {
					request.getSession().setAttribute("all", all);
					
					url = "successEmpView.jsp"; 
					request.setAttribute("message", "현 시점에선 부서 정보가 하나도 없습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
				url = "failView";
				request.setAttribute("errorMsg", "죄송합니다. 잠시후에 재 요청해 주세요.");
			}
			
		}else {
			request.setAttribute("message", "id or pw 재확인 부탁드려요.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}

