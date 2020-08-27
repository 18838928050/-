CREATE TABLE "TEST01"."DW_OUTER_MANAGE" (
  "OUTER_MANAGE_ID" VARCHAR2(36 BYTE) NOT NULL,
  "CHANNEL" VARCHAR2(45 BYTE),
  "ROLE" VARCHAR2(45 BYTE),
  "AGENT_CODE" VARCHAR2(36 BYTE),
  "DEVICE_NO" VARCHAR2(255 BYTE),
  "NAME" VARCHAR2(36 BYTE),
  "IMAGE_URL" VARCHAR2(150 BYTE),
  "PASSWORD" VARCHAR2(100 BYTE),
  "RANK_CODE" VARCHAR2(20 BYTE),
  "RANK_NAME" VARCHAR2(100 BYTE),
  "MANAGE_COM" VARCHAR2(90 BYTE),
  "MANAGE_COM_NAME" VARCHAR2(80 BYTE),
  "AGENT_GROUP" VARCHAR2(4000 BYTE),
  "SIGN_COM" VARCHAR2(36 BYTE),
  "AGENT_COM" VARCHAR2(4000 BYTE),
  "AGENT_COM_NAME" VARCHAR2(90 BYTE),
  "CERTIFICATE" VARCHAR2(255 BYTE),
  "STATUS" VARCHAR2(2 BYTE),
  "MOBILE" VARCHAR2(100 BYTE),
  "PHONE" VARCHAR2(36 BYTE),
  "SEX" VARCHAR2(1 BYTE),
  "BIRTHDAY" VARCHAR2(50 BYTE),
  "HOME_ADDRESS" VARCHAR2(255 BYTE),
  "POSTAL_ADDRESS" VARCHAR2(255 BYTE),
  "EMAIL" VARCHAR2(255 BYTE),
  "ID_TYPE" VARCHAR2(20 BYTE),
  "ID_NO" VARCHAR2(50 BYTE),
  "WORK_AGE" VARCHAR2(50 BYTE),
  "EMPLOY_DATE" VARCHAR2(50 BYTE),
  "OUTWORK_DATE" VARCHAR2(50 BYTE),
  "BRANCH_TYPE" VARCHAR2(255 BYTE),
  "CREATE_TIME" DATE,
  "CREATE_BY" VARCHAR2(36 BYTE),
  "UPDATE_TIME" DATE,
  "UPDATE_BY" VARCHAR2(36 BYTE),
  "CHILD_CHANNEL" VARCHAR2(100 BYTE),
  "M_AGENT_CODE" VARCHAR2(4000 BYTE),
  "PARENT_AGENT_CODE" VARCHAR2(20 BYTE),
  "AGENTG_ROUP" VARCHAR2(45 BYTE),
  "CREAT_BY" VARCHAR2(36 BYTE),
  "CREAT_TIME" TIMESTAMP(6),
  "MOBLIE" VARCHAR2(11 BYTE),
  "STR_VERI" VARCHAR2(6 BYTE),
  "BRANCH_NO" VARCHAR2(62 BYTE)
)
TABLESPACE "DWDATA_62"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
ENABLE ROW MOVEMENT
;
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."OUTER_MANAGE_ID" IS '外勤管理人员id';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."CHANNEL" IS '所属渠道(1个险、2银保、3网销、4收展、5团险)';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."ROLE" IS '角色';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."AGENT_CODE" IS '代理人工号';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."DEVICE_NO" IS '登录设备号';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."NAME" IS '姓名';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."IMAGE_URL" IS '头像url';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."PASSWORD" IS '密码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."RANK_CODE" IS '职级代码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."RANK_NAME" IS '职级名称';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."MANAGE_COM" IS '管理机构';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."MANAGE_COM_NAME" IS '管理机构名称';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."AGENT_GROUP" IS '代理人组别信息';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."SIGN_COM" IS '交单机构';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."AGENT_COM" IS '中介机构代码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."AGENT_COM_NAME" IS '中介机构名称';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."CERTIFICATE" IS '职业资格证';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."STATUS" IS '状态';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."MOBILE" IS '手机';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."PHONE" IS '电话';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."SEX" IS '性别';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."BIRTHDAY" IS '出生日期';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."HOME_ADDRESS" IS '家庭地址';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."POSTAL_ADDRESS" IS '通讯地址';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."EMAIL" IS '邮箱';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."ID_TYPE" IS '证件类型';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."ID_NO" IS '证件号码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."WORK_AGE" IS '从业年限';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."EMPLOY_DATE" IS '录用日期';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."OUTWORK_DATE" IS '离司日期';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."BRANCH_TYPE" IS '展业类型';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."CREATE_BY" IS '创建人，为1时无需重置密码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."UPDATE_BY" IS '更新人';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."STR_VERI" IS '手机短信验证码';
COMMENT ON COLUMN "TEST01"."DW_OUTER_MANAGE"."BRANCH_NO" IS '展业证件号码';