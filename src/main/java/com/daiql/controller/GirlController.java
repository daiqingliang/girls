package com.daiql.controller;

import java.util.List;

import com.daiql.domain.Girl;
import com.daiql.domain.Result;
import com.daiql.repository.GirlRepository;
import com.daiql.service.GirlService;
import com.daiql.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author xinxihua
 * @date: 2018年9月3日下午2:59:08
 */

@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;

	/**
	 * 返回所有女生列表
	 * @return list
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}
	
	/**
	 * 添加一个女生
	 * @param girl
	 * @return Girl
	 */
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
//		girl.setCupSize(girl.getCupSize());
//		girl.setAge(girl.getAge());
		return ResultUtil.success(girlRepository.save(girl));
	}
	//查询一个女生
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}
	
	//更新
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
			@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	
	//通过年龄查询女生列表
	@GetMapping(value = "girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}
	
	@PostMapping(value = "/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}

	@GetMapping(value = "girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
