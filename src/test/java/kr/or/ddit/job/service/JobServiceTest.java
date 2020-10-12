package kr.or.ddit.job.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.job.model.JobVo;

public class JobServiceTest {

	@Test
	public void getAllJobTest() {
		
		/*** Given ***/
		JobServiceI jobService = new JobService();
		
		/*** When ***/
		List<JobVo> jobList = jobService.getAllJob();
		
		/*** Then ***/
		assertEquals(19, jobList.size()); 
		
	}

}
