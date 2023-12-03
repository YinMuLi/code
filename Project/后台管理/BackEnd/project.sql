use yinmu;

drop table if exists `user`;
create table `user`
(
    id          bigint primary key comment '使用雪花算法自动生成',
    username    varchar(50) comment '用户名',
    `password`  varchar(50),
    nickname    varchar(50) comment '昵称',
    email       varchar(50),
    phone       varchar(20),
    address     varchar(255),
    avatar_url  varchar(255) comment '头像地址',
    avatar_hash char(30) comment '头像hash值',
    create_time timestamp default current_timestamp
) auto_increment = 1 comment '用户';
