package kh.s0.myboard.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.board.model.BoardService;
import kh.s0.myboard.board.model.BoardVo;
import kh.s0.myboard.member.model.MemberVo;

/**
 * Servlet implementation class BoardWriteDoController
 */
@WebServlet("/board/write.do")
public class BoardWriteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 로그인이 안되어있다면 로그인 하고 글쓰기 하도록 유도함.
		MemberVo loginSsInfo = (MemberVo)request.getSession().getAttribute("loginSsInfo");
		String bwriter = null;
		if(loginSsInfo == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		} else {
			//로그인 상태라면
			bwriter = loginSsInfo.getMid();
		}
		
			
		String btitle = request.getParameter("btitle");
	    String bcontent = request.getParameter("bcontent");
//		System.out.println(btitle);
//		System.out.println(bcontent);
		
		
		BoardService service = new BoardService();
	    BoardVo vo = new BoardVo();
	    vo.setBtitle(btitle);
	    vo.setBcontent(bcontent);
	    vo.setBwriter(bwriter);
	    
	    
	    int result = service.insert(vo);
		System.out.println(result);
		if(result >0) {
			// web page로 1회성 전달 방법
			//session의 유지기간 lifecycle : 브라이져창닫힘. removeAttribute() / invalidate() contextPath단위로 + tomcat reload되면
//			request.getSession().setAttribute("result", "게시글 등록되었습니다.");
//			request.setAttribute("result", "게시글 등록되었습니다.");
			
			response.sendRedirect(request.getContextPath()+"/board/list");
		} else {
//			response.sendRedirect(request.getContextPath()+"/board/write");
			request.setAttribute("msg", "게시글 등록에 실패하였습니다. 다시 글쓰기를 시도해주세요.");
			request.getRequestDispatcher("/WEB-INF/view/error/alert.jsp").forward(request, response);
		}
	
	}

}
