package com.example.sessiontest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageDispatchController
 */
@WebServlet("/op/*")
public class PageDispatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageDispatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get URL path
		request.setCharacterEncoding("utf-8");
		String pathInfo = request.getPathInfo();

		String viewPage = null;
		HttpSession session = null;
		FavoriteInfoDao dao = null;
		
		// step #2. route request to service components
		if (pathInfo.equals("/page1.do")) {
			String name = request.getParameter("user_name");
			session = request.getSession();
			dao = (FavoriteInfoDao)session.getAttribute("dao");
			if (dao == null) {
				session.setAttribute("dao", new FavoriteInfoDao());
			}
			session.setAttribute("user_name", name);
			viewPage = "page1.jsp";
		}
		else if (pathInfo.equals("/page2.do")) {
			session = request.getSession(false);
			if (session != null) {
				dao = (FavoriteInfoDao)session.getAttribute("dao");
				String fruit = request.getParameter("fruit");
				dao.setFavoriteItem("fruit", fruit);
				viewPage = "page2.jsp";			
			}
			else {
				viewPage = "error.jsp";
			}
		}
		else if (pathInfo.equals("/page3.do")) {
			session = request.getSession(false);
			if (session != null) {
				dao = (FavoriteInfoDao)session.getAttribute("dao");
				String pet = request.getParameter("pet");
				dao.setFavoriteItem("pet", pet);
				viewPage = "page3.jsp";			
			}
			else {
				viewPage = "error.jsp";
			}
		}
		else if (pathInfo.equals("/result.do")) {
			session = request.getSession(false);
			if (session != null) {
				dao = (FavoriteInfoDao)session.getAttribute("dao");
				String subject = request.getParameter("subject");
				dao.setFavoriteItem("subject", subject);
				viewPage = "page4.jsp";			
			}
			else {
				viewPage = "error.jsp";
			}
		}
		else {
			viewPage = "noPageError.jsp";
		}
		
		// step #3. forward to view components
		if (viewPage != null) {
			StringBuilder sb = new StringBuilder(viewPage);
			sb.insert(0, "../");
			RequestDispatcher view = request.getRequestDispatcher(sb.toString());
			view.forward(request, response);
		}
	}

}
