自增uuid,oracle自带：
xml里面写法，看系统，看看别人怎么用
rawtohex(sys_guid())
sys_guid()


oracle创建序列：
create sequence seq_classroom_user increment by 1 start with 1
nomaxvalue nominvalue nocache ;
--创建触发器
create or replace trigger classroom_user_tr
before insert on CLASSROOM_USER for each row
begin select seq_classroom_user.nextval into :new.id from dual; end;


解释：
create sequence 序列名称 increment by 1 start with 1
nomaxvalue nominvalue nocache ;
--创建触发器
create or replace trigger 触发器名称
before insert on 表名称（数据库真实表名称） for each row
begin select 序列名称.nextval into :new.id from dual; end;


insert里面用到了序列：SEQ_COURSEWAREID是序列名称
<selectKey keyProperty="coursewareId" resultType="int" order="BEFORE">
	SELECT SEQ_COURSEWAREID.NEXTVAL as coursewareId FROM DUAL
</selectKey>


nvl和nvl2的区别
nvl（expr1，expr2）expr1为null时结果为expr2，值不为null时，结果为expr1
nvl2（expr1，expr2，expr3）expr1为null时结果为expr3,不为null时结果为expr2
	

sql语句查询表结构：
select *  from user_tab_columns where table_name ='LI_PM_PRODUCT_SALE';


oracle查询120分钟之前的某条数据，where后是自己的判断条件，1440是一天是1440分钟：
SELECT * FROM LI_ORD_RISK AS OF TIMESTAMP SYSDATE-120/1440 where ORDER_NO='2020070917122002012';

SELECT * FROM 表名 AS OF TIMESTAMP SYSDATE-120/1440 where ORDER_NO='2020070917122002012';


oracle查询一个表有多少列：
select max(column_id) from user_tab_columns where table_name=upper('LI_PM_RISK_INPUT_ITEM')  


查询日期大于某一天的数据：
select * from DW_ATTENDANCE where agent_code in('805050107') and SIGN_IN_TIME is not null and TO_DATE(CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') > TO_DATE('2020-03-03 21:19:39', 'YYYY-MM-DD HH24:MI:SS') ORDER BY CREATE_DATE DESC

查询介于日期之间的数据：
select * from DW_OUTER_MANAGE where CHANNEL='4' and status in('01','02') 
and TO_DATE(EMPLOY_DATE,'YYYY-MM-DD') between TO_DATE('2020-06-01','YYYY-MM-DD') and TO_DATE('2020-06-30','YYYY-MM-DD')


 (TO_DATE(dm.outwork_date,'YYYY-MM-DD') between TO_DATE('2020-06-01','YYYY-MM-DD') and TO_DATE('2020-06-30','YYYY-MM-DD')

oracle like多条件查询：
select * from LI_ORD_NOTICE where ORDER_no ='2020072909233203724' and IMPART_GROUP_NO='A01'
and  REGEXP_LIKE(IMPART_CODE, '(A0108|A0107|A0109)');

查询createdate是今天的数据：
select * from DW_LOGIN_RECORD where  AGENTCODE='63002434'  
and  CREATE_DATE between TO_DATE('2020-09-18 00:00:00','YYYY-MM-DD hh24:Mi:ss') and TO_DATE('2020-09-18 23:59:59','YYYY-MM-DD hh24:Mi:ss')


ALTER TABLE "YDZY_SEC_DEV"."LI_ORD_ORDER" ADD (SB_LOCATION varchar2(32));
COMMENT ON COLUMN "YDZY_SEC_DEV"."LI_ORD_ORDER"."SBNO" IS '社保账号';
COMMENT ON COLUMN "YDZY_SEC_DEV"."LI_ORD_ORDER"."SB_LOCATION" IS '社保所在地';

Oracle删除一行：
ALTER TABLE "YDZY_SEC_DEV"."LI_ORD_ORDER" drop column SB_LOCATION2;


update CS_SALE_AUTH set START_SALE_TIME =to_date('2020-09-01 00:00:00','yyyy-MM-dd hh24:Mi:ss')  where id='71'

oracle查询所有表的行数
select t.table_name,t.num_rows from all_tables t

oracle like 写法：
select distinct doc_name,DOC_URL from LI_PM_PRODUCT_DOC where DOC_type='9'
    and DOC_NAME like '%' ||#{docName,jdbcType=VARCHAR}|| '%'
    or DOC_URL like '%' ||#{docName,jdbcType=VARCHAR}|| '%'

    update DW_OUTER_MANAGE set CREATE_TIME=to_date('2020-09-25 08:02:01','yyyy-mm-dd hh24:mi:ss')  where AGENT_CODE='63002434';
