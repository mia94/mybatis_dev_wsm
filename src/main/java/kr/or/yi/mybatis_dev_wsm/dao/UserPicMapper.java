package kr.or.yi.mybatis_dev_wsm.dao;

import kr.or.yi.mybatis_dev_wsm.dto.UserPic;

public interface UserPicMapper {
	int insertUserPic(UserPic userPic);
	UserPic getUserPic(int id);
}
