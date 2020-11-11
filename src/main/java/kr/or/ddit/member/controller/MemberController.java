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
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.JSRMemberVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.MemberVoValidator;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping(path = "/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String getView(Model model,
						  @RequestParam(name="page", defaultValue = "1", required = false) int page,
						  @RequestParam(name="pageSize", defaultValue = "5", required = false ) int pageSize) {
		
		// pageVo : page, pageSize
		PageVo pageVo = new PageVo(page, pageSize);
		
		//memberService.selectMemberPageList(page) => List<MemberVo> => Map<String,Object>
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		//return "member/memberList";
		return "tiles/member/memberListContent"; // list
	}
	
	@RequestMapping("/listAjaxPage")
	public String listAjaxPage() {
		return "tiles/member/listAjaxPage";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjax")
	public String listAjax(PageVo pageVo, Model model) {
		logger.debug("pageVo : {}", pageVo);
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		// 커맨드객체인 pageVo는 자동으로 model속성에 추가됨
		return "jsonView";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjaxHTML")
	public String listAjaxHTML(PageVo pageVo, Model model) {
		logger.debug("pageVo : {}", pageVo);
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		// 커맨드객체인 pageVo는 자동으로 model속성에 추가됨
		
		// 응답을 html => jsp로 생성
		return "member/listAjaxHTML"; // 일부분이기때문에 tiles아님
	}
	
	
	
	@RequestMapping("/member")
	public String getMember(Model model, String userid) {
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		return "tiles/member/member";
	}
	
	@RequestMapping("/memberAjaxPage")
	public String getMemberAjaxPage() {
		return "tiles/member/memberAjaxPage";
	}
	
	@RequestMapping("/memberAjax")
	public String getMemberAjax(Model model, String userid) {
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		return "jsonView";
	}
	
	@RequestMapping(path = "/regist" , method = {RequestMethod.GET})
	public String regist() {
		return "tiles/member/memberRegist";
	}
	
	
	@RequestMapping(path = "/regist" , method = {RequestMethod.POST})
	public String regist(@Valid MemberVo memberVo, BindingResult br, MultipartFile file) {
		
		// validation
		//new MemberVoValidator().validate(memberVo, br);
		
		// 검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "tiles/member/memberRegist";
		}
		
		String filePath = "";
		String realFilename = "";
		if( file.getSize() > 0 ) {
			String filename = UUID.randomUUID().toString();
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
		
		// 사용자 정보 등록
		memberVo.setFilename(filePath);
		memberVo.setRealFilename(realFilename);
		
		int insertCnt = 0;
		try {
			insertCnt = memberService.insertMember(memberVo);

			// 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
			if ( insertCnt == 1 ) {
				return "redirect:/member/list";
			} 
		} catch (Exception e) {
		}
		
		// 1건이 아닐때 : 비정상
		return "tiles/member/memberRegist";
	}
	
	@RequestMapping(path = "/update", method = {RequestMethod.GET} )
	public String update(Model model, String userid) {
		
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "tiles/member/memberUpdate";
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
