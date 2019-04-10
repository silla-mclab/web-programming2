package com.example.cookitest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest02
 */
@WebServlet("/cookie_02.do")
public class CookieTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Cookie[] cookies = request.getCookies();
		Cookie visitCount = null;
		for (Cookie cookie : cookies) {
			if ("visit_count".equals(cookie.getName())) {
				visitCount = cookie;
				break;
			}
		}
		int vCount = Integer.parseInt(visitCount.getValue());
		vCount++;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>쿠키 테스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 테스트</h1>");
		out.println("<p>사이트 방문 횟수 : " + vCount + " </p>");
		out.println("<p>수신한 쿠키들:</p>");
		for (Cookie cookie : cookies) {
			out.println("name = " + cookie.getName() + ", value = " + cookie.getValue() + "<br>");
		}
		out.println("<br><br>");
		
		visitCount.setValue(String.valueOf(vCount));
		response.addCookie(visitCount);
		
		out.println("<p><a href='cookie_03.do'>쿠키 삭제하기</a>");
		out.println("</body>");
		out.println("</html>");				

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
