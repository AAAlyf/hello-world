package com.houxiaohui.service;

import java.util.List;

import com.houxiaohui.entity.Classes;

public interface ClassService {

	int selectClassCount();

	List selectClass(int pageSize, int pageCount);

	List selectGrade();

	void addClass(Classes classe);


	

}
