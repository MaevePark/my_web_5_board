package first.loginSv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import first.loginSv.wrapper.LoginWrapper;

public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String pwd1 = request.getParameter("pwd");

		HttpServletRequest h_request = (HttpServletRequest) request;

		request.setAttribute("pwdChk", h_request.getParameter("pwd")); // 기존 입력된 pwd를 이름은 pwdChk라는 attribute에 잠시 저장함.
		LoginWrapper lw = new LoginWrapper(h_request); // h_request 는 request.getParameter("pwd") 을 포함한 상태임. -- 이걸 가지고
														// 암호화 수행
		chain.doFilter(lw, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter.init() 호출");
	}
}
