package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(LogoutServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// session.setMaxInactiveInterval(0); // mean inactive immediately
		
		request.getSession().invalidate();
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
