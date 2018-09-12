package com.houxiaohui.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 *@className:PageUtil.java
 *@discription:通用分页工具类
 *@createTime:2018-5-23上午10:28:51
 *@author:zz
 *@version:1.0.0
 */
public class PageUtil {

	//分页的要素
	private int pageNo;//第几页（页码）
	private int pageSize;//每页显示数量
	private int totalCount;//总数量
	//其他，两个方法共用，所以声明为类变量
	private String url;//请求地址
	private String pageString;//最终封装好的分页地址
	/**
	 * 带参构造函数
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param request
	 */
	public PageUtil(int pageNo,int pageSize,int totalCount,HttpServletRequest request){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.totalCount=totalCount;
		//获取请求地址（后面拼接?，方便后拼参数）
		url = request.getRequestURI()+"?"; // /webdemo-20180523/servlet/UserShowServlet
		//获取请求携带所有参数名称(不管是get提交或者是post提交) 假如：aaa=111&bbb=222&ccc=333
		Enumeration<String> parameterNames = request.getParameterNames();//[aaa,bbb,ccc]
		//遍历
		while(parameterNames.hasMoreElements()){
			//获取每一个请求参数的名称
			String parameterName = parameterNames.nextElement();
			if(!"pageNo".equals(parameterName)){//判断所有参数有没有pageNo,当没有pageNo把其他参数拼接
				if(url.charAt(url.length()-1)=='?'){//判断url最后一个字符是否是?  charAt返回字符串任意位置的字符
					url+=parameterName+"="+request.getParameter(parameterName);//拼接参数，判断是拼接?还是&
				}else{
					url+="&"+parameterName+"="+request.getParameter(parameterName);//拼接参数，判断是拼接?还是&
				}
			}
		}
		//如果拼接的结果不带？,最后添加一个&
		if(url.charAt(url.length()-1)!='?'){
			url+="&";
		}
	}
	
	
	/**
	 * 获取封装后的分页字符串
	 * @return
	 */
	public String getPageString() {
		StringBuffer stringBuffer = new StringBuffer();
		//计算最大页   21  5   21%5=1  21/5=4+1=5   20 5 20%5=0 20/5=4
		int maxPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		//页数不能小于1
		if(pageNo<1){
			pageNo=1;
		}
		//页数不能大于最大页
		if(pageNo>maxPage){
			pageNo=maxPage;
		}
		//如果是第一页，首页和上一页就不能再点
		if(pageNo==1||pageNo==0){
			stringBuffer.append("首页&nbsp;上一页&nbsp;");
		}else{
		    stringBuffer.append("<a href='"+url+"pageNo=1'>首页</a>&nbsp;<a href='"+url+"pageNo="+(pageNo-1)+"'>上一页</a>&nbsp;");
		}
		//如果是最后一页
		if(pageNo==maxPage){
			stringBuffer.append("下一页&nbsp;尾页");
		}else{
			stringBuffer.append("<a href='"+url+"pageNo="+(pageNo+1)+"'>下一页</a>&nbsp;<a href='"+url+"pageNo="+maxPage+"'>尾页</a>");
		}
		//拼接选择页
		stringBuffer.append("&nbsp;<select style='display:inline;' onchange='javascript:location.href=\""+url+"pageNo=\"+this.value'>");
		   for(int i=1;i<=maxPage;i++){
			   if(i==pageNo)//判断当前页和下拉里面值是否相等，相等说明是当前页，让它选中
			       stringBuffer.append("<option selected='selected'  value='"+i+"'>"+i+"</option>");
			   else
				   stringBuffer.append("<option  value='"+i+"'>"+i+"</option>"); 
		   }
		stringBuffer.append("</select>");
		//拼接总页数，总数量
		stringBuffer.append("&nbsp;共"+totalCount+"条&nbsp;共"+maxPage+"页");
		return stringBuffer.toString();
	}
	
}
