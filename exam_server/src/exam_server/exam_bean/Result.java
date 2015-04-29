package exam_bean;

import java.io.Serializable;

public class Result implements Serializable {

	private Integer resultId;
	private String result;

	public Result(){
		
	}
	public Result(Integer resultId, String result) {
		super();
		this.resultId = resultId;
		this.result = result;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
