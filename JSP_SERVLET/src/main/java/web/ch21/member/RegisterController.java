package web.ch21.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

    public RegisterController() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect() : 특정 경로로 이동
		// - request가 소멸되기 때문에 parameter 방식으로 데이터 전송 불가능
		response.sendRedirect("/JSP_SERVLET/ch21/register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setEmailAgree(emailAgree);
		vo.setInterest(interest);
		vo.setPhone(phone);
		vo.setIntroduce(introduce);
		System.out.println(vo);
		
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("성공");
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(60);
		}
	}

}