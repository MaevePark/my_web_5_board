package first.loginSv.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class LoginWrapper extends HttpServletRequestWrapper{

	public LoginWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if(name !=null && name.equals("pwd")) {
			name = getSha512(super.getParameter(name));   // SHA-512 암호화 메소드
		} else {
			// 암호화할 pwd라는 것에 아무 데이터가 없음.
			name = super.getParameter(name);
		}
		return name;
	}
	
	private static String getSha512(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			return Base64.getEncoder().encodeToString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
