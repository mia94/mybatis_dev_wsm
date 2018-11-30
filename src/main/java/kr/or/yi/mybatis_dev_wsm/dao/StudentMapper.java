package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.mybatis_dev_wsm.dto.Student;

public interface StudentMapper {
	
	//ResultMap
	List<Student> selectStudentByAllForResultMap();
	//hasMap
	List<Map<String, Object>> selectStudentByAllForHashMap();
	//resultMap Extends
	Student selectStudentByNoForResultMapExtends(Student student);
	//resultMap Extends2
	Student selectStudentByNoForResultMapExtends2(int studId);
	
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
}
