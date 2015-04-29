package exam_vo.rights;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HasRightsVo implements Serializable {
	private String rowpk;// 菜单编号
	private String rowview;// 菜单名称
	private String rowparentid;// 父菜单链接
	private String columnpk;// 角色
	private String has_rights;// 是否有权限(10:有权限，11：无权限)

	public String getRowpk() {
		return rowpk;
	}

	public void setRowpk(String rowpk) {
		this.rowpk = rowpk;
	}

	public String getRowview() {
		return rowview;
	}

	public void setRowview(String rowview) {
		this.rowview = rowview;
	}

	public String getRowparentid() {
		return rowparentid;
	}

	public void setRowparentid(String rowparentid) {
		this.rowparentid = rowparentid;
	}

	public String getColumnpk() {
		return columnpk;
	}

	public void setColumnpk(String columnpk) {
		this.columnpk = columnpk;
	}

	public String getHas_rights() {
		return has_rights;
	}

	public void setHas_rights(String has_rights) {
		this.has_rights = has_rights;
	}

}
