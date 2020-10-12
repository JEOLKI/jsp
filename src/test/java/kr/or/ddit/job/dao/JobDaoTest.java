package kr.or.ddit.job.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.job.model.JobVo;

public class JobDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(JobDaoTest.class);

	@Test
	public void getAllJobTest() {
		
		/*** Given ***/
		JobDaoI jobDao = new JobDao();
		
		/*** When ***/
		List<JobVo> jobList = jobDao.getAllJob();
		
		/*** Then ***/
		assertEquals(19, jobList.size()); 
		
	}

}
