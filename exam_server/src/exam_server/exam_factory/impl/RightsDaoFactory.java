package exam_factory.impl;

import javax.sql.DataSource;

import exam_dao.RightsDao;
import exam_dao.RightsDaoImpl;


public class RightsDaoFactory {

	private static RightsDao rightsDao = null;

	public static RightsDao getRightsDao(DataSource ds) {
		if (rightsDao == null) {
			RightsDaoImpl rdi = new RightsDaoImpl();
			rdi.setDataSource(ds);
			rightsDao = rdi;
		}
		return rightsDao;
	}
	public static RightsDao getRightsDao(){
		return rightsDao;
	}
	
}
