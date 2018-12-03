show tables;

select *
from courses;

select stud_id, name, email, phone, dob from students where stud_id=1;

select *
from students;

delete
from students
where STUD_ID=5;

update students
set   name='바뀜'
where stud_id=5;

select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country 
from students s join addresses a on s.addr_id=a.addr_id;


select addr_id, street, city, state, zip, country 
from addresses
where addr_id=1;

Select * from Students where stud_id=1;










