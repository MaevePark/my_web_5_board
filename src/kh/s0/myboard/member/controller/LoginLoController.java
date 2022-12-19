package kh.s0.myboard.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.s0.myboard.member.model.MemberService;
import kh.s0.myboard.member.model.MemberVo;
import kh.s0.myboard.member.model.TestJsonVo;

/**
 * Servlet implementation class LoginLoController
 */
@WebServlet("/login.lo")
public class LoginLoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서는 response.sendRedirect  / request.getRequestDispatcher(path).forward(); 사용불가
		//ajax 경우는 페이지이동 코드 작성하면 안됨!
		//ajax 경우는 데이터전달 가능함.
		PrintWriter out = response.getWriter();
//				out.append("a");
//				out.println("b");
		
		Gson gson = new Gson();
		
//		BufferedReader br = request.getReader();
		String requestData = request.getReader().readLine();
//		System.out.println(requestData);
		// gson 예전 버젼에서 제공되던 방식 ArrayList<TestJsonVo> testjsonlist = gson.fromJson(requestData, new TypeToken<ArrayList<TestJsonVo>>.getClass());
//		TestJsonVo[] testjsonArray = gson.fromJson(requestData, TestJsonVo[].class);
//		for(TestJsonVo vo : testjsonArray) {
//			System.out.println(vo);
//		}
//		System.out.println(testjsonArray);
		List<TestJsonVo> testjsonlist = Arrays.asList(gson.fromJson(requestData, TestJsonVo[].class));
		
//		TODO 임시 - json test를 위해서
		String mid = "user1";
		String mpwd = "user1";
//		String mid = request.getParameter("mid2");
//		String mpwd = request.getParameter("mpwd2");
		
		MemberService service = new MemberService();
		MemberVo loginInfo = service.login(mid, mpwd);
		if(loginInfo == null) {
			System.out.println("로그인 실패. id/pw 다시 확인하고 로그인해주세요");
//			out.println("fail");
		} else {
			if(loginInfo.getMauthcode().equals("1") ) {
				System.out.println("로그인 성공");
				request.getSession().setAttribute("loginSsInfo", loginInfo);
//				out.println("OK");				
			} else if (loginInfo.getMauthcode().equals("0") ) {
				System.out.println("로그인 인증전");
//				out.println("authcode0");
			} else {
				System.out.println("이메일을 통한 인증코드를 확인");
//				out.println("authcode1");
			}
		}
		
		String result = gson.toJson(loginInfo);
		System.out.println(result);
		
		out.println(result);
		
		out.flush();
		out.close();
	}

}
