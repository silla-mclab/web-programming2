package com.example.builtinobjecttest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest
 */
@WebServlet("/context_test.do")
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextTest() {
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
			out.println("<title>ServletContext 객체 테스트</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<div style='margin-left:100px;'>");
			
			out.println("<h1>ServletContext 객체 테스트</h1>");
			out.println("<h4>컨텍스트 초기화 파라미터 목록</h4>");
			out.println("<ol>");
				ServletContext context = getServletConfig().getServletContext();
				Enumeration<String> paramNames = context.getInitParameterNames();
			    while (paramNames.hasMoreElements()) {
			    	String name = paramNames.nextElement();
					out.println("<li>" + name + " = " + context.getInitParameter(name) + "</li>");
			    }
			out.println("</ol>");

			out.println("<h4>웹 어플리케이션 정보 접근</h4>");
			out.println("<ol>");
				out.println("<li>어플리케이션 URL Path : " + context.getContextPath() + "</li>");
				out.println("<li>어플리케이션 Real Path : " + context.getRealPath("/") + "</li>");
			out.println("</ol>");

			out.println("<h4>컨테이너 서버 정보 접근</h4>");
			out.println("<ol>");
				out.println("<li>서버 유형 : " + context.getServerInfo() + "</li>");
				out.println("<li>Servlet API Major version : " + context.getMajorVersion() + "</li>");
				out.println("<li>Servlet API Minor version : " + context.getMinorVersion() + "</li>");
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
