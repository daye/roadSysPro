package exam_vo.backstage;

import exam_entity.backstage.AnswerQtRel;

public class AnswerQtRelVo extends AnswerQtRel {

	private String qtsubject;
	private String qttype;
	private String as_str;
	private String asnostr;
	private String qtname;
	private String qtsubject_name;
	private String qttype_name;
	private String status_name;
	public String getAsnostr() {
		return asnostr;
	}
	public void setAsnostr(String asnostr) {
		this.asnostr = asnostr;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getQtsubject_name() {
		return qtsubject_name;
	}
	public void setQtsubject_name(String qtsubject_name) {
		this.qtsubject_name = qtsubject_name;
	}
	public String getQttype_name() {
		return qttype_name;
	}
	public void setQttype_name(String qttype_name) {
		this.qttype_name = qttype_name;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public String getAs_str() {
		return as_str;
	}
	public void setAs_str(String as_str) {
		this.as_str = as_str;
	}
	public String getQtsubject() {
		return qtsubject;
	}
	public void setQtsubject(String qtsubject) {
		this.qtsubject = qtsubject;
	}
	public String getQttype() {
		return qttype;
	}
	public void setQttype(String qttype) {
		this.qttype = qttype;
	}
}