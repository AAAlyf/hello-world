package com.houxiaohui.entity;
/**
 * 
 * 类名称：Class
 * 类描述：班级实体类 
 * 创建人：zhangyong
 * 创建时间：2018-9-1 上午10:22:19
 * @version
 */
public class Classes {
	private Integer classId;//主键id
	private String className;//班级名称
	private Integer classSize;//班级人数
	private Integer gradeId;//所属年级id
	private String remark;//班级备注
	
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getClassSize() {
		return classSize;
	}
	public void setClassSize(Integer classSize) {
		this.classSize = classSize;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
