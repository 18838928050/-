怎么获取leftList下面的classifyid="3"的li
<ul class="leftList">
<li class classifyid="1"></li>
<li class classifyid="2"></li>
<li class classifyid="3"></li>
<li class classifyid="4"></li>
</ul>

$(".leftList li[classifyid='"+classifyId+"']").addClass("active");
如果下面还有class:
$(".courseList li[kjid='"+coursewareId+"'] .tipsLeft").html(updateDate);


$(".leftListTW").find("li").click(function(){
}

模仿按钮点击:
$('#listType_1').trigger("click");