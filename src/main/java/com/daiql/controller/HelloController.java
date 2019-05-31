package com.daiql.controller;

import com.daiql.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private GirlProperties girlProperties;
	
	@Value("${cupSize}")
	private String cupSize;

//	@RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
//  method = RequestMethod.POST 不写的时候，get和post都可以
	@GetMapping(value = {"/hello","/hi"})
	public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		return girlProperties.getCupSize() + "--" + cupSize + "--ID:" + id;
	}

}
