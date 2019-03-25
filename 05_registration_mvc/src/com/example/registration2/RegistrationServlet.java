package com.example.registration2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		// Step #1: get input parameters
		request.setCharacterEncoding("UTF-8");
		
		PersonalInfoDO pi = new PersonalInfoDO();
		pi.setName(request.getParameter("name"));
		pi.setId(request.getParameter("id"));
		pi.setPasswd(request.getParameter("passwd"));
		pi.setGender(request.getParameter("gender"));
		pi.setInotice(request.getParameter("inotice") != null ? true : false);
		pi.setCnotice(request.getParameter("cnotice") != null ? true : false);
		pi.setDnotice(request.getParameter("dnotice") != null ? true : false);
		pi.setJob(request.getParameter("job"));
		pi.setIntro(request.getParameter("intro"));
		
		// Step #2: data processing
		// Save personal info to DB
		RegistrationDAO dao = new RegistrationDAO();
		dao.registerPersonalInfo(pi);

		PersonalInfoDO searchResult = dao.getPersonalInfo(pi.getId());
		
		// Step #3: out processing result
		request.setAttribute("pinfo", searchResult);
		
		RequestDispatcher view = request.getRequestDispatcher("RegistrationResult.jsp");
		view.forward(request, response);
	}

}
