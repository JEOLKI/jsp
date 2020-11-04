package kr.or.ddit.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.repository.MemberRepositoryI;

@Service("memberService")
public class MemberService implements MemberServiceI {

	@Resource(name = "memberRepository")
	private MemberRepositoryI memberRepository;

	public MemberService() {
		// new 연산자가 아닌 빈을 주입하는 형태로 사용하기 위해서 지운다
		// new MemberRepository();
	}

	@Override
	public MemberVo getMember(String userId) {
		return memberRepository.getMember(userId);
	}

}
