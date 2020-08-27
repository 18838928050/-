1.获取字符串长度
var length=String.length;
2.获取前6个字符
id.substring(0,6);

3.获取分隔符后面的数据1234987
var str="030-1234987"
var arr=str.split("-")[1];


java获取第一个逗号前的数据:
String impartAnswer = notices.get(0).getImpartAnser();
String status=impartAnswer.substring(0, impartAnswer.indexOf(","));


测试string字符串是不是有“-”
反证法 如果该方法不返回-1 就证明该字符串中含有e字符
tel.indexOf("-") == -1   代表没有“-”

判断字符串1在字符串中出现的次数
('123112').split('1').length-1   结果是3


