oracle创建表空间:
第一步： ## 查询临时表空间的路径
select name from v$tempfile; 
第二步：  ##创建表空间，名：test 
数据文件路径复制临时表空间数据文件路径然后改一下文件名就行了，大小：1G， 自动增长：50M 。 
create  tablespace  test datafile '/u01/app/oracle/oradata/XE/test.dbf' 
size 200M autoextend on next 50M;



第三步： ## 查看所有表空间，看看是否有刚才创建的
select tablespace_name from dba_tablespaces   

第四步：创建用户
create user test01 identified by testpasswd default tablespace TEST temporary tablespace TEMP; 

第五步：查看用户名，可以看到是否有刚才我们创建的用户名
select username from dba_users；


第六步：授权用户 test01，拥有连接，管理员，导入，导出权限，并可以传递权限。（根据需求自己定义权限）
grant connect,dba,exp_full_database,imp_full_database to test01 with admin option;