添加页面时不用做js判断
<div class="col-sm-8">
<label><input name="status" type="radio" value="1" checked/>正常
</label> <label><input name="status" type="radio" value="0" />停用</label>
</div>


编辑回显时：
<div class="col-sm-8">
	<div class="form-check form-check-inline" id="needradio">
		<input class="form-check-input" type="radio" name="statu" id="inlineRadio1" value="1"  >
		<label class="form-check-label" for="inlineRadio1">正常</label>
		<input class="form-check-input" type="radio" name="statu" id="inlineRadio2" value="2"  >
		<label class="form-check-label" for="inlineRadio2">停用</label>
	</div>
</div>

//单选按钮的值回显到页面上
<input type="text" id="status" class="form-control"	name="status" style="display:none;" th:field="*{status}"> 
var status=$("#status").val();
			if(status==1){
				//是
				$("#inlineRadio2").removeAttr("checked");
				$("#inlineRadio1").attr("checked","checked");    
			}else{
				//否
				$("#inlineRadio1").removeAttr("checked");
				$("#inlineRadio2").attr("checked","checked");  
			}



			//radio按钮选择后监听
			$('#needradio :radio').click(function(){
				var value = $('input:radio[name="statu"]:checked').val();
				//获取选中的radio的值
				$("#status").val(value)
			});