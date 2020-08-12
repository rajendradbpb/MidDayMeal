--------------------  user ----------------------------- 
select *  from user
delete  from user where username like 'user%'

select * from user u, role r where u.role_id = r.role_id and r.name = 'teacher'

-- get count
select r.name, count(*) from user u, role r where u.role_id = r.role_id 
group by r.name


---------------------  school   -----------------------
select * from school
delete from school where school_id = 2

--role
select * from role
delete from role where role_id = 17

-- classes
select * from classes

--  class
select * from class 
