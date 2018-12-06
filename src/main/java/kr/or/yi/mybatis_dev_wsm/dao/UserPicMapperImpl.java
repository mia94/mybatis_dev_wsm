package kr.or.yi.mybatis_dev_wsm.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_wsm.dto.UserPic;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "kr.or.yi.mybatis_dev_wsm.dao.UserPicMapper";
	
	@Override
	public int insertUserPic(UserPic userPic) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".insertUserPic",userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic getUserPic(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".getUserPic",id);
		}
	}

}
