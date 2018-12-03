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
	
	//매퍼 인터페이스
	
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
	
	//내포된 결과매핑(ResultMap)을 사용한 일대일매핑
	Student selectStudentByNoAssociation(Student student);
}
