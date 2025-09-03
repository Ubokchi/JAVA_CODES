package bokchi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public DeleteController() {
		dao = MemberDAOImple.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/memberUpdate.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
			return;
		}
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		int result = 0;
		
        try {
            result = dao.delete(loginUser.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		if (result == 1) {
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/login.jsp?deleted=1");
		} else {
			response.sendRedirect(request.getContextPath() + "/memberResult.jsp?error=deleteFail");
		}
	}
}