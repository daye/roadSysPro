package exam_vo.system;

public class QueryExamSysUserVo implements java.io.Serializable{

	private String user_name;
	private Long role_id;
	private Long department_id;
	private Integer status;
	private String company;
	
	private String usercode;
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
