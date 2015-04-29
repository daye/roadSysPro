package exam_vo.backstage;

import exam_entity.backstage.ExamPaperManager;

public class ExamPaperManagerVo extends ExamPaperManager{

	private String qtname;
	private String qtsubject_name;

	public String getQtname() {
		return qtname;
	}

	public void setQtname(String qtname) {
		this.qtname = qtname;
	}

	public String getQtsubject_name() {
		return qtsubject_name;
	}

	public void setQtsubject_name(String qtsubject_name) {
		this.qtsubject_name = qtsubject_name;
	}
}
