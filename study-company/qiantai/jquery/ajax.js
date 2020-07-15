$.ajax({
	url:"courseCollect.do",
	data:{"userId":userId,"courseid":courseid},
	type:"post",
	dataType:'json',
	success:function(data){
		console.log(data);
		if(data.code=="1"){
			if(data.collect.validFalg=="1"){
				$(obj).addClass("active");
				$(obj).text("取消收藏");
			}else{
				$(obj).removeClass("active");
				$(obj).text("收藏");
			}
		}
	},
	error:function(e){
		mui.hideLoading();
		console.log(e);
	}
});


function judgeStudy(){
	console.log(1)
	$.ajax({
		url:"updateStudyIsComplete.do",
		data:{"userId":userId,"courseId":courseId,"coursewareId":coursewareId},
		type:"post",
		dataType:'json',
		success:function(data){
			if(data.count==1){
						//alert("success")
					}
				}
			});
}