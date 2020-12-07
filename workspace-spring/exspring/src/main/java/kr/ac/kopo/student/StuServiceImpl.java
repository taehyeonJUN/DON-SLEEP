package kr.ac.kopo.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("stuService")
public class StuServiceImpl implements StuService {
	
	@Resource(name = "stuDao")
	private StuDao stuDao;
	
	
	
	@Override
	public List<StuVo> seletStuList() {
		return stuDao.seletStuList();
	}

	@Override
	public StuVo seletStu(String stuNo) {
		
		return stuDao.seletStu(stuNo);
	}

	@Override
	public int insertStu(StuVo Vo) {
		
		return stuDao.insertStu(Vo);
	}

	@Override
	public int updateStu(StuVo Vo) {
		return stuDao.updateStu(Vo);
	}

	@Override
	public int delStu(String stuNo) {
		return stuDao.delStu(stuNo);
	}

}
