package bokchi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/select.do")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

    public SelectController() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userid") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
            return;
        }

        String userid = String.valueOf(session.getAttribute("userid"));

        MemberVO user = null;
        try {
            user = dao.selectByUserid(userid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("/memberResult.jsp").forward(request, response);
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}