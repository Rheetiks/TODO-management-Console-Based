create database todo;

use todo;

create table user (
user_id int auto_increment primary key,
username varchar(20),
gmail varchar(29),
password varchar(20),
phone_no long
);
select * from user;
select *  from list where user_id in(select user_id from user where username like'rahul' && password='Rahul1' ); 

select user_id from user where username='Rohan' and password = 'sharma';