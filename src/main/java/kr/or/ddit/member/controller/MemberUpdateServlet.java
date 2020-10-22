package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
    
	MemberServiceI memberService;
	MemberVo memberVo;
	String filePath;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");	
		
		memberVo = memberService.getMember(userid);
		filePath = memberVo.getFilename();
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String realFilename = request.getParameter("org_realFilename");
		
		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFilename");
		logger.debug("file : {}",profile.getHeader("Content-Disposition"));
		
		String fileCheck = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		if(!fileCheck.equals("")) {
			
			realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String filename = UUID.randomUUID().toString();
			String extension = FileUploadUtil.getExtension(realFilename);
			
			if( profile.getSize() > 0 ) {
				filePath = "D:\\profile\\" + filename + "." + extension;
				profile.write(filePath);
			}
		}
		
		logger.debug("orginal file : {}, {}", filePath, realFilename);
		
		// 사용자 정보 등록
		memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFilename);
		
		int updateCnt = memberService.updateMember(memberVo);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( updateCnt == 1 ) {
			response.sendRedirect(request.getContextPath() + "/member?userid=" + memberVo.getUserid());
		} 
		// 1건이 아닐때 : 비정상
		else {
			doGet(request, response);
		}
		
	}

}
