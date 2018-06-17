
/*==============================================================*/
/* Table: APP_USER            2018年6月17日00:32:10                                  */
/*==============================================================*/
create table APP_USER
(
   ID                   bigint not null auto_increment,
   USERNAME             varchar(32) comment '账户',
   PASSWORD             varchar(64) not null comment '密码',
   INTRO                varchar(64) comment '简介',
   EMAIL                varchar(64) comment '邮箱',
   MOBILE               bigint(11) comment '手机号码',
   AVATAR               varchar(256) comment '用户头像',
   SEX                  tinyint(1) not null default 0 comment '性别(0=未知，1=男，2=女)',
   STATUS               tinyint(3) not null default 0 comment '账号状态(0=未激活，1=正常，8=冻结)',
   CREATOR              bigint comment '创建人',
   CREATE_DATE          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   MODIFIER             bigint comment '修改人',
   MODIFY_DATE          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ID)
)
auto_increment = 10000;

alter table APP_USER comment '用户表';

/*==============================================================*/
/* Table: APP_USER_BY_EMAIL                                     */
/*==============================================================*/
create table APP_USER_BY_EMAIL
(
   EMAIL                varchar(64) not null comment '邮箱',
   USER_ID              bigint not null comment '用户ID',
   primary key (EMAIL)
);

alter table APP_USER_BY_EMAIL comment '根据邮箱获取用户ID';

/*==============================================================*/
/* Table: APP_USER_BY_MAPID                                     */
/*==============================================================*/
create table APP_USER_BY_MAPID
(
   map_id               varchar(32) not null comment '第三方openid md5值',
   type                 tinyint(2) not null comment '第三方类型(1=dd)',
   user_id              bigint not null comment '用户id',
   unique key uk_mapid_type (map_id, type)
);

alter table APP_USER_BY_MAPID comment 'mapid就是第三方openid（md5值）';

/*==============================================================*/
/* Table: APP_USER_BY_MOBILE                                    */
/*==============================================================*/
create table APP_USER_BY_MOBILE
(
   MOBILE               bigint(11) not null comment '手机号',
   USER_ID              bigint not null comment '用户ID',
   primary key (MOBILE)
);

alter table APP_USER_BY_MOBILE comment '根据手机号获取用户ID';

/*==============================================================*/
/* Table: APP_USER_BY_USERNAME                                  */
/*==============================================================*/
create table APP_USER_BY_USERNAME
(
   USERNAME             varchar(32) not null comment '账号',
   USER_ID              bigint not null comment '用户ID',
   primary key (USERNAME)
);

alter table APP_USER_BY_USERNAME comment '根据账号获取用户ID';
