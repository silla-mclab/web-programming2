package com.example.builtinobjecttest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFileTest
 */
@WebServlet("/get_file.do")
public class GetFileTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFileTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fn = request.getParameter("fn");
		
		if (fn != null) {
			response.setContentType("image/jpeg");
		
			ServletContext context = getServletContext();
			InputStream is = context.getResourceAsStream("/resources/" + fn);
			
			int read = 0;
			byte[] buffer = new byte[1024];
			
			OutputStream os = response.getOutputStream();
			while ((read = is.read(buffer)) != -1) {
				os.write(buffer, 0, read);
			}
			
			os.flush();
			os.close();
			is.close();
		}
		else {
			response.getWriter().append("요청하신 파일이 없습니다!...");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
