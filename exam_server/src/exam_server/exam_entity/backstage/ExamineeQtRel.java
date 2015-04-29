package exam_entity.backstage;

/**
 * ExamineeQtRel entity. @author MyEclipse Persistence Tools
 */

public class ExamineeQtRel implements java.io.Serializable {

	// Fields

	private Integer reid;
	private String papercode;
	private String usercode;
	private String qtno;
	private String qtanswer;
	private String qtgrade;
	private String qtstatus;

	// Constructors

	public String getQtstatus() {
		return qtstatus;
	}

	public void setQtstatus(String qtstatus) {
		this.qtstatus = qtstatus;
	}

	/** default constructor */
	public ExamineeQtRel() {
	}

	/** full constructor */
	public ExamineeQtRel(String usercode, String qtno, String qtanswer,
			String qtgrade) {
		this.usercode = usercode;
		this.qtno = qtno;
		this.qtanswer = qtanswer;
		this.qtgrade = qtgrade;
	}

	// Property accessors

	public String getPapercode() {
		return papercode;
	}

	public void setPapercode(String papercode) {
		this.papercode = papercode;
	}
	public Integer getReid() {
		return this.reid;
	}

	public void setReid(Integer reid) {
		this.reid = reid;
	}

	public String getUsercode() {
		return this.usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getQtno() {
		return this.qtno;
	}

	public void setQtno(String qtno) {
		this.qtno = qtno;
	}

	public String getQtanswer() {
		return this.qtanswer;
	}

	public void setQtanswer(String qtanswer) {
		this.qtanswer = qtanswer;
	}

	public String getQtgrade() {
		return this.qtgrade;
	}

	public void setQtgrade(String qtgrade) {
		this.qtgrade = qtgrade;
	}

}