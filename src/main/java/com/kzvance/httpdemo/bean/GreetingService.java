package com.kzvance.httpdemo.bean;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	 
	private RequestPOJO req;
	
	public String getMyGreeting (){
		return "Hello " +req.getFirstName()+" "+req.getLastName();
	}

	public RequestPOJO getReq() {
		return req;
	}

	public void setReq(RequestPOJO req) {
		this.req = req;
	}	
}
