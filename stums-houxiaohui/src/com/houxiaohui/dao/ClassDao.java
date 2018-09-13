package com.houxiaohui.dao;

import java.util.List;
import java.util.Map;

import com.houxiaohui.entity.Classes;

public interface ClassDao {

	int selectClassCount();

	List selectClass(Map map);

	List selectGrade();

	void addClass(Classes classe);

	list selectClass01(Map map);
}
