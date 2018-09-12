package com.houxiaohui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.houxiaohui.dao.ClassDao;
import com.houxiaohui.entity.Classes;
import com.houxiaohui.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;

	public int selectClassCount() {
		return classDao.selectClassCount();
	}

	public List selectClass(int pageSize, int pageCount) {
		Map map = new HashMap(); 
		map.put("pageSize", pageSize);
		map.put("pageStart", (pageCount-1)*pageSize);
		return classDao.selectClass(map);
	}

	public List selectGrade() {
		return classDao.selectGrade();
	}

	public void addClass(Classes classe) {
		classDao.addClass(classe);
	}

}
