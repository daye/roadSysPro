package exam_vo.examinee;

public class ExamStatisVo implements java.io.Serializable{

	private String rights_as;//正确题数量
	private String wrong_as;//做错题数量
	private String qtgrade_total;//总分数
	public String getRights_as() {
		return rights_as;
	}
	public void setRights_as(String rights_as) {
		this.rights_as = rights_as;
	}
	public String getWrong_as() {
		return wrong_as;
	}
	public void setWrong_as(String wrong_as) {
		this.wrong_as = wrong_as;
	}
	public String getQtgrade_total() {
		return qtgrade_total;
	}
	public void setQtgrade_total(String qtgrade_total) {
		this.qtgrade_total = qtgrade_total;
	}
}
