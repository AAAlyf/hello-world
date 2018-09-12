package com.houxiaohui.entity;
/**
 * 
 * 类名称：Grade
 * 类描述：年级实体类 
 * 创建人：zhangyong
 * 创建时间：2018-9-1 上午10:20:27
 * @version
 */
public class Grade {
	private Integer gradeId;//主键id
	private String gradeName;//年级名称
	private String remark;//年级备注
	
	
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
