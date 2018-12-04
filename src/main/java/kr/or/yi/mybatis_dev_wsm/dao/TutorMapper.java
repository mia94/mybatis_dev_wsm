package kr.or.yi.mybatis_dev_wsm.dao;

import kr.or.yi.mybatis_dev_wsm.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorById(int tutorId);
	Tutor selectTutorByTutorId(Tutor tutor);
}
