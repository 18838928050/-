
掌上宝前置uat：
cd /app/ydzy_appqz_uat/myLog
tail -f dwrswapUat.log
掌上宝后置uat:
cd /app/ydzy_appzt_uat_domain/myLog/
tail -f dwrsmiUat.log


掌上宝前置dat：
cd /app/ydzy_appqz_dat/myLog

tail -f dwrswapDat.log
掌上宝后置dat:
cd /app/ydzy_appzt_dat_domain/myLog/
tail -f dwrsmiDat.log


建议书中台：
cd app/mid/user_projects/domains/ydzy_jyszh_dat_domain
tail -f ydzy_jyszh_dat.log


/app/ydzy_appzt_dat_domain/myLog
生产日志：

cd /app/yxprd/2020/9/25/


建议书生产日志：
cd /app/mid/user_projects/domains/jyszt_domain
tail -f planBook.log

cat -n ./dwrsmiDat.log | grep "1888" 定位错误的行数

cat -n ./dwrsmiDat.log | tail -n +8050|head -n 5  
cat -n ./MServer_Ywzsbqz1_Weblogic.log | grep "本机的IP"
cat -n ./MServer_Ywzsbqz1_Weblogic.log | grep "执行会议计划消息提醒"


cat -n ./MServer_Ywzsbqz2_Weblogic.log | grep "访问接口:"

cat -n ./dwrsmiDat.log | grep "过滤掉异常数据后的数据库查询结果"
cat -n ./dwrsmiPrd.log.2020-11-11.log | grep "推送双录信息成功---订单号：2020111115172243205"
cat -n ./dwrsmiPrd.log.2020-11-11.log | grep "推送双录信息成功---订单号：20201111659231"

"推送双录信息成功---订单号：2020111115172243205"

查看linux历史命令：
history

weblogic:
移动展业dat后置：
  cd /app/mid/user_projects/domains/ydzy_appzt_dat_domain/bin/
  ./stopWebLogic.sh 
   nohup ./startWebLogic.sh &
移动展业uat后置：
  cd /app/mid/user_projects/domains/ydzy_appzt_uat_domain/bin
  ./stopWebLogic.sh 
   nohup ./startWebLogic.sh &

 移动展业dat前置：
  cd /app/mid/user_projects/domains/ydzy_jysqz_dat_domain/bin
   ./stopWebLogic.sh 
   nohup ./startWebLogic.sh &

 移动展业uat前置：
 cd /app/mid/user_projects/domains/ydzy_jysqz_uat_domain/bin/
  ./stopWebLogic.sh 
   nohup ./startWebLogic.sh &