package cn.climbDemo.entity;

public class Keywords {

	private int id;	// 编号
	private String keyword; //关键字
	private int serchWhere;	//根据什么条件查找
	private int state; //采集状态
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getSerchWhere() {
		return serchWhere;
	}
	public void setSerchWhere(int serchWhere) {
		this.serchWhere = serchWhere;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
