package exam_vo.backstage;

import exam_entity.backstage.QuestionStore;

public class QuestionStoreVo extends QuestionStore {

	private String qtsubject_name;
	private String qttype_name;
	public String getQtsubject_name() {
		return qtsubject_name;
	}
	public void setQtsubject_name(String qtsubject_name) {
		this.qtsubject_name = qtsubject_name;
	}
	public String getQttype_name() {
		return qttype_name;
	}
	public void setQttype_name(String qttype_name) {
		this.qttype_name = qttype_name;
	}
	
}