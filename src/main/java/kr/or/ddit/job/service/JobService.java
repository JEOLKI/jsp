package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.job.dao.JobDao;
import kr.or.ddit.job.dao.JobDaoI;
import kr.or.ddit.job.model.JobVo;

public class JobService implements JobServiceI {

	private JobDaoI jobDao;

	public JobService() {

		jobDao = new JobDao();

	}

	@Override
	public List<JobVo> getAllJob() {

		List<JobVo> jobList = jobDao.getAllJob();

		return jobList;
	}

}
