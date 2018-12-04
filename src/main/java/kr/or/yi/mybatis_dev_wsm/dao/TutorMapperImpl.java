package kr.or.yi.mybatis_dev_wsm.dao;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_wsm.dto.Tutor;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class TutorMapperImpl implements TutorMapper{
	private String namespace = "kr.or.yi.mybatis_dev_wsm.dao.TutorMapper";
	private static final Log log = LogFactory.getLog(TutorMapperImpl.class);
	
	public Tutor selectTutorById(int tutorId) {
		log.debug("selectTutorById");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectTutorById",tutorId);
		}
	}
	
	public Tutor selectTutorByTutorId(Tutor tutor) {
		log.debug("selectTutorByTutorId");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+".selectTutorByTutorId", tutor);
		}
	}
	
}
