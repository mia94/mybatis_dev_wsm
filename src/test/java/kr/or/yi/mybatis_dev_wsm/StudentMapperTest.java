package kr.or.yi.mybatis_dev_wsm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_wsm.dao.StudentMapper;
import kr.or.yi.mybatis_dev_wsm.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_wsm.dto.Gender;
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
	
	@Test
	public void test07selectStudentByAllForResultMap() {
		List<Student> lists = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test08selectStudentByAllForHashMap() {
		List<Map<String,Object>> lists = dao.selectStudentByAllForHashMap(); 
//		System.out.println(lists.size()); -- 2반환

		
		//일반for문 이용
		/*for(int i = 0; i<lists.size();i++) {
			Map<String,Object> m = lists.get(i); 			-- 한줄씩 뽑아옴
			Set<String> s = m.keySet(); 					-- 키값(String 부분)만 추출, keySet은 키값이 들어가있는 묶음
			Iterator<String> it = s.iterator();				-- 반복자로 만들기
			while(it.hasNext()) { 							-- 다음이 존재하면 반복
				String key = it.next(); 					-- it.next()가 계속되지 않도록 값에 저장
				System.out.println(key + ": "+ m.get(key)); -- 키값과 value값 추가
			}
		}*/
		
		
		//확장for이용
		for(Map<String, Object> m : lists) {
			for(Entry<String, Object> e : m.entrySet()) {
				log.debug(String.format("\tkey(%s)-value(%s)", e.getKey(), e.getValue()));
			}
			System.out.println();
		}
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test09selectStudentByNoForResultMapExtends() {
		Student student = new Student();
		student.setStudId(1);
		Student extStd = dao.selectStudentByNoForResultMapExtends(student);
		Assert.assertNotNull(extStd);
	}
	
	@Test
	public void test10selectStudentByNoForResultMapExtends2() {
		Student extStd = dao.selectStudentByNoForResultMapExtends2(1); // 바로 int로 받았기 때문에 객체 생성할 필요없이 바로 번호 입력
		Assert.assertNotNull(extStd);
	}
	
	/*@Test
	public void test11selectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		//메소드 이름 출력할수 있는 배열 눈으로 확인해보기
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		for(StackTraceElement s : ste) {
			System.out.println(s);
		}
		Student student = new Student();
		student.setStudId(1);
		
		Student lists = dao.selectStudentByNoAssociation(student);
		Assert.assertNotNull(lists);
	}*/
	
	@Test
	public void test12insertEnumStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();//autoincrement했기때문에 학생번호 입력은 생략
		student.setName("test");
		student.setEmail("test@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.FEMALE);
		
		int res = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res);
				
	}
	
	@Test
	public void test13selectStudentWithGender() {
		List<Student> lists = dao.selectStudentWithGender();
		Assert.assertNotNull(lists);
	}
	
}













