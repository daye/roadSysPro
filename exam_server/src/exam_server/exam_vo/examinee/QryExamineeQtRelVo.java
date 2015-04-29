package exam_vo.examinee;


public class QryExamineeQtRelVo implements java.io.Serializable {

	private String usercode;
	private String papercode;

	public String getPapercode() {
		return papercode;
	}

	public void setPapercode(String papercode) {
		this.papercode = papercode;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
}