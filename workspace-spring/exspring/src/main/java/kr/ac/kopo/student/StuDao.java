package kr.ac.kopo.student;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuDao {
	List<StuVo> seletStuList();

	StuVo seletStu(String stuNo);

	int insertStu(StuVo Vo);

	int updateStu(StuVo Vo);

	int delStu(String stuNo);
}
