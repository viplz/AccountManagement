package com.exam.model;


/**查询参数
 * @author HR-LZ
 *
 */
public class QueryParam {

	private String userCode;//编码(模糊)
	private String userName;//名称(模糊)
	private String createAt;//注册时间（起始-截止）
	private String createBeginAt;//注册时段（开始时间）
	private String createEndAt;//注册时段（结束时间）
	private Integer userType;//账户类型
	
	private int draw;
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateBeginAt() {
		return createBeginAt;
	}
	public void setCreateBeginAt(String createBeginAt) {
		this.createBeginAt = createBeginAt;
	}
	public String getCreateEndAt() {
		return createEndAt;
	}
	public void setCreateEndAt(String createEndAt) {
		this.createEndAt = createEndAt;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	
}
