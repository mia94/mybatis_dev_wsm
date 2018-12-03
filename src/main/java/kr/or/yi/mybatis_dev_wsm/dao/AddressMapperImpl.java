package kr.or.yi.mybatis_dev_wsm.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_wsm.dto.Address;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class AddressMapperImpl implements AddressMapper {
	private static final String namespace = "kr.or.yi.mybatis_dev_wsm.dao.AddressMapper";
	
	@Override
	public Address selectAddressById(int id) {
		try(SqlSession sqlsession = MyBatisSqlSessionFactory.openSession()){
			return sqlsession.selectOne(namespace + ".selectStudentById", id);
		}
	}

}
