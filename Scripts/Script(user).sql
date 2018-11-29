show tables;

select *
from courses;

select stud_id as studid, name, email, dob, phone
from students
where stud_id=1;-- no로 검색하는 것

select *
from students;

delete
from students
where STUD_ID = 3;

update students
set	NAME = "홍길동2"
where STUD_ID = 3;


