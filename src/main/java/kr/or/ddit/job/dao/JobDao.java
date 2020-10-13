package kr.or.ddit.job.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.job.model.JobVo;

public class JobDao implements JobDaoI{

	@Override
	public List<JobVo> getAllJob() {

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<JobVo> jobList = sqlSession.selectList("job.getALlJob");
		
		sqlSession.close();
		
		return jobList;
	}

}
