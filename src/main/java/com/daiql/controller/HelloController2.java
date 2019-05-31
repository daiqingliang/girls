package com.daiql.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

/**
 * 现在模板渲染已经过时，太耗费资源，了解一下
 * @author xinxihua
 *
 */

//@RestController
@Controller
public class HelloController2 {

//	@Autowired
//	private GirlProperties girlProperties;
	
	@Value("${cupSize}")
	private String cupSize;
	
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public String say() {
//		return "Hello Spring Boot!";
//		return girlProperties.getCupSize() + "--" + cupSize;
		return "index";
	}
	
}
