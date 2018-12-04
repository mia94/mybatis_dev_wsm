package kr.or.yi.mybatis_dev_wsm;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.mybatis_dev_wsm.dao.TutorMapper;
import kr.or.yi.mybatis_dev_wsm.dao.TutorMapperImpl;
import kr.or.yi.mybatis_dev_wsm.dto.Course;
import kr.or.yi.mybatis_dev_wsm.dto.Tutor;

public class TutorMapperTest {
	private static TutorMapper dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new TutorMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01selectTutorById() {
		Tutor tutor = dao.selectTutorById(1);
		
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor2 = dao.selectTutorByTutorId(findTutor);
		
		Assert.assertEquals(tutor.getTutorId(), tutor2.getTutorId());
		
		System.out.println(tutor.getName()+"이 개설한 과정");
		for(Course c : tutor.getCourse()) {
			System.out.println(c);
		}
		
		System.out.println(tutor2.getName()+"이 개설한 과정");
		for(Course c : tutor2.getCourse()) {
			System.out.println(c);
		}
	}

}
