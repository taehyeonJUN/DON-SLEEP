package hi.pizza.world.student;

import java.util.List;

public interface StudentService {

	List<StudentVo> selectStudentList();

	StudentVo selectStudent(String stuNo);

	int insertStudent(StudentVo vo);

	int updateStudent(StudentVo vo);

	int deleteStudent(String stuNo);

	StudentVo selectLoginStudent(StudentVo stuNo);

}