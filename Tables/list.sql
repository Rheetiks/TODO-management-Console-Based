create table list (
task_id int auto_increment primary key,
user_id int,
task_name varchar(100),
foreign key(user_id) references user(user_id)
);

select * from list;

drop table list;