package first.member.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = (String)event.getSession().getAttribute("name");
		System.out.println(event.getSession().getServletContext().toString());
		System.out.println(name+"님이 접속하셨습니다.");		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(se.getSession().getServletContext().toString());
		System.out.println(se.getSession().getId() + "세션이 생성되었습니다.");	
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(se.getSession().getServletContext().toString());
		System.out.println(se.getSession().getId() + "세션이 파괴되었습니다.");	
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = (String)event.getSession().getAttribute("name");
		System.out.println(event.getSession().getServletContext().toString());
		System.out.println(name+" attribute이 Removed");	
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = (String)event.getSession().getAttribute("name");
		System.out.println(event.getSession().getServletContext().toString());
		System.out.println(name+" attribute이 Replaced");	
	}
}
