--表一、日志表
create table WBS_OPER_LOG
(
 ID int  GENERATED BY DEFAULT AS identity(start with 1,increment by 1) not null,
 TYPE int not null,
 ORIG_MODEL OTHER,
 LAST_MODEL OTHER,
 SHORT_REMARK VARCHAR,
 REMARK VARCHAR,
 USER_ID int not null,
 USER_NAME VARCHAR not null,
 LOG_TIME DATETIME not null
);

--表二、日志类型对照表
**TYPE_STAT 0 禁用**
**TYPE_STAT 1 启用**
create table LOG_TYPE
(
 ID int  GENERATED BY DEFAULT AS identity(start with 1,increment by 1) not null,
 TYPE int not null,
 TYPE_NAME VARCHAR not null,
 TYPE_STAT int not null
);

--表三、系统日志
create table WBS_SYS_LOG
(
 ID int  GENERATED BY DEFAULT AS identity(start with 1,increment by 1) not null,
 MODULE VARCHAR not null,
 ORIG_MODEL OTHER,
 LAST_MODEL OTHER,
 SHORT_REMARK VARCHAR,
 REMARK VARCHAR,
 USER_ID int not null,
 USER_NAME VARCHAR not null,
 LOG_TIME DATETIME not null
);