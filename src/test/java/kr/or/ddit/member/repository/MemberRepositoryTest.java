package kr.or.ddit.member.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVo;

public class MemberRepositoryTest extends ModelTestConfig{

	@Resource(name ="memberRepository")
	private MemberRepositoryI memberRepository;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVo> memberList = memberRepository.selectAllMember();

		/***Then***/
		assertTrue(memberList.size() > 15);
	}

}
