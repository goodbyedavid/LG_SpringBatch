package com.rovicorp.process;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import com.rovicorp.utils.RoviJobUtil;


public class LGExtract {
 
	private static final Logger logger = LoggerFactory.getLogger(LGExtract.class);
  
	public static void main(String[] args) throws Exception{
		String[] springConfig = { "lgExtract-job.xml"};
		if(args != null && args.length > 0 && args[0] != null) {
			try {
				int startInMins = Integer.parseInt(args[0]);
				if(args.length == 2) {
					logger.info("Application started with Mins and list of ZipCodes parameters. Job will start in {} mins for these Zip Codes {}. Job will go to routine schedule after this run.", args[0], args[1]);
					String[] zipCodes = StringUtils.split(args[1], "|");
					ArrayList<String> listOfZipCodes = new ArrayList<String>(Arrays.asList(zipCodes));
					RoviJobUtil.multiRunNowForSpecificList(springConfig, "lgExtract-job", startInMins, listOfZipCodes, "zipcode");
				} else if(args.length == 1) {
					logger.info("Application started with Mins parameter. Job will start in {} mins. Job will go to routine schedule after this run.", args[0]);
					RoviJobUtil.multiRunNow(springConfig, "lgExtract-job", startInMins);
				}
			} catch(NumberFormatException e) {
				logger.info("The provided input {} is not a number. Starting job will regular schedule.", args[0]);
				RoviJobUtil.run(springConfig);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw e;
			} catch (JobExecutionAlreadyRunningException e) {
				e.printStackTrace();
				throw e;
			} catch (JobRestartException e) {
				e.printStackTrace();
				throw e;
			} catch (JobInstanceAlreadyCompleteException e) {
				e.printStackTrace();
				throw e;
			}
		} else {
			RoviJobUtil.run(springConfig);
			logger.info("Job started as per the regular schedule.");
		}
	}

}
