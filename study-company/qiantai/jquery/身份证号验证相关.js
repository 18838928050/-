//身份证号最后一位校验
function getIDChar18(id) {
	var arr = id.split(''), sum = 0, vc = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
	for (var i = 0; i < 17; i++) sum += vc[i] * parseInt(arr[i]);
		return ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'][sum % 11];
}
function ValidID(id) {
	var c = id.charAt(17), rc = getIDChar18(id);
	if (c == rc) {
		return true;
	}else{
		return false;
	}
}

调用：
if (varType == "0") {
	if (!ValidID(cardNum)) {
		mui.alert("身份证号码有误，请核实后重新输入！");
		return;
	}
}



证件号码校验规则：
<input type="text" placeholder="请输入证件号码" class="undefined" data-value="undefined" 
id="tbrcardnum" name="certificateNum" checkflag="true" 
checkrul="/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$)/" 
checktips="投保人证件号码有误" maxlength="18">