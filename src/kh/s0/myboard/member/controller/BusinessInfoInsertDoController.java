package kh.s0.myboard.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.member.model.BusinessInfoService;
import kh.s0.myboard.member.model.BusinessInfoVo;

/**
 * Servlet implementation class BusinessInfoInsertController
 */
@WebServlet("/BusinessInfoInsertDoController")
public class BusinessInfoInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessInfoInsertDoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BusinessInfoInsertDoController");
		
		BusinessInfoVo vo = new BusinessInfoVo();
		
		BusinessInfoService service = new BusinessInfoService();
		int result = service.insert(vo);
		System.out.println("result");
	}

}
