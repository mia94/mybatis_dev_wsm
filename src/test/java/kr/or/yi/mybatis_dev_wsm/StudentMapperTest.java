package kr.or.yi.mybatis_dev_wsm;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
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
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
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
	
	@Test
	public void test04updateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 4, 28);
		
		Student student = new Student(5,"홍길동2","test2@test.com",newDate.getTime(),new PhoneNumber("010-1111-2222"));
		
		int res = dao.updateStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05deleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		int res = dao.deleteStudent(5);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test07selectStudentByAllForResult() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAllForResults();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test08selectStudentByAllForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Map<String,Object>> maps = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(maps);
	}
	
	@Test
	public void test09selectStudentByAllForMapper() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAllForMapper();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test10selectStudentByAllForResultMapExt() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAllForResultMapExt();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test11selectStudentByAllForResultMapExtXML() {
		List<Student> lists = dao.selectStudentByAllForResultMapExtXML();
		Assert.assertNotNull(lists);
	}
}



















