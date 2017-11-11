package com.kzvance.httpdemo.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kzvance.httpdemo.bean.GreetingService;
import com.kzvance.httpdemo.bean.RequestPOJO;


@RestController
public class iGreetingController {
	@Autowired
	private GreetingService gService;
	
	@RequestMapping("/greeting")
	public String getGreeting(@RequestBody RequestPOJO req	){
		gService.setReq(req);
		return gService.getMyGreeting();
	}
}