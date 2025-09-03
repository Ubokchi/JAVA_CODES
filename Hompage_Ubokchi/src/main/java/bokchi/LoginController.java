package bokchi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

    public LoginController() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect() : 특정 경로로 이동
		// - request가 소멸되기 때문에 parameter 방식으로 데이터 전송 불가능
		response.sendRedirect("/Homepage_Ubokchi/login.jsp");
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        MemberVO vo = dao.selectByUserid(userid); 

        if (vo != null && vo.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", vo);
            session.setMaxInactiveInterval(60);
            response.sendRedirect(request.getContextPath() + "/loginResult.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=1");
        }
    }
}