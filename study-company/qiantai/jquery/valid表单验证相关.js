$("#form-coursewareContent").validate({
	onkeyup: false,
	rules: {
		coursewareTitle:{
			minlength: 5,
			required: true
		},
		coursewareAuthor:{
			required: true
		},
		duration:{
			number:true,
			required: true
		},
		coursewareDesc:{
			required: true
		}
		,
		startDate:{
			date:true,
			required: true
		}
		,
		endDate:{
			date:true,
			required: true
		}
		,

	},
	messages: {
		coursewareTitle:{
			required: "请输入课件标题"
		},
		coursewareAuthor:{
			required: "请输入作者"
		},
		duration:{
			required: "请输入时长"
		} ,
		coursewareDesc:{
			required: "请输入课件描述"
		},
		startDate:{
			required: "请输入课件有效期开始时间"
		}
		,
		endDate:{
			required: "请输入课件有效期结束时间"
		}
	}
});
function submitHandler() {
	if ($.validate.form()) {
		$.operate.save(prefix + "/editSave", $('#form-coursewareContent').serialize()
			);
	}
}


<input onclick="selectDeptTree()" id="treeName" name="treeName" 
type="text" th:field="*{deptName}" placeholder="请选择归属部门" class="form-control" required>


菜鸟教程非常好：
		https://www.runoob.com/jquery/jquery-plugin-validate.html

valid里面调用后台：

					//如果课程分类名字不能重复，用这个方法
					$("#form-classify-add").validate({
						onkeyup: false,
						rules:{
							classifyName:{
								minlength: 2,
								remote: {
									url: prefix + "/checkClassifyCourseUnique",
									type: "post",
									dataType: "json",
									data: {
										name : function() {
											return $.common.trim($("#classifyName").val());
										}
									},
									dataFilter: function(data, type) {
										return $.validate.unique(data);
									}
								}
							},
						},
						messages: {
							"classifyName": {
								remote: "该课程分类已经存在"
							}
						},
						focusCleanup: true
					}); 
