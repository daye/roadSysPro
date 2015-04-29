package exam_vo.rights;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RelationVo implements Serializable {
	private String column_id;
	private String row_id;
	private String row_parent_id;
	public String getColumn_id() {
		return column_id;
	}
	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}
	public String getRow_id() {
		return row_id;
	}
	public void setRow_id(String row_id) {
		this.row_id = row_id;
	}
	public String getRow_parent_id() {
		return row_parent_id;
	}
	public void setRow_parent_id(String row_parent_id) {
		this.row_parent_id = row_parent_id;
	}
}
