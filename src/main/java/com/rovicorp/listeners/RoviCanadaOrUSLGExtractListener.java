package com.rovicorp.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class RoviCanadaOrUSLGExtractListener implements StepExecutionListener {
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		if(stepExecution.getJobExecution().getJobParameters().getParameters().containsKey("headendsList")) {
			return new ExitStatus("HEADEND");
		}
		return new ExitStatus("ZIPCODE");
	}
}

