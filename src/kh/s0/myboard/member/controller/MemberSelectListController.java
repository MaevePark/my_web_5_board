package kh.s0.myboard.member.controller;

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
 * Servlet implementation class MemberSelectListController
 */
@WebServlet("/MemberSelectListController")
public class MemberSelectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberSelectListController: ");
		MemberService service = new MemberService();
	    List<MemberVo> volist = service.selectList();
		System.out.println(volist);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
