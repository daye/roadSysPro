package exam_vo.backstage;


public class QryAnswerQtRelVo implements java.io.Serializable {

	private String qtno;//选择题编号
	private String qtsubject;//选择题科目
	private String qttype;//选择题类型
	
	public String getQtno() {
		return qtno;
	}
	public void setQtno(String qtno) {
		this.qtno = qtno;
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