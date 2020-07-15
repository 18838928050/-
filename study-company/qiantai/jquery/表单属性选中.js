<div class="select_item relationship textselect active" 
checkflag="true" data-value="33" value="33" 
selectdata="[{&quot;value&quot;:&quot;33&quot;,&quot;text&quot;:&quot;配偶&quot;}]"
id="reInsured" name="relateInsured" style="display: block;">配偶</div>

获取这个div中的selelctdata值：
 $("div[name='relateInsured']").attr("selectdata")
 获取这个div中的value值：
  $("div[name='relateInsured']").attr("value")
