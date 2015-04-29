package exam_entity.backstage;

/**
 * QuestionStore entity. @author MyEclipse Persistence Tools
 */

public class QuestionStore implements java.io.Serializable {

	// Fields

	private Integer qtno;
	private String qtname;
	private String qtsubject;
	private String qttype;
	private String qtgrade;

	// Constructors

	/** default constructor */
	public QuestionStore() {
	}

	/** full constructor */
	public QuestionStore(String qtname, String qtsubject, String qttype,
			String qtgrade) {
		this.qtname = qtname;
		this.qtsubject = qtsubject;
		this.qttype = qttype;
		this.qtgrade = qtgrade;
	}

	// Property accessors

	public Integer getQtno() {
		return this.qtno;
	}

	public void setQtno(Integer qtno) {
		this.qtno = qtno;
	}

	public String getQtname() {
		return this.qtname;
	}

	public void setQtname(String qtname) {
		this.qtname = qtname;
	}

	public String getQtsubject() {
		return this.qtsubject;
	}

	public void setQtsubject(String qtsubject) {
		this.qtsubject = qtsubject;
	}

	public String getQttype() {
		return this.qttype;
	}

	public void setQttype(String qttype) {
		this.qttype = qttype;
	}

	public String getQtgrade() {
		return this.qtgrade;
	}

	public void setQtgrade(String qtgrade) {
		this.qtgrade = qtgrade;
	}

}