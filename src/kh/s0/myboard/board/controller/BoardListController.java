package kh.s0.myboard.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.board.model.BoardService;
import kh.s0.myboard.board.model.BoardVo;
import kh.s0.myboard.member.model.MemberService;
import kh.s0.myboard.member.model.MemberVo;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardListController: ");
		
		BoardService service = new BoardService();
	    List<BoardVo> volist = service.selectList();
		System.out.println(volist);

		MemberService service2 = new MemberService();
		List<MemberVo> memberlist = service2.selectList();
		request.setAttribute("bbb", "일단 아무거나");
		
		request.setAttribute("aaa", volist);  // 데이터 전달 - forward에만 가능함
		String viewPath = "/WEB-INF/view/boardlist.jsp";  // contextPath 없이 경로 작성되어야 함.
		request.getRequestDispatcher(viewPath).forward(request, response);
		
		
		
		// 페이지 이동 방법 2가지
//		response.sendRedirect("대부분99.9/url");
//		request.getRequestDispatcher("대부분99.9/WEB-INF/view/xxx.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
