package exam_vo.backstage;


public class QryQuestionStoreVo implements java.io.Serializable {

	private String qtname;//选择题名称
	private String qtsubject;//选择题科目
	private String qttype;//选择题类型
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
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