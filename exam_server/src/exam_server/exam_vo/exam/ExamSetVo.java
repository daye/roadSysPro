package exam_vo.exam;

public class ExamSetVo implements java.io.Serializable{

	private String qtsubject;
	private String qttype;
	private String qtcount;
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
	public String getQtcount() {
		return qtcount;
	}
	public void setQtcount(String qtcount) {
		this.qtcount = qtcount;
	}
	
}
