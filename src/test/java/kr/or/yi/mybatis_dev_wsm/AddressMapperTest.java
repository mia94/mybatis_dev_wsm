package kr.or.yi.mybatis_dev_wsm;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.mybatis_dev_wsm.dao.AddressMapper;
import kr.or.yi.mybatis_dev_wsm.dao.AddressMapperImpl;
import kr.or.yi.mybatis_dev_wsm.dto.Address;
import kr.or.yi.mybatis_dev_wsm.jdbc.MyBatisSqlSessionFactory;

public class AddressMapperTest {
	private static AddressMapper dao = new AddressMapperImpl();
	
	@Test
	public void test01selectAddressById() {
		Address searchAddr = dao.selectAddressById(1);
		Assert.assertNotNull(searchAddr);
	}

}
