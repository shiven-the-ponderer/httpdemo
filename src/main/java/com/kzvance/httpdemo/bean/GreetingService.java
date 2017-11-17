package com.kzvance.httpdemo.bean;

import org.springframework.stereotype.Service;

import com.kzvance.httpdemo.greeting.Greeting;

@Service
public class GreetingService {
	 
	private RequestPOJO req;
	
	public Greeting getMyGreeting (){
		Greeting msg=new Greeting();
		msg.setGreetingStr("Hello " +req.getFirstName()+" "+req.getLastName());
		return msg;
	}

	public RequestPOJO getReq() {
		return req;
	}

	public void setReq(RequestPOJO req) {
		this.req = req;
	}	
}
