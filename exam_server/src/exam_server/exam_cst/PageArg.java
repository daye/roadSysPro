package exam_cst;

import java.io.Serializable;

public class PageArg implements Serializable{

	//当前页数
	public int pageIndex = 1;
	
	//每页记录数
	public int rowsPerPage = page_const_args.rowsPerPage;
	
	//数据总量
	public int recordCount = 0;
}
