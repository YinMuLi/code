drop database if exists web;
create database web;
use web;
drop table if exists t_user;
create table t_user
(
    id              int primary key auto_increment,
    user_name       char(30),
    pwd             char(60),
    last_login_time timestamp,
    login_ip        char(30)
);
drop table if exists t_role;
create table t_role
(
    id        int primary key auto_increment,
    role_name char(30),
    note      char
);
drop table if exists t_user_role;
create table t_user_role
(
    user_id     int not null,
    role_id     int not null,
    creater     char(30),
    create_time timestamp,
    note        char,
    foreign key (user_id) references t_user (id),
    foreign key (role_id) references t_role (id)
);
# insert into t_user(user_name, pwd) value ('admin', 'swqzx123');

# update t_user
# set last_login_time=current_timestamp,
#     login_ip       = '192.168.1.200'
# where user_name = 'admin';

# select * from t_user where user_name = 'admin';

# select t_user.id,tr.id,tr.role_name
# from t_user
#          left join t_role tr on tr.id in (select role_id
#                                           from t_user_role
#                                           where user_id = (select id from t_user where user_name = 'admin'));

# select *
# from t_user
# where id in (select user_id from t_user_role);