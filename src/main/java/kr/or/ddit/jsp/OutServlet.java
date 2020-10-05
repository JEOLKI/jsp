package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.range.service.RangerService;
import kr.or.ddit.range.service.RangerServiceI;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/outServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ranger 정보 조회
		RangerServiceI rangerService = new RangerService();
		
		// ranger 정보를 화면에 표현해줄 out.jsp 파일로 응답 생성을 위임
		// ranger 정보가 어딘가 담겨야 함
		// servlet 에서는 3가지 scope가 사용가능
		// request< session < application
		// 해당 요청은 일회성으로만 처리해주면 레인저 이름 정보를 보관할 필요가 없고
		// 다른 요청과 관련이 없으므로 request 적당하다
		
		// servlet 상에서 작성할 코드
		// request 객체에 rangers라는 속성 이름으로 레인저 정보를 저장

		// 1 : 불필요한 메모리 사용, 1번 보다는 2번 방법을 사용한다.
		// List<String> rangers = new ArrayList<String>();
		// rangers = reangerService.getRanger();
		// Heap 영역에 메모리가 남아 있기 때문에 효율적이지 않은 코드이다. 메모리 공간을 만들지 않고 사용하는것이 좋다.
		
		// 2
		List<String> rangers = rangerService.getRangers();
		request.setAttribute("rangers", rangers);
		
		// out.jsp(아직 안만듬 webapp/jsp/out.jsp에 생성)로 요청 위임 (forward)
		request.getRequestDispatcher("/jsp/out.jsp").forward(request, response);
		
		// out.jsp에서는 rangers라는 속성을 꺼내서 loop를 돌며 화면에 출력
		// ***out 객체를 이용
		
		
	}

}
