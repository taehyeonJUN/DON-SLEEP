package kr.ac.kopo.student;

import java.util.List;

public interface StuService {
	List<StuVo> seletStuList();

	StuVo seletStu(String stuNo);

	int insertStu(StuVo Vo);

	int updateStu(StuVo Vo);

	int delStu(String stuNo);
}
