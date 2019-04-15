package com.ideal.uam.util;


import java.util.List;
/**
 * 
 * 项目名称：hibernate    
 * 类名称：Page    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017-1-9 下午7:01:00    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017-1-9 下午7:01:00    
 * 修改备注：       
 * @version
 */
public class Page {
	private Integer pagecount=5;//每页的条数
	private Integer pageNumber=1;//页数
	private Integer pagesumcount;
	private Integer pagesumNumber;
	private List list;
	private Integer strat;
	private Object obj;
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPagesumcount() {
		return pagesumcount;
	}
	public void setPagesumcount(Integer pagesumcount) {
		this.pagesumcount = pagesumcount;
	}
	public Integer getPagesumNumber() {
		return pagesumNumber;
	}
	public void setPagesumNumber(Integer pagesumNumber) {
		this.pagesumNumber = pagesumNumber;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getStrat() {
		return strat;
	}
	public void setStrat(Integer strat) {
		this.strat = strat;
	}
	public Page() {
		super();
	}
	
	public Page(Integer pagecount, Integer pageNumber, Integer pagesumcount, Integer pagesumNumber, List list,
			Integer strat, Object obj) {
		super();
		this.pagecount = pagecount;
		this.pageNumber = pageNumber;
		this.pagesumcount = pagesumcount;
		this.pagesumNumber = pagesumNumber;
		this.list = list;
		this.strat = strat;
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}