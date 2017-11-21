package com.kzvance.httpdemo.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kzvance.httpdemo.bean.GreetingService;
import com.kzvance.httpdemo.bean.RequestPOJO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
public class IGreetingController {
	@Autowired
	private GreetingService gService;
	@ApiOperation(response = RequestPOJO.class, value = "${summary.greeting}")
	@RequestMapping( value="/greeting", method=RequestMethod.POST, produces="application/json")
	public Greeting getGreeting(@ApiParam(value = "Name for greeting", required = true) @RequestBody RequestPOJO req	){
		gService.setReq(req);
		return gService.getMyGreeting();
	}
}