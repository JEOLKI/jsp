package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.job.model.JobVo;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.job.service.JobServiceI;

@WebServlet("/jobList")
public class JobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(JobListServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JobServiceI jobService = new JobService();
		
		List<JobVo> jobList = jobService.getAllJob();
		
		request.setAttribute("jobList", jobList);
		
		logger.debug(jobList.get(0).toString());
		
		request.getRequestDispatcher("job/jobList.jsp").forward(request, response);
	
	}


}
