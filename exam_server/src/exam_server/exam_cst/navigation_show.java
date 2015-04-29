package exam_cst;

import java.util.HashMap;
import java.util.Map;

public class navigation_show {

	private final static String user_manager = "exam.client.baseData.userMaintain.UserMaintainPage";
	private final static String role_manager = "exam.client.baseData.roleManager.RoleManagePage";
	private final static String menu_manager = "exam.client.baseData.menu.MenuManagePage";
	
	private final static String dictionary_manager = "exam.client.baseData.examDictionary.ExamDictionaryPage";
	private final static String password_modify = "exam.client.baseData.passwordChange.PasswordChangePage";
	
	
	private final static String qt_store = "exam.client.backstage.questionStore.QuestionStorePanel";
	private final static String qt_as_rel = "exam.client.backstage.questionSets.QuestionSetsPage";
	private final static String exam_ks = "exam.client.examineeks.OnlineExamPage";
	private final static String exam_lx = "exam.client.examinee.ExamineeQtPage";
	private final static String exam_qy = "exam.client.examRsInquiry.ExamRsInquiryPage";
	private final static String paper_qy = "exam.client.paperQry.PaperQryPage";
	
	private final static String user_manager_str = "试题管理系统 >>系统管理 >>登陆管理";
	private final static String role_manager_str = "试题管理系统 >>系统管理 >>角色管理";
	private final static String menu_manager_str = "试题管理系统 >>系统管理 >>菜单管理";
	private final static String password_modify_str = "试题管理系统 >>系统管理 >>密码修改";
	private final static String dictionary_manager_str = "试题管理系统 >>系统管理 >>数据字典";
	
	private final static String qt_store_str = "试题管理系统>>系统后台管理端>>试题管理";
	private final static String qt_as_rel_str = "试题管理系统>>系统后台管理端>>试题选项设置";
	private final static String exam_lx_str = "试题管理系统>>系统考试前端>>考生练习";
	private final static String exam_ks_str = "试题管理系统>>系统考试前端>>在线考试";
	
	private final static String exam_qy_str = "试题管理系统>>成绩查询>>查看成绩";
	private final static String paper_qy_str = "试题管理系统>>系统考试前端>>查看试卷";
	
	
	public static Map naviMap = new HashMap();
	
	static{
		naviMap.put(user_manager, user_manager_str);
		naviMap.put(role_manager, role_manager_str);
		naviMap.put(menu_manager, menu_manager_str);
		
		
		naviMap.put(dictionary_manager, dictionary_manager_str);
		
		naviMap.put(password_modify, password_modify_str);
		
		naviMap.put(qt_store, qt_store_str);
		naviMap.put(qt_as_rel, qt_as_rel_str);
		naviMap.put(exam_ks, exam_ks_str);
		naviMap.put(exam_lx, exam_lx_str);
		naviMap.put(exam_qy, exam_qy_str);
		naviMap.put(paper_qy, paper_qy_str);
		
	}
}
