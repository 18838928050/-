Oracle 利用闪回功能 恢复到某一时间点的数据。
--  打开
alter table emp enable row movement;  
-- 查询删除数据的时间点的数据（也就是闪回至该时间点之前的数据）
select * from DW_OUTER_MANAGE as of timestamp to_timestamp('2018-04-22 15:10:00','yyyy-mm-dd hh24:mi:ss');  
(如果不是，则继续缩小范围)

 
-- 执行flashback 闪回
flashback table emp to timestamp to_date('2018-04-22 15:05:55','YYYY-MM-DD HH24:MI:SS');  

如果遇到这个错误:
RA-00439: feature not enabled: Flashback Table
应该是数据库版本是个人版不是企业版的，看一下下面的sql是不是false，是true才可以用flashback,（只有企业版支持分区功能）
可以试试开启分区：Oracle未启用Partitioning功能解决（未解决）
select * from v$version;
select * from v$option where parameter = 'Partitioning';

--返回30分钟之前的数据
flashback table DW_OUTER_MANAGE to timestamp( systimestamp - 30/1440);



--不小心删除表的返回操作
drop TABLE classroom_course;
flashback table classroom_course to before drop; 



