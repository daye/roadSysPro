package exam_entity.base;

/**
 * ExamDictionary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ExamDictionary implements java.io.Serializable {

	// Fields

	private Integer dcid;
	private String dcCode;
	private String dcName;
	private String dctype;

	// Constructors

	/** default constructor */
	public ExamDictionary() {
	}

	/** minimal constructor */
	public ExamDictionary(Integer dcid) {
		this.dcid = dcid;
	}

	/** full constructor */
	public ExamDictionary(Integer dcid, String dcCode, String dcName,
			String dctype) {
		this.dcid = dcid;
		this.dcCode = dcCode;
		this.dcName = dcName;
		this.dctype = dctype;
	}

	// Property accessors

	public Integer getDcid() {
		return this.dcid;
	}

	public void setDcid(Integer dcid) {
		this.dcid = dcid;
	}

	public String getDcCode() {
		return this.dcCode;
	}

	public void setDcCode(String dcCode) {
		this.dcCode = dcCode;
	}

	public String getDcName() {
		return this.dcName;
	}

	public void setDcName(String dcName) {
		this.dcName = dcName;
	}

	public String getDctype() {
		return this.dctype;
	}

	public void setDctype(String dctype) {
		this.dctype = dctype;
	}

}