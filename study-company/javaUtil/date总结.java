//从后台取出的date为UTC 2016-10-26T08:20:53.131252Z,转换为yyyy-MM-dd HH:mm:ss
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String createTime = simpleDateFormat.format(csSbInfo.getCreateTime());