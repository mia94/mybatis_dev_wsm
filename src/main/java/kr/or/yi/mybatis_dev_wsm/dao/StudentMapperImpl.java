package kr.or.yi.mybatis_dev_wsm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_wsm.dto.Student;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private static final String namespace = "kr.or.yi.mybatis_dev_wsm.dao.StudentMapper";
//	private static final Log log = LogFactory.getLog(StudentMapperImpl.class); //인터페이스 p.215
	
	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}	
	}

	@Override
	public List<Student> selectStudentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectStudentByAll");
		}
		
	}

	@Override
	public int insertStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace + ".insertStudent",student);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public int updateStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace+".updateStudent",student);
			return res;
		}
		
	}

	@Override
	public int deleteStudent(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.delete(namespace+".deleteStudent",studId);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectStudentByAllForResultMap");
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectStudentByAllForHashMap");
		}
	}

	@Override
	public Student selectStudentByNoForResultMapExtends(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".selectStudentByNoForResultMapExtends", student);
		}
		
	}

	@Override
	public Student selectStudentByNoForResultMapExtends2(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".selectStudentByNoForResultMapExtends2", studId);
		}
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectStudentByNoAssociation", student);
		}
		
	}

	@Override
	public int insertEnumStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+".insertEnumStudent",student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Student> selectStudentWithGender() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectStudentWithGender");
		}
	}

	@Override
	public List<Student> selectAllStudentByMap(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+".selectAllStudentByMap", map);
		}
	}
	
	//p.316
	@Override
	public Map<Integer, String> selectStudentForMap() { 
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {//아래에서 받은 값을 처리
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				//System.out.println(student);
				map.put(student.getStudId(), student.getName());
			}
		};
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){ 
			sqlSession.select(namespace+".selectStudentForMap", resultHandler);
			return map;
		}
		
	}

	@Override
	public Map<Integer, Student> selectStudentAllForMap() {
		Map<Integer, Student> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
				
			}
		};
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){ 
			sqlSession.select(namespace+".selectStudentForMap", resultHandler);
			return map;
		}
	}



	
	

}




















