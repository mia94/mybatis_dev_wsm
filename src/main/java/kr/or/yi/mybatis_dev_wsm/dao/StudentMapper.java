package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.List;

import kr.or.yi.mybatis_dev_wsm.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
}
