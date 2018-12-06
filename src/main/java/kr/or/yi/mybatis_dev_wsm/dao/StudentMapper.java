package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.ArrayList;
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
	
	//enum타입 다루기
	int insertEnumStudent(Student student);
	List<Student> selectStudentWithGender();
	
	//여러개의 입력파라미터 전달
	List<Student> selectAllStudentByMap(Map<String, String> map);
	
	//Result처리방식의 재정의
	Map<Integer, String> selectStudentForMap();
	Map<Integer, Student>  selectStudentAllForMap();
	
}











