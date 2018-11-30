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