package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.mybatis_dev_wsm.dto.Student;

public interface StudentMapper {
	@Select("select stud_id, name, email, phone, dob from students where stud_id=#{studId}")
	Student selectStudentById(Student student);
	
	@Select("select stud_id, name, email, phone, dob from students")
	List<Student> selectStudentByAll();
}
