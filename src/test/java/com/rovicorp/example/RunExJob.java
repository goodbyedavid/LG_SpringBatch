package com.rovicorp.example;


import junit.framework.Assert;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 
 * @author akupinski
 * This is a very simple example test case how to use the framework.
 * Located in the test-ex-job.xml are all the bean definitions and the job flow. 
 */
@ContextConfiguration(locations={"classpath:test-ex-job.xml"})
public class RunExJob extends AbstractTestNGSpringContextTests{
	@Autowired
	  private JobLauncherTestUtils jobLauncherTestUtils;
	
  @Test
  public void launchExTestJob() throws Exception{
	  JobExecution jobExecution=jobLauncherTestUtils.launchJob();
	  Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
  }
  
 

}
