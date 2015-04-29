package exam_entity.backstage;

/**
 * AnswerQtRel entity. @author MyEclipse Persistence Tools
 */

public class AnswerQtRel implements java.io.Serializable {

	// Fields

	private Integer asid;
	private Integer qtno;
	private Integer asno;
	private String asname;
	private String asstatus;

	// Constructors

	/** default constructor */
	public AnswerQtRel() {
	}

	/** full constructor */
	public AnswerQtRel(Integer qtno, Integer asno, String asname,
			String asstatus) {
		this.qtno = qtno;
		this.asno = asno;
		this.asname = asname;
		this.asstatus = asstatus;
	}

	// Property accessors

	public Integer getAsid() {
		return this.asid;
	}

	public void setAsid(Integer asid) {
		this.asid = asid;
	}

	public Integer getQtno() {
		return this.qtno;
	}

	public void setQtno(Integer qtno) {
		this.qtno = qtno;
	}

	public Integer getAsno() {
		return this.asno;
	}

	public void setAsno(Integer asno) {
		this.asno = asno;
	}

	public String getAsname() {
		return this.asname;
	}

	public void setAsname(String asname) {
		this.asname = asname;
	}

	public String getAsstatus() {
		return this.asstatus;
	}

	public void setAsstatus(String asstatus) {
		this.asstatus = asstatus;
	}

}