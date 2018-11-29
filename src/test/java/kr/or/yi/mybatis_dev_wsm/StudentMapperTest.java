package kr.or.yi.mybatis_dev_wsm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	private StudentMapper dao = new StudentMapperImpl();//StudentMapper가 부모클래스이므로
		
	@Test
	public void test01selectStudentByNo() {
		log.debug("test01selectStudentByNo()");
		Student searchStd = new Student();
		searchStd.setStudId(1);
		
		Student searchedStd = dao.selectStudentByNo(searchStd);
		Assert.assertNotNull(searchedStd); //org.junit
	}
	
	@Test
	public void test02selectStudentByAll() {
		log.debug("test02selectStudentByAll()");
		List<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student(3,"홍길동" , "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test04updateStudent() {
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동2");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int res = dao.updateStudent(student);
		Assert.assertSame(1, res);
	}
	
	
	@Test
	public void test05deleteStudent() {
		int res = dao.deleteStudent(3);
		Assert.assertSame(1, res);
	}
}













