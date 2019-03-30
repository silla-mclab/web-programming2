package com.example.fibonacci_series;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciSeries
 */
//@WebServlet("/FibonacciSeries")
public class FibonacciSeries extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BigInteger[] fiboSeries = null;
	private PrintWriter logFile = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibonacciSeries() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/* version 1.0-----------------------------    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get input parameters
		request.setCharacterEncoding("utf-8");
		int count = Integer.parseInt(request.getParameter("count"));
		
		// step #2. data processing
		BigInteger[] fiboSeries = null;
		if (count > 2) { 
			fiboSeries = new BigInteger[count];
			
			fiboSeries[0] = new BigInteger("1");
			fiboSeries[1] = new BigInteger("1");
			for (int i=2; i<count; i++) {
				fiboSeries[i] = fiboSeries[i-1].add(fiboSeries[i-2]);
			}
		}
		
		// step #3. output processing results
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>피보나치 수열</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>피보나치 수열</h1><hr>");
			out.println("<p>원소의 개수 : " + count + "</p>");
			if (count > 2) {
				for (int i=0; i<count; i++) {
					out.print(fiboSeries[i] + "  ");
					if ((i != 0) && ((i%10) == 0)) out.println("<br>");
				}
			}
			else {
				out.println("<p>요청하신 원소의 개수가 너무 적습니다!....</p>");
			}
		out.println("</body>");
		out.println("</html>");
	}
------------------------- */	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get input parameters
		request.setCharacterEncoding("utf-8");
		int count = Integer.parseInt(request.getParameter("count"));
		
		int maxElements = Integer.parseInt(getServletConfig().getInitParameter("max_elements"));
		
		// step #2. data processing
		GregorianCalendar now = new GregorianCalendar();
		logFile.printf("%TF %TT - count = %d\n", now, now, count);
		
		// step #3. output processing results
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>피보나치 수열</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>피보나치 수열</h1><hr>");
			out.println("<p>원소의 개수 : " + count + "</p>");
			if (count > maxElements) {
				out.println("<p>요청하신 원소의 개수가 너무 많습니다!....</p>");
			}
			else if (count > 2) {
				for (int i=0; i<count; i++) {
					out.print(fiboSeries[i] + "  ");
					if ((i != 0) && ((i%10) == 0)) out.println("<br>");
				}
			}
			else {
				out.println("<p>요청하신 원소의 개수가 너무 적습니다!....</p>");
			}
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


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ServletConfig config = getServletConfig();
		int maxElements = Integer.parseInt(config.getInitParameter("max_elements"));
		String logFileName = config.getInitParameter("log_file");
		
		// generate fibonacci series data
		fiboSeries = new BigInteger[maxElements];
		fiboSeries[0] = new BigInteger("1");
		fiboSeries[1] = new BigInteger("1");
		for (int i=2; i<100; i++) {
			fiboSeries[i] = fiboSeries[i-1].add(fiboSeries[i-1]);
		}
		
		// open log file
		try {
			logFile = new PrintWriter(new FileWriter(logFileName, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
		if (logFile != null) {
			logFile.close();
		}
	}

	
}
