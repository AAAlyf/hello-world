package com.houxiaohui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.houxiaohui.entity.Classes;
import com.houxiaohui.service.ClassService;
import com.houxiaohui.util.PageUtil;
/**
 * 
 * 类名称：ClassController
 * 类描述： 控制层
 * 创建人：侯晓辉
 * 创建时间：2018-9-1 上午11:02:42
 * @version
 */
@Controller
@RequestMapping("/school")
public class ClassController {
	@Autowired
	private ClassService classService;
	/**
	 * 查询班级信息并分页
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("toList")
	public String toList(Model model,HttpServletRequest request,Integer pageNo){
		int pageSize = 5;
		int pageCount = 0;
		if(pageNo == null){
			pageCount = 1;
		}else{
			pageCount = pageNo;
		}
		int classListCount = classService.selectClassCount();
		PageUtil page = new PageUtil(pageCount, pageSize, classListCount, request);
		String pageStr = page.getPageString();
		List classList = classService.selectClass(pageSize,pageCount);
		List gradeList = classService.selectGrade();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("classList", classList);
		model.addAttribute("pageStr", pageStr);
		return "class/classList";
	}
	/**
	 * 添加班级
	 * @param cla
	 * @return
	 */
	@RequestMapping("/addClass")
	public String addClass(Classes classe){
		classService.addClass(classe);
		return "redirect:/school/toList";
	}
}