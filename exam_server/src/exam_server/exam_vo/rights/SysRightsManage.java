package exam_vo.rights;

/**
 * SysRightsManage entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class SysRightsManage implements java.io.Serializable {

	// Fields

	private Long managementid;
	private String paneltitle;
	private String paneltype;
	private String columnpk;
	private String columnvalue;
	private String rowpk;
	private String rowvalue;
	private String columntable;
	private String rowtable;
	private String relationtable;
	private String rowparentid;
	
	public Long getManagementid() {
		return managementid;
	}
	public void setManagementid(final Long managementid) {
		this.managementid = managementid;
	}
	public String getPaneltitle() {
		return paneltitle;
	}
	public void setPaneltitle(final String paneltitle) {
		this.paneltitle = paneltitle;
	}
	
	public String getPaneltype() {
		return paneltype;
	}
	public void setPaneltype(final String paneltype) {
		this.paneltype = paneltype;
	}
	public String getColumnpk() {
		return columnpk;
	}
	public void setColumnpk(final String columnpk) {
		this.columnpk = columnpk;
	}
	public String getColumnvalue() {
		return columnvalue;
	}
	public void setColumnvalue(final String columnvalue) {
		this.columnvalue = columnvalue;
	}
	public String getRowpk() {
		return rowpk;
	}
	public void setRowpk(final String rowpk) {
		this.rowpk = rowpk;
	}
	public String getRowvalue() {
		return rowvalue;
	}
	public void setRowvalue(final String rowvalue) {
		this.rowvalue = rowvalue;
	}
	public String getColumntable() {
		return columntable;
	}
	public void setColumntable(final String columntable) {
		this.columntable = columntable;
	}
	public String getRowtable() {
		return rowtable;
	}
	public void setRowtable(final String rowtable) {
		this.rowtable = rowtable;
	}
	public String getRelationtable() {
		return relationtable;
	}
	public void setRelationtable(final String relationtable) {
		this.relationtable = relationtable;
	}
	public String getRowparentid() {
		return rowparentid;
	}
	public void setRowparentid(final String rowparentid) {
		this.rowparentid = rowparentid;
	}
	

}