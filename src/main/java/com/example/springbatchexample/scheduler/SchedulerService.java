package com.example.springbatchexample.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Service
public class SchedulerService {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	@Scheduled(cron="* * * * * *")
	public String startBatch() throws Exception{
		Map<String, JobParameter> maps = new HashMap<String, JobParameter>();
		maps.put("timestamp", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);
		return "Spring Batch job "+jobExecution.getStatus();
	}
}
