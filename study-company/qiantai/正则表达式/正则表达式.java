手机号校验：
<input type="number" placeholder="请输入手机号码" class="null"
data-value="undefined" id="tbrmobile" name="mobile" checkflag="true" 
checkrul="/(13\d|14[567]|15[^4,\D]|16[6]|17[01235678]|18\d|19[198])\d{8}|170[05789]\d{7}/" 
checktips="投保人手机号码有误"
maxlength="11" oninput="if(value.length>11)value=value.slice(0,11)">

其中checkrul是保存到数据库里面的


表单上这样校验：
先获得这个表达式：var reg= $("div[name='mobile']").attr("checkRul")
然后用eval：
eval(reg)
判断是否匹配：
if (!reg.test($(this).val())) {
}


eval(string) ：



身份证号：
<input type="text" placeholder="请输入证件号码" class="undefined" data-value="undefined"
id="tbrcardnum"  name="certificateNum" checkflag="true" 
checkrul="/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$)/" 
checktips="投保人证件号码有误" maxlength="18">


在输入文本框时，限制只能输入英文：
onkeydown是按下的时候bai触发的，这个时候键值没有输出来。duzhi
onkeyup是按键抬起的时候执行的，这个时候键值已经有了dao。
onkeyup="value=value.replace(/[^\d]/g,'') "      
.replace(/[^\d]/g,'') 是正则替换，把里面除了数字以外的字符全部都去掉
onbeforepaste 意思是在用户执行粘贴动作之前。
.value.replace(/[^\d]/g,'')，就是将.value内非数字的值替换为空（''）;



<input name="文本框名字" onkeyup="value=value.replace(/[^\d]/g,'') " 
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">


   //手机号
$("input[name='mobile']").each(function (){
	$(this).attr("maxlength", "11");
                //$(this).attr("type", "number");
	$(this).attr("oninput", "if(value.length>11)value=value.slice(0,11)");
	$(this).attr("onkeyup", "value=value.replace(/[^\\d\-]/g,'')");
	$(this).attr("onbeforepaste", "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d\e]/g,''))");
})

<input type="text" id="toName" placeholder="点击输入" oninput="relation00()">
oninput 事件在用户输入时触发。



"^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$"
正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"


"^(\(\d{3}-)|\d{4}-)?"

xxx-xxx-xxxx
/^\d{3}-\d{3}-\d{4}$/