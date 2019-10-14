-- 创建cherry数据库
create database if not exists cherry character set utf8 collate utf8_general_ci;
-- 使用cherry数据库
-- use cherry;

-- 团队表
create table if not exists cherry.cherry_team (
	id bigint not null auto_increment comment '主键id',
	name varchar(128) not null comment '团队名称',
	intro varchar(256) null comment '团队介绍',
	avatar varchar(256) null comment '团队logo地址',
	status tinyint unsigned default 1 not null comment '0=删除，1=正常，2=冻结',
	limit_member int unsigned default 10 not null comment '团队最多容纳人员',
	creator bigint not null comment '创建人',
	creator_time timestamp default current_timestamp not null comment '创建时间',
	modifier bigint not null comment '修改人',
	modifier_time timestamp default current_timestamp on update current_timestamp not null comment '修改时间',
	primary key (id)
) engine=innodb default charset=utf8 comment='团队表' auto_increment=1000 ;
-- 团队成员
create table if not exists cherry.cherry_team_member (
    team_id bigint not null  comment '团队id',
	user_id bigint not null  comment '成员id',
	nickname varchar(16) not null comment '昵称',
	status tinyint unsigned default 1 not null comment '0=删除，1=正常，2=冻结',
	manage tinyint(1) unsigned default 0 not null comment '0=成员，1=管理员',
	creator bigint not null comment '创建人',
	creator_time timestamp default current_timestamp not null comment '创建时间',
	modifier bigint not null comment '修改人',
	modifier_time timestamp default current_timestamp on update current_timestamp not null comment '修改时间',
	CONSTRAINT uk_team_user UNIQUE KEY (team_id,user_id)
) engine=innodb default charset=utf8 comment='团队成员表';