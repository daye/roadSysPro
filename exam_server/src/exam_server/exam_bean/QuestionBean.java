package exam_bean;

import java.io.Serializable;

public class QuestionBean implements Serializable {

	private Integer questionId;
	private String questionName;
	private String category;
	private String type;
	private String qtgrade;
	public String getQtgrade() {
		return qtgrade;
	}

	public void setQtgrade(String qtgrade) {
		this.qtgrade = qtgrade;
	}

	private Result[] results;

	
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
