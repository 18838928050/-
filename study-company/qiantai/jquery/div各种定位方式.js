<div class="select_item relationship textselect active" 
checkflag="true" data-value="33" value="33" 
selectdata="[{&quot;value&quot;:&quot;33&quot;,&quot;text&quot;:&quot;配偶&quot;}]"
id="reInsured" name="relateInsured" style="display: block;">配偶</div>


name定位：
 $("div[name='paymentType']")

id定位：
$("#paymentType")


设置值：
$("ul li:eq(2)").attr("title","胡歌");
alert($("ul li:eq(2)").attr("title"));//结果：胡歌
	

input定位：
	$("input[name='basePremium']")

 var dangci= $("div[riskcode='207020']").children().find("div[name='level']").attr("value");
 attr是jquery的方法
 getAttribute是js的方法
