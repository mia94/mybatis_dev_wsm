package kr.or.yi.mybatis_dev_wsm;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_wsm.dao.StudentMapper;
import kr.or.yi.mybatis_dev_wsm.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_wsm.dto.PhoneNumber;
import kr.or.yi.mybatis_dev_wsm.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private static StudentMapper dao = new StudentMapperImpl();
	
	@Test
	public void test01selectStudentById() {
		log.debug("test01selectStudentById()");
		Student newStd = new Student();
		newStd.setStudId(2);
		
		Student searchStd = dao.selectStudentById(newStd);
		Assert.assertNotNull(searchStd);
	}
	
	@Test
	public void test02selectStudentByAll() {
		log.debug("selectStudentByAll()");
		List<Student> lists = dao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}

	@Test
	public void test03insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 4, 28);
		
		Student student = new Student(5,"홍길동","lee@test.co.kr",newDate.getTime(),new PhoneNumber("010-1234-1234"));
		
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
}



















