package exam_cst;

import java.util.ArrayList;
import java.util.List;

public class property_columns {
 
	public static List columnsList = new ArrayList();
	
	private static String propertyColumn = "PropertyColumn"; 
	private static String editablePropertyColumn = "EditablePropertyColumn";
	private static String selPropertyColumn = "SelPropertyColumn";
	private static String datePropertyColumn = "DatePropertyColumn";
	
	static {
		columnsList.add(propertyColumn);
		columnsList.add(editablePropertyColumn);
		columnsList.add(selPropertyColumn);
		columnsList.add(datePropertyColumn);
	}
}
