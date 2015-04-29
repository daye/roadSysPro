package exam_service.impl;

import java.util.List;
import java.util.Map;

import exam_entity.sys.ExamSysMenu;
import exam_factory.impl.DaoFactory;
import exam_service.ISystemService;
import exam_tools.EntityConverter;
import exam_vo.system.ExamSysUserVo;
import exam_vo.system.QueryExamSysUserVo;

public class SystemServiceImpl implements ISystemService {

	public Map<Long, ExamSysMenu> getAllMenuMap() {
		return DaoFactory.getSystemDao().getAllMenuMap();
	}

	public boolean delExamSysUserInfo(ExamSysUserVo vo) {
		return DaoFactory.getSystemDao().delExamSysUserInfo(vo);
	}

	public ExamSysUserVo[] findExamSysUserInfo(QueryExamSysUserVo vo) {
		List list = DaoFactory.getSystemDao().findExamSysUserInfo(vo);
		List voList = EntityConverter.getVo(list, ExamSysUserVo.class);
		if(voList.size() < 1)
			return new ExamSysUserVo[]{};
		ExamSysUserVo[] vos = new ExamSysUserVo[voList.size()];
		voList.toArray(vos);
		return vos;
	}
	

	public Long updateExamSysUserInfo(ExamSysUserVo vo) {
		return DaoFactory.getSystemDao().updateExamSysUserInfo(vo);
	}


	@Override
	public List findIsExsitExamSysUserInfo(String userCode) {
		
		return DaoFactory.getSystemDao().findExamSysUserList(userCode);
	}

}
