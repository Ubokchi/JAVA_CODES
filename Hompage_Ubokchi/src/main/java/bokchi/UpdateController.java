package bokchi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/memberUpdate.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

    public UpdateController() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect() : 특정 경로로 이동
		// - request가 소멸되기 때문에 parameter 방식으로 데이터 전송 불가능
		response.sendRedirect("/Homepage_Ubokchi/memberUpdate.jsp");
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userid = (request.getParameter("userid") == null) ? "" : request.getParameter("userid");
        String password = (request.getParameter("password") == null) ? "" : request.getParameter("password");
        String email = (request.getParameter("email") == null) ? "" : request.getParameter("email");
        String emailAgree = (request.getParameter("emailAgree") == null) ? "N" : request.getParameter("emailAgree");
        String[] interest = request.getParameterValues("interest");
        String phone = (request.getParameter("phone") == null) ? "" : request.getParameter("phone");
        String introduce = (request.getParameter("introduce") == null) ? "" : request.getParameter("introduce");

        if (userid.equals("") || password.equals("") || email.equals("")) {
            response.sendRedirect(request.getContextPath() + "/memberRegister.jsp");
            return;
        }

        MemberVO vo = new MemberVO();
        vo.setUserid(userid);
        vo.setPassword(password);
        vo.setEmail(email);
        vo.setEmailAgree(emailAgree);
        vo.setInterest(interest);
        vo.setPhone(phone);
        vo.setIntroduce(introduce);

        int result = 0;
        try {
            result = dao.update(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", vo);
            response.sendRedirect(request.getContextPath() + "/memberResult.jsp?updated=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/memberUpdate.jsp?error=updateFail");
        }
    }
}