package com.example.builtinobjecttest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTest
 */
//@WebServlet("/config_test.do")
public class ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfigTest() {
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
			out.println("<title>ServletConfig 객체 테스트</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<div style='margin-left:100px;'>");
			out.println("<h1>ServletConfig 객체 테스트</h1>");
			out.println("<h4>서블릿 초기화 파라미터 목록</h4>");
			out.println("<ol>");
				ServletConfig config = getServletConfig();
				Enumeration<String> paramNames = config.getInitParameterNames();
			    while (paramNames.hasMoreElements()) {
			    	String name = paramNames.nextElement();
					out.println("<li>" + name + " = " + config.getInitParameter(name) + "</li>");
			    }
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
