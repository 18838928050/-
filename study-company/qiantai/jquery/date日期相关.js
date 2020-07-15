
日期：获取当前年份
let cTime = new Date().getFullYear();

计算时间间隔currentTimeMillis()
System.currentTimeMillis()


Js获取当前年月日
jjfatime = new Date();
jjfatime = jjfatime.getFullYear() + "-" + (jjfatime.getMonth() + 1) + "-" + jjfatime.getDate();
Html中考试时长
var examStartDate=new Date();
var examEndDate=new Date();
var duration=betweenSeconds(examStartDate,examEndDate);
//这个方法是获取开始时间和结束时间间隔了多少秒

function betweenSeconds(date1,date2){
			 var date3=date2.getTime() - new Date(date1).getTime();
			 var seconds=Math.floor(date3/1000);
			 return seconds;
}
//这个方法计算出相差的标准时间
function betweenTime(date1,date2){
			 var date3=date2.getTime() - new Date(date1).getTime();
			//计算出相差天数
	        var days=Math.floor(date3/(24*3600*1000))
	 
	        //计算出小时数
	        var leave1=date3%(24*3600*1000)    //计算天数后剩余的毫秒数
	        var hours=Math.floor(leave1/(3600*1000))
	        //计算相差分钟数
	        var leave2=leave1%(3600*1000)        //计算小时数后剩余的毫秒数
	        var minutes=Math.floor(leave2/(60*1000))
	        //计算相差秒数
	        var leave3=leave2%(60*1000)      //计算分钟数后剩余的毫秒数
	        var seconds=Math.round(leave3/1000)
	        alert(" 相差 "+days+"天 "+hours+"小时 "+minutes+" 分钟"+seconds+" 秒")
			}