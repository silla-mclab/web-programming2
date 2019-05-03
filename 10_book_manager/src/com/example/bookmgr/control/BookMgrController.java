package com.example.bookmgr.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.bookmgr.model.Book;
import com.example.bookmgr.model.DbConnectionInfo;

/**
 * Servlet implementation class BookMgrController
 */
@WebServlet("/op/*")
public class BookMgrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMgrController() {
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
		// Step #1. initialize for request processing
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		BookMgrService service = (BookMgrService)session.getAttribute("service");
		if (service == null) {
			DbConnectionInfo connInfo = (DbConnectionInfo)getServletContext().getAttribute("connection_info");
			service = new BookMgrService(connInfo);
			session.setAttribute("service", service);
			session.setMaxInactiveInterval(600);
		}
				
		// Step #2. dispatch request to processing component
		String pathInfo = request.getPathInfo();
		String viewName = "error.jsp";
		
		if (pathInfo.equals("/list")) {
			List<Book> bookList = service.getBookList();
			if (bookList != null) {
				request.setAttribute("list", bookList);
				viewName = "list.jsp";
			}
		}
		else if (pathInfo.equals("/search")) {
			viewName = "search.jsp";
		}
		else if (pathInfo.equals("/search.do")) {
			String code = request.getParameter("code");
			Book book = service.searchBook(code);
			request.setAttribute("book", book);
			viewName = "search_result.jsp";
		}
		else if (pathInfo.equals("/insert")) {
			viewName = "insert.jsp";
		}
		else if (pathInfo.equals("/insert.do")) {
			Book book = getBookFromParameterMap(request.getParameterMap());
			int result = service.insertBook(book);
			request.setAttribute("result", result);
			request.setAttribute("job", "도서 추가");
			viewName = "op_result.jsp";
		}
		else if (pathInfo.equals("/delete")) {
			String code = request.getParameter("code");
			int result = service.deleteBook(code);
			request.setAttribute("result", result);
			request.setAttribute("job", "도서 삭제");
			viewName = "op_result.jsp";
		}
		else if (pathInfo.equals("/update")) {
			Book book = getBookFromParameterMap(request.getParameterMap());
			int result = service.updateBook(book);
			request.setAttribute("result", result);
			request.setAttribute("job", "도서 수정");
			viewName = "op_result.jsp";
		}
		
		// Step #3. forward to view component
		StringBuilder sb = new StringBuilder(viewName);
		sb.insert(0, "../");
		RequestDispatcher view = request.getRequestDispatcher(sb.toString());
		view.forward(request, response);
	}
	
	private Book getBookFromParameterMap(Map<String, String[]> paramMap) {
		Book book = new Book();

		book.setCode(paramMap.get("code")[0]);
		book.setTitle(paramMap.get("title")[0]);
		book.setWriter(paramMap.get("writer")[0]);
		int price = 0;
		try {
			price = Integer.parseInt(paramMap.get("price")[0]);
		}
		catch(NumberFormatException ex) {			
		}
		book.setPrice(price);
		
		return book;
	}

}
