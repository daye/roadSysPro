package exam_vo.examinee;

import exam_entity.backstage.ExamineeQtRel;

public class ExamineeQtRelVo extends ExamineeQtRel {

	private String username;
	private String qtname;
	private String asname;
	private String asno;
	private String rigtasname;
	private String qtstatusname;
	public String getQtstatusname() {
		return qtstatusname;
	}
	public void setQtstatusname(String qtstatusname) {
		this.qtstatusname = qtstatusname;
	}
	public String getRigtasname() {
		return rigtasname;
	}
	public void setRigtasname(String rigtasname) {
		this.rigtasname = rigtasname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	public String getAsno() {
		return asno;
	}
	public void setAsno(String asno) {
		this.asno = asno;
	}
	
}