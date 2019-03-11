package com.example.interval_sum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IntervalSumServlet
 */
@WebServlet("/interval_sum.do")
public class IntervalSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntervalSumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step #1. get input parameters
//		request.setCharacterEncoding("utf-8");
		int firstNum = Integer.parseInt(request.getParameter("first_num"));
		int secondNum = Integer.parseInt(request.getParameter("second_num"));
		
		// Step #2. data processing
		int intervalSum = 0;
		for (int i=firstNum; i<=secondNum; i++)
			intervalSum += i;
		
		// Step #3. output processing results
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>구간합 결과</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h2>구간합 결과</h2>");
			out.println("<p>" + firstNum + "에서 " + secondNum + "까지의 구간합 = " + intervalSum + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
