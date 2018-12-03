package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_wsm.dto.Student;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private static final String namespace = "kr.or.yi.mybatis_dev_wsm.dao.StudentMapper";
	
	@Override
	public Student selectStudentById(Student student) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectOne(namespace + ".selectStudentById", student);
		}
		
	}

	@Override
	public List<Student> selectStudentByAll() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace + ".selectStudentByAll");
		}
		
	}

	@Override
	public int insertStudent(Student student) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlsession.insert(namespace +".insertStudent",student);
			sqlsession.commit();
			return res;
		}
	}

	@Override
	public int deleteStudent(int studId) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlsession.delete(namespace+".deleteStudent",studId);
			sqlsession.commit();
			return res;
		}
		
	}

	@Override
	public int updateStudent(Student student) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlsession.update(namespace+".updateStudent",student);
			sqlsession.commit();
			return res;
		}
	}

	@Override
	public List<Student> selectStudentByAllForResults() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace+".selectStudentByAllForResults");
		}	
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForResultMap() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace+".selectStudentByAllForResultMap");
		}
	}

	@Override
	public List<Student> selectStudentByAllForMapper() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace + ".selectStudentByAllForMapper");
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMapExt() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace+".selectStudentByAllForResultMapExt");
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMapExtXML() {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectList(namespace+".selectStudentByAllForResultMapExtXML");
		}
		
	}
	
	

}










