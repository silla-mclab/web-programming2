package com.example.builtinobjecttest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestObjectTest
 */
@WebServlet("/request_test.do")
public class RequestObjectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestObjectTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
			out.println("<meta charset='utf-8' >");
			out.println("<title>Request 객체 테스트</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<div style='margin-left:100px;'>");
			out.println("<h1>Request 객체 테스트</h1>");
			out.println("<ol>");
				out.println("<li>요청 URL : " +request.getRequestURL() + "</li>");
				out.println("<li>요청 메소드 : " +request.getMethod() + "</li>");
				out.println("<li>쿼리 스트링 : " +request.getQueryString() + "</li>");
				out.println("<li>헤드 이름 리스트 : ");
				    Enumeration<String> names = request.getHeaderNames();
				    while (names.hasMoreElements())
				    	out.print(names.nextElement() + "  ");
				out.println("</li>");
				out.println("<li>브라우저 유형 : " +request.getHeader("user-agent") + "</li>");
			out.println("</ol>");
			out.println("</div>");
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
