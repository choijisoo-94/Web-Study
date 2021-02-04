package emp.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.domain.EmpDTO;


@WebServlet("/successEmpView")
public class SuccessEmpView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<EmpDTO> all = (ArrayList<EmpDTO>) request.getSession().getAttribute("all");
		
		
		for(EmpDTO emp : all) {
			out.println(emp + "<br>");
			
		}
	}

}


