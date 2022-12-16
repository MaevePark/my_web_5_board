package kh.s0.myboard.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.member.model.MemberService;
import kh.s0.myboard.member.model.MemberVo;

/**
 * Servlet implementation class LoginDoController
 */
@WebServlet("/login.do")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		MemberService service = new MemberService();
		MemberVo loginInfo = service.login(mid, mpwd);
		if(loginInfo.getMauthcode().equals("1") ) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("loginSsInfo", loginInfo);
			response.sendRedirect(request.getContextPath()+"/main");
		} else if (loginInfo.getMauthcode().equals("0") ) {
			System.out.println("로그인 실패");
		} else {
			System.out.println("이메일을 통한 인증코드를 확인");
		}
		
	}

}












