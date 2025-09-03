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

        String userid = request.getParameter("userid");
        HttpSession session = request.getSession(false);
        if ((userid == null || userid.isEmpty()) && session != null) {
            Object uid = session.getAttribute("userid");
            if (uid != null) userid = String.valueOf(uid);
        }
        if (userid == null || userid.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
            return;
        }

        MemberVO vo = new MemberVO();
        vo.setUserid(userid);
        vo.setPassword(request.getParameter("password"));
        vo.setEmail(request.getParameter("email"));
        vo.setEmailAgree(request.getParameter("emailAgree"));
        vo.setInterest(request.getParameterValues("interest"));
        vo.setPhone(request.getParameter("phone"));
        vo.setIntroduce(request.getParameter("introduce"));

        int result = 0;
        try {
            result = dao.update(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            response.sendRedirect(request.getContextPath() + "/memberResult.jsp?updated=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/memberUpdate.jsp?error=updateFail");
        }
    }
}