package exam_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenGrantSql {

	private static StringBuffer str = new StringBuffer(1024 * 1024);

	//连接数据库的字符串
	String dbconn = "jdbc:sybase:Tds:172.18.7.250:6668/OIL";
	String dbuser = "DBA";
	String dbpasswd = "SQL";
		
	public String[] getAllSybaseIQTables(String user) {
		List lst = new ArrayList();
		String[] retTables = null;
		try {
			Statement state = null;
			try {
				Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(dbconn, dbuser, dbpasswd);
			state = conn.createStatement();
			String sql = "select a.table_name, b.user_name from SYSTABLE a, SYSUSERPERM b where a.creator=b.user_id and b.user_name ='"
				+ user + "'";
			ResultSet rs = state.executeQuery(sql);
			while(rs.next())
			{
				String table_name = rs.getString("table_name");
				lst.add(table_name);
			}
			state.close();
			rs.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(lst.size() >0 )
		{
			retTables = new String[lst.size()];
			lst.toArray(retTables);
		}
		return retTables;
	}

	//grant select on table1 to jack	
	public StringBuffer genGrantSql(String user ,String oprName ,String[] tablenames)
	{
		StringBuffer sb = new StringBuffer(1024*1024);
		for(int i=0;i<tablenames.length;i++)
		{
			sb.append("grant "+oprName+" on "+tablenames[i].trim()+" to "+user+"; \n");
		}
		sb.append("共"+tablenames.length+"条");
		return sb;
	}
	
	public static void main(String[] args) {
		String user = "DBA";	//被赋予权限的用户
		String oprName = "select";//所赋的权限
		GenGrantSql genGrantSql = new GenGrantSql();
		String[] tables = genGrantSql.getAllSybaseIQTables(user);
		StringBuffer sb = genGrantSql.genGrantSql(user,oprName,tables);
		System.out.println(sb.toString());
	}

}
