package exam_vo.rights;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ColumnVo implements Serializable {
	private String column_id;
	private String column_name;
	
	public String getColumn_id() {
		return column_id;
	}
	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(final String column_name) {
		this.column_name = column_name;
	}
}
