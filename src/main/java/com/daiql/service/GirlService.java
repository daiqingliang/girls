package com.daiql.service;

import javax.transaction.Transactional;

import com.daiql.domain.Girl;
import com.daiql.enums.ResultEnum;
import com.daiql.exception.GirlException;
import com.daiql.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinxihua
 * @date: 2018年9月3日下午3:48:21
 * 测试事务
 */
@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(18);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("BBBB");
		girlB.setAge(20);
		girlRepository.save(girlB);
	}

	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if (age < 10) {
			//你还在上小学
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if (age > 10 && age < 16) {
			//你可能在上初中
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}

	/**
	 * 通过ID查询一个女生信息返回
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id) {
		return girlRepository.findOne(id);
	}
}
