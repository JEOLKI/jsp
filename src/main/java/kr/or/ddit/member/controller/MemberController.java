package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping(path = "/list")
	public String getView(Model model,
						  @RequestParam(defaultValue = "1" ) int page,
						  @RequestParam(defaultValue = "5" ) int pageSize) {
		
		// page
		model.addAttribute("page", page);
		
		// pageSize
		model.addAttribute("pageSize", pageSize);
		
		// pageVo : page, pageSize
		PageVo pageVo = new PageVo(page, pageSize);
		
		//memberService.selectMemberPageList(page) => List<MemberVo> => Map<String,Object>
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "member/memberList";
	}
	
	@RequestMapping("/member")
	public String getMember(Model model, String userid) {

		MemberVo memberVo = memberService.getMember(userid);
		
		model.addAttribute("memberVo", memberVo);
		
		return "member/member";
		
	}
	
	@RequestMapping("/profileImg")
	public String profileImg(String userid, HttpServletResponse response) throws Exception {
		
		//response content-type
		response.setContentType("image/png");
		
		// 사용자 아이디 파라미터 확인하고
		
		// db에서 사용자 filename 확인하고
		MemberVo memberVo = memberService.getMember(userid);
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일을 읽고
		// 응답 생성
		// memberVo.getFilename(); // 파일경로

		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}
	
		fis.close();
		sos.flush();
		sos.close();
		
		return "";
	}
	
	@RequestMapping(path = "/profileDownload")
	public String profileDownload(String userid, HttpServletResponse response) throws Exception {
		
		// db에서 사용자 filename 확인하고
		MemberVo memberVo = memberService.getMember(userid);
		
		//response content-type
		response.setHeader("Content-Disposition", "attachment; filename=\""+ memberVo.getRealFilename() + "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일을 읽고
		// 응답 생성
		// memberVo.getFilename(); // 파일경로

		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}
	
		fis.close();
		sos.flush();
		sos.close();
		
		return "";
	}
	
	
	@RequestMapping(path = "/regist" , method = {RequestMethod.GET})
	public String regist() {
		return "member/memberRegist";
	}
	
	@RequestMapping(path = "/regist" , method = {RequestMethod.POST})
	public String regist(MemberVo memberVo, MultipartFile file) {
		
		String filename = UUID.randomUUID().toString();
		
		String filePath = "";
		String realFilename = "";
		if( file.getSize() > 0 ) {
			realFilename = file.getOriginalFilename();
			String extension = FileUploadUtil.getExtension(realFilename);
			File uploadFile = new File("D:\\profile\\" + filename + "." + extension);
			filePath = "D:\\profile\\" + filename + "." + extension;
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		memberVo.setFilename(filePath);
		memberVo.setRealFilename(realFilename);
		
		int insertCnt = memberService.insertMember(memberVo);
		
		// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if ( insertCnt == 1 ) {
			return "redirect:/member/list";
		} 
		// 1건이 아닐때 : 비정상
		else {
			return "member/memberRegist";
		}
	}
	
	@RequestMapping(path = "/update", method = {RequestMethod.GET} )
	public String update(Model model, String userid) {
		
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberUpdate";
	}
	
	@RequestMapping(path = "/update", method = {RequestMethod.POST})
	public String update(MemberVo memberVo, MultipartFile file, RedirectAttributes ra ) {
		
		String realFilename= "";
		String filePath ="";
		String fileCheck = file.getOriginalFilename();
		if(!fileCheck.equals("")) {
			
			realFilename = file.getOriginalFilename();
			String filename = UUID.randomUUID().toString();
			String extension = FileUploadUtil.getExtension(realFilename);
			
			if( file.getSize() > 0 ) {
				File uploadFile = new File("D:\\profile\\" + filename + "." + extension);
				filePath = "D:\\profile\\" + filename + "." + extension;
				
				try {
					file.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			MemberVo dbMember = memberService.getMember(memberVo.getUserid());
			realFilename = dbMember.getRealFilename();
			filePath = dbMember.getFilename();
		}
		
		memberVo.setFilename(filePath);
		memberVo.setRealFilename(realFilename);
		
		logger.debug("orginal file : {}, {}", filePath, realFilename);
		
		ra.addAttribute("userid", memberVo.getUserid());
		
		// 사용자 정보 등록
		int updateCnt = memberService.updateMember(memberVo);
		
		// 1건이 입력되었을 때 : 정상 - member 페이지로 이동
		if ( updateCnt == 1 ) {
			return "redirect:/member/member";
		} 
		// 1건이 아닐때 : 비정상
		else {
			return "redirect:/member/update";
		}
	}
	
	
	
	
}
