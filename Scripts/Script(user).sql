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

select STUD_ID, name, email, phone, a.ADDR_ID, street, city, state, zip, country
from students s left join addresses a on s.ADDR_ID = a.ADDR_ID
where STUD_ID = 1;



select STUD_ID as studid, name, email, phone, a.ADDR_ID, street, city, state, zip, country
from students s left join addresses a on s.ADDR_ID = a.ADDR_ID;















