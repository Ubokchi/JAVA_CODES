
package edu.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ajax_test.do")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjaxServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		
		PrintWriter out = response.getWriter();
		// Ajax success : funcion(result)에 전송될 데이터
		out.append("id: " + id + "<br>");
		out.append("pw: " + pw + "<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
