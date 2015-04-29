package exam_entity.base;

/**
 * ExamBaseRole entity. @author MyEclipse Persistence Tools
 */

public class ExamBaseRole implements java.io.Serializable {

	// Fields

	private Long role_id;
	private String role_name;
	private String remark;

	// Constructors

	/** default constructor */
	public ExamBaseRole() {
	}

	/** minimal constructor */
	public ExamBaseRole(String role_name) {
		this.role_name = role_name;
	}

	/** full constructor */
	public ExamBaseRole(String role_name, String remark) {
		this.role_name = role_name;
		this.remark = remark;
	}

	// Property accessors

	public Long getRole_id() {
		return this.role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return this.role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}