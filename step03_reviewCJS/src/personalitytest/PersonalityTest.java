package personalitytest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class PersonalityTest extends HttpServlet {
	public int result(String result) {
		int returns = 1;
		if(result.equals("yes")) {
			returns = 1;
		} else if (result.equals("no")) {
			returns = 0;
		}
		return returns;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter()	;
		String name = request.getParameter("name");
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		System.out.println(q1+q2+q3);
		int a = result(q1)+result(q2)+result(q3);
		System.out.println(a);
		out.print(name+"님의 성격은 바로 ");
		if(a==3) {
			//out.println("겉차속따 블루! 남들 눈치 제로, 하고싶은 대로 행동하는 마이웨이 당신!<br/>처음엔 다가가기 힘들지만 한번 마음을 열면 온천처럼 따뜻한 반전매력! 당신의 컬러는 고독한 딥블루, 화이트, 온천수 스카이블루");
			response.sendRedirect("3point.html");
		} else if(a==2) {
			//out.println("위대한 겟츠비비드! 비비드한 컬러로 지구 반대편까지 존재감을 뽐내는 당신은 웜쿨믹스 퍼플, 차밍 라벤더, 오렌지, 골드가 어울려요! ");
			response.sendRedirect("2point.html");
		}else if(a==1) {
			//out.println("따뜻한 핫초코~ 찬바람 불때 따스하게 기분을 업해주는 핫초코처럼 대화가 필요할 때 생각나는 당신은 고민 상담사!<br/>당신의 컬러는 허니 캬라멜, 스윗 초콜릿, 햇살 옐로우! ");
			response.sendRedirect("1point.html");
		}else if(a==0) {
			//out.println("피스풀 퍼플믹스! 나와 다른 사람도 진심으로 이해하고 존중하는 우주대통합자! 조화롭게 공존하는 관계를 잘 형성해 남들에게 편안함을 주네요.<br/>당신 컬러는 웜쿨믹스 퍼플, 시크핑크, 고저스 로즈 와인! ");
			response.sendRedirect("0point.html");
		}
	}

}
