-- add system log table --
-- add by huan.gao 2016-9-12 14:36:58 --
-- Create table
create table T_SYS_LOG
(
  id              VARCHAR2(32) not null,
  description     VARCHAR2(1000),
  method          VARCHAR2(1000),
  params          clob,
  type            NUMBER(1),
  exceptioncode   VARCHAR2(19),
  exceptiondetail clob,
  requestip       VARCHAR2(30),
  creator         VARCHAR2(32),
  createtime      VARCHAR2(32)
)
tablespace FN_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table T_SYS_LOG
  is '系统日志表';
-- Add comments to the columns
comment on column T_SYS_LOG.id
  is 'ID';
comment on column T_SYS_LOG.description
  is '描述';
comment on column T_SYS_LOG.method
  is '方法名';
comment on column T_SYS_LOG.params
  is '参数';
comment on column T_SYS_LOG.type
  is '类型 0普通日志 1异常日志';
comment on column T_SYS_LOG.exceptioncode
  is '异常代码';
comment on column T_SYS_LOG.exceptiondetail
  is '异常详细信息';
comment on column T_SYS_LOG.requestip
  is '登录ip';
comment on column T_SYS_LOG.creator
  is '登录者id';
comment on column T_SYS_LOG.createtime
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
alter table T_SYS_LOG
  add primary key (ID)
  using index
  tablespace FN_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
