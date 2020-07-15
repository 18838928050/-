

$(".collectionBtn").addClass("active");
$(".collectionBtn").text("取消收藏");
$("#rod").css({"width": scaleVal +"%"});


//每3秒执行一次
ref = setInterval(function(){
	if(newComplete==1){
		consoleLog();
	}
},3000); 


$("#shipinContent").hide();
$("#tuwenContent").show(); 

