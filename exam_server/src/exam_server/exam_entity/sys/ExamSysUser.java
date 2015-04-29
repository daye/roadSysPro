package exam_entity.sys;

/**
 * ExamSysUser entity. @author MyEclipse Persistence Tools
 */

public class ExamSysUser implements java.io.Serializable {

	// Fields

	private Long user_id;
	private String user_name;
	private String user_code;
	private Integer sex;
	private Long role_id;
	private String department_type;
	private String department_id;
	private String telephone;
	private String mobile;
	private String email;
	private String msn;
	private String qq;
	private Integer status;
	private String password;

	private String company;
	// Constructors


	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_code() {
		return this.user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getRole_id() {
		return this.role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getDepartment_type() {
		return department_type;
	}

	public void setDepartment_type(String department_type) {
		this.department_type = department_type;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}