package kr.or.ddit.login.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	// 서블릿객체는 스프링에서 관리하는 빈이 아니기때문에 주입받지못한다.
	// @Resource는 컨테이너 안에서만 사용이 가능하다.
	// servlet을 스프링으로 등록하지도 못한다 서블릿은 톰켓에서 관리하기때문에
	// 일반적인 방법으로는 가능하지 않다.
	@Resource(name="boardService")
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		// service 객체 생성
	}
	
	
	// login 화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet doGet");
		logger.debug("UNT_CD parameter : {}", request.getParameter("UNT_CD"));
		
		request.getRequestDispatcher("/").forward(request, response);
		
		// 서블릿의 이름으로 도 가능
		//request.getServletContext().getNamedDispatcher("default").forward(request, response);
		// 서버에게 위임하는것
		// 서버마다 디폴트 서블릿의 이름이 다르다.
	}


	

}
