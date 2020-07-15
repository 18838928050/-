<div class="select_item relationship textselect active" 
checkflag="true" data-value="33" value="33" 
selectdata="[{&quot;value&quot;:&quot;33&quot;,&quot;text&quot;:&quot;配偶&quot;}]"
id="reInsured" name="relateInsured" style="display: block;">配偶</div>


获取这个div中的selelctdata值：
 $("div[name='relateInsured']").attr("selectdata")
 这时select的值是字符串：
 [{&quot;value&quot;:&quot;33&quot;,&quot;text&quot;:&quot;配偶&quot;}]
 下面转换成json:
 var selectdata= JSON.parse($("div[name='relateInsured']").attr("selectdata"));