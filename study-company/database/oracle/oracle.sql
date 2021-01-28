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


-----substr函数格式   (俗称：字符截取函数)
1、select substr('HelloWorld',0,3) value from dual; //返回结果：Hel，截取从“H”开始3个字符
2、select substr('HelloWorld',1,3) value from dual; //返回结果：Hel，截取从“H”开始3个字符
3、select substr('HelloWorld',2,3) value from dual; //返回结果：ell，截取从“e”开始3个字符
4、select substr('HelloWorld',0,100) value from dual; //返回结果：HelloWorld，100虽然超出预处理的字符串最长度，但不会影响返回结果，系统按预处理字符串最大数量返回。
5、select substr('HelloWorld',5,3) value from dual; //返回结果：oWo
6、select substr('Hello World',5,3) value from dual; //返回结果：o W (中间的空格也算一个字符串，结果是：o空格W)
7、select substr('HelloWorld',-1,3) value from dual; //返回结果：d （从后面倒数第一位开始往后取1个字符，而不是3个。原因：下面红色 第三个注解）
8、select substr('HelloWorld',-2,3) value from dual; //返回结果：ld （从后面倒数第二位开始往后取2个字符，而不是3个。原因：下面红色 第三个注解）
9、select substr('HelloWorld',-3,3) value from dual; //返回结果：rld （从后面倒数第三位开始往后取3个字符）
10、select substr('HelloWorld',-4,3) value from dual; //返回结果：orl （从后面倒数第四位开始往后取3个字符）
----instr()函数的格式  （俗称：字符查找函数）
1.select instr('helloworld','l') from dual; --返回结果：3    默认第一次出现“l”的位置
2 select instr('helloworld','lo') from dual; --返回结果：4    即“lo”同时(连续)出现，“l”的位置
3 select instr('helloworld','wo') from dual; --返回结果：6    即“w”开始出现的位置
select instr('helloworld','l',2,2) from dual;  --返回结果：4    也就是说：在"helloworld"的第2(e)号位置开始，查找第二次出现的“l”的位置
select instr('helloworld','l',3,2) from dual;  --返回结果：4    也就是说：在"helloworld"的第3(l)号位置开始，查找第二次出现的“l”的位置
select instr('helloworld','l',4,2) from dual;  --返回结果：9    也就是说：在"helloworld"的第4(l)号位置开始，查找第二次出现的“l”的位置
select instr('helloworld','l',-1,1) from dual;  --返回结果：9    也就是说：在"helloworld"的倒数第1(d)号位置开始，往回查找第一次出现的“l”的位置
select instr('helloworld','l',-2,2) from dual;  --返回结果：4    也就是说：在"helloworld"的倒数第2(l)号位置开始，往回查找第二次出现的“l”的位置
select instr('helloworld','l',2,3) from dual;  --返回结果：9    也就是说：在"helloworld"的第2(e)号位置开始，查找第三次出现的“l”的位置
select instr('helloworld','l',-2,3) from dual; --返回结果：3    也就是说：在"helloworld"的倒数第2(l)号位置开始，往回查找第三次出现的“l”的位置



常熟医保调整时间sql:
select max(TO_NUMBER(a.id)) from CS_SALE_AUTH a; 

update CS_SALE_AUTH set start_sale_time =TO_DATE('2020-10-08 15:56:55', 'YYYY-MM-DD hh24:Mi:ss') WHERE  RISK_CODE='306050B';
update CS_SALE_AUTH set end_sale_time =TO_DATE('9999-10-08 15:56:55', 'YYYY-MM-DD hh24:Mi:ss') WHERE  RISK_CODE='306050B';


oracle查询一个表有多少列：