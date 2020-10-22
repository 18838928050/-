//从后台取出的date为UTC 2016-10-26T08:20:53.131252Z,转换为yyyy-MM-dd HH:mm:ss
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String createTime = simpleDateFormat.format(csSbInfo.getCreateTime());

获取当前的前十分钟的时间：
Date now = new Date();
Date now_10 = new Date(now.getTime() - 600000); //10分钟前的时间
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
String nowTime_10 = dateFormat.format(now_10);