package com.daiql.repository;

import java.util.List;

import com.daiql.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xinxihua
 * @date: 2018年9月3日下午2:53:47
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{

	//通过年龄来查询
	public List<Girl> findByAge(Integer age);
}
