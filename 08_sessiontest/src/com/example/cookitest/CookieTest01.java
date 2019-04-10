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
 * Servlet implementation class CookieTest01
 */
@WebServlet("/cookie_01.do")
public class CookieTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		Cookie cookie = new Cookie("user_level", "beginner");
		response.addCookie(cookie);
		
		cookie = new Cookie("color_pref", "blue");
		response.addCookie(cookie);
		
		cookie = new Cookie("visit_count", "1");
		response.addCookie(cookie);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>쿠키 테스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 테스트</h1>");
		out.println("<p>쿠키를 전송하였습니다!...</p>");
		out.println("<p><a href='cookie_02.do'>쿠키 수정하기</a>");
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
