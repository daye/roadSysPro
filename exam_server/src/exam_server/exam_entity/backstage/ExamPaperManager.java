package exam_entity.backstage;

/**
 * ExamPaperManager entity. @author MyEclipse Persistence Tools
 */

public class ExamPaperManager implements java.io.Serializable {

	// Fields

	private Integer paperno;
	private String papername;
	private String qtsubject;
	private Integer qtno;


	public Integer getPaperno() {
		return this.paperno;
	}

	public void setPaperno(Integer paperno) {
		this.paperno = paperno;
	}

	public String getPapername() {
		return this.papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public String getQtsubject() {
		return this.qtsubject;
	}

	public void setQtsubject(String qtsubject) {
		this.qtsubject = qtsubject;
	}

	public Integer getQtno() {
		return qtno;
	}

	public void setQtno(Integer qtno) {
		this.qtno = qtno;
	}


}