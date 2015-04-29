package exam_vo.system;

import exam_entity.sys.ExamSysUser;

public class ExamSysUserVo extends ExamSysUser{

	private String sex_name; 
	private String status_name;
	private String role_name;
	private String department_name;
	private String department_type_name;
	
	private String company_name;
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDepartment_type_name() {
		return department_type_name;
	}
	public void setDepartment_type_name(String department_type_name) {
		this.department_type_name = department_type_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getSex_name() {
		return sex_name;
	}
	public void setSex_name(String sex_name) {
		this.sex_name = sex_name;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}; 
}
