package saptac.core;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DataSourceProxy implements javax.sql.DataSource {
	
	Log log = LogFactory.getLog(getClass());

	MyTimerTask task = null;
	
	DataSource dataSource = null;

	int connectionTimeOut = 0;

	public Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		if(connectionTimeOut >0)
		{
			monitorConn(conn);
		}
		return conn;
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		Connection conn = dataSource.getConnection(username, password);
		if(connectionTimeOut >0)
		{
			monitorConn(conn);
		}
		return conn;
	}

	public PrintWriter getLogWriter() throws SQLException {
		return dataSource.getLogWriter();
	}

	public int getLoginTimeout() throws SQLException {
		return dataSource.getLoginTimeout();
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		dataSource.setLogWriter(out);
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		dataSource.setLoginTimeout(seconds);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int getConnectionTimeOut() {
		return connectionTimeOut;
	}

	public void setConnectionTimeOut(int connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
		if(null != task)
		{
			task.setConnectionTimeOut(connectionTimeOut);
		}
	}

	private void monitorConn(final Connection conn) {
		if(null == task)
		{
			task = new MyTimerTask();
			task.setConnectionTimeOut(connectionTimeOut);
		}
		task.addConn(conn);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

class ConnStruct{
	ConnStruct(Connection conn,long starttime)
	{
		this.conn= conn;
		this.starttime = starttime;
	}	
	public Connection conn =  null;
	public long starttime = 0L;
}

class MyTimerTask extends TimerTask{
	Log log = LogFactory.getLog(getClass());
	List connLst = new Vector();
	Timer timer = null;
	int maxTimeOut	=0;
	
	public void addConn(Connection conn)
	{
		connLst.add(new ConnStruct(conn,System.currentTimeMillis()));
	}
	
	public void setConnectionTimeOut(int connectionTimeOut)
	{
		if(null != timer)
			timer.cancel();
		timer = new Timer();
		this.maxTimeOut =connectionTimeOut;
		timer.schedule(this, 5);//定时查
	}
	
	@Override
	public void run() {
		Iterator it = connLst.iterator();
		List temp = new Vector();
		while(it.hasNext())
		{
			ConnStruct cs = (ConnStruct)it.next();
			if((System.currentTimeMillis()-cs.starttime)>maxTimeOut)
			{
				temp.add(cs.conn);
				try {
					cs.conn.close();
				} catch (SQLException e) {
					log.error(e);
				}
			}
		}
		while(temp.iterator().hasNext())
		{
			connLst.remove(temp.iterator().next());
		}		
	}
	
}

