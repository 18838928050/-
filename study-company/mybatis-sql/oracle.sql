自增uuid,oracle自带：
rawtohex(sys_guid())


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


Oracle 利用闪回功能 恢复到某一时间点的数据。
--  打开
alter table emp enable row movement;  
查询删除数据的时间点的数据（也就是闪回至该时间点之前的数据）
select * from A as of timestamp to_timestamp('2018-04-22 15:10:00','yyyy-mm-dd hh24:mi:ss');  
(如果不是，则继续缩小范围)

 
-- 执行flashback 闪回
flashback table emp to timestamp to_date('2018-04-22 15:05:55','YYYY-MM-DD HH24:MI:SS');  


查询日期大于某一天的数据：
select * from DW_ATTENDANCE where agent_code in('805050107') and SIGN_IN_TIME is not null and TO_DATE(CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') > TO_DATE('2020-03-03 21:19:39', 'YYYY-MM-DD HH24:MI:SS') ORDER BY CREATE_DATE DESC
