package kr.or.ddit.member.repository;

import kr.or.ddit.member.model.MemberVo;

public interface MemberRepositoryI {
	
	MemberVo getMember(String userId);

}
