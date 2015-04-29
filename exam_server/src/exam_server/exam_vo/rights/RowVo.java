package exam_vo.rights;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class RowVo implements Serializable {
	private Map<String,Boolean> menu_role_map ;
	private String rowpk;
	private String rowvalue;
	private String parentid;
	
	public Map<String, Boolean> getMenu_role_map() {
		return menu_role_map;
	}
	public void setMenu_role_map(Map<String, Boolean> menu_role_map) {
		this.menu_role_map = menu_role_map;
	}
	public String getRowpk() {
		return rowpk;
	}
	public void setRowpk(String rowpk) {
		this.rowpk = rowpk;
	}
	public String getRowvalue() {
		return rowvalue;
	}
	public void setRowvalue(String rowvalue) {
		this.rowvalue = rowvalue;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	
}
