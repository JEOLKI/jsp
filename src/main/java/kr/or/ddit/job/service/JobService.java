package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.job.dao.JobDao;
import kr.or.ddit.job.dao.JobDaoI;
import kr.or.ddit.job.model.JobVo;

public class JobService implements JobServiceI{

	@Override
	public List<JobVo> getAllJob() {
		
		JobDaoI jobDao = new JobDao();
		
		List<JobVo> jobList = jobDao.getAllJob();
		
		return jobList;
	}

}
