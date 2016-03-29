package com.rovicorp.tasklets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.rovicorp.mbeans.JobStatusMbean;
import com.rovicorp.mbeans.MbeansResetter;

public class LGExtractBootStrapTasklet extends BootStrapTasklet {
    private ApplicationContext applicationContext;
    @Autowired
    JobStatusMbean jobStatusMbean;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                    this.applicationContext = applicationContext;
    }

    @Override
    public void resetMbeans() {
                    Map<String, MbeansResetter> allMbeans = applicationContext.getBeansOfType(MbeansResetter.class);
                    List<String> jobStatus = new ArrayList<String>();
                    jobStatus.addAll(jobStatusMbean.getJobStatus());
                    for(MbeansResetter mbr:allMbeans.values()){
                                    mbr.reset();
                    }
                    if(jobStatus.size() > 0)
                                    jobStatusMbean.getJobStatus().add(jobStatus.get(jobStatus.size()-1));
    }

}
