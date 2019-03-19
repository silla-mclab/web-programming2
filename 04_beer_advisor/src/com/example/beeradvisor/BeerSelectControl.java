package com.example.beeradvisor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelectControl
 */
//@WebServlet("/BeerSelectControl")
public class BeerSelectControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelectControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* version-1		
		// Step #1: get input parameters
		String color = request.getParameter("color");
		
		// Step #2: data processing
		
		// Step #3: output processing results	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Beer Selection Advice</h1>");
		out.println("Got beer color " + color);
*/
/* version-2	 	
		// Step #1: get input parameters
		String color = request.getParameter("color");
		
		// Step #2: data processing using model object
		BeerExpert expert = new BeerExpert();
		ArrayList<String> brands = expert.getBrands(color);
		
		// Step #3: output processing results	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Beer Selection Advice</h1>");
		
		Iterator<String> it = brands.iterator();
		while (it.hasNext()) {
			out.println("Try '" + it.next() + "'.<br><br>");
		}
*/
/* version-3 */	 	
		// Step #1: get & pre-process input parameters
		String color = request.getParameter("color");
		
		// Step #2: data processing using model object
		BeerExpert expert = new BeerExpert();
		ArrayList<String> brands = expert.getBrands(color);
		
		// Step #3: output processing results using view object
		// forward to view jsp
		request.setAttribute("brands", brands);
		
		RequestDispatcher view = request.getRequestDispatcher("output_beer_brands.jsp");
		view.forward(request, response);
	}

}
