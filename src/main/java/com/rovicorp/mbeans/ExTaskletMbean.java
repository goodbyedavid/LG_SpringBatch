package com.rovicorp.mbeans;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
/*Example mbean. Mbeans are for monitoring. Monitoring can be done from nagios*/
@Component
@ManagedResource(objectName="com.rovicorp.mbeans:name=ImagesCopied", description="ImagesCopied: Copies Images from RichMedia server...")
public class ExTaskletMbean {
	boolean isDiskFull=false;
	public boolean isDiskFull(){
		return isDiskFull;
	}
	public void setIsDiskFull(boolean full){
		this.isDiskFull=full;
	}

}
