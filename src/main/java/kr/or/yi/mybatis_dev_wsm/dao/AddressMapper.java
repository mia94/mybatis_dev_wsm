package kr.or.yi.mybatis_dev_wsm.dao;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.mybatis_dev_wsm.dto.Address;

public interface AddressMapper {
	@Select("select addr_id as ADDRID , street, city, state, zip, country from addresses where addr_id=#{studId}")
	Address selectAddressById(int id);
}
