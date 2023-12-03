use yinmu;
drop table if exists anime;
create table anime
(
    `name`   varchar(20) not null comment '名称',
    episodes smallint unsigned comment '集数',
    seasons  tinyint(1) unsigned comment '季',
    notes    varchar(500) comment '类似于观后感、评论'
)