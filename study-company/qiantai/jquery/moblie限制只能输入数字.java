
只能输入数字的文本框：
<input onkeyup="this.value=this.value.replace(/\D/g,'')" onblur="this.value=this.value.replace(/\D/g,'')"/>
只能输入数字和小数点的文本框：
<input onkeyup="value=value.replace(/[^\d\.]/g,'')" onblur="value=value.replace(/[^\d\.]/g,'')"/>

只能输入数字且只能有一个小数点的文本框（小数点不能在开头，可以在结尾，第一位允许添加负号即浮点数）：
<input onkeyup="onlyNumber(this)" onblur="onlyNumber(this)" />


正则表达式横线：
[a-z\-]