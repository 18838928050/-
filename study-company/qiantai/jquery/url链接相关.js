	
第一种：
allkchtml+='<li onclick="courseDetail(this);" courseid="'+allCourse[i].courseId+'" labelId="'+allCourse[i].labelId+'" kjid="'+allCourse[i].ourseWareList[0].coursewareId+'">'+

function courseDetail(obj){
		var courseid=$(obj).attr("courseid");
		var kjid=$(obj).attr("kjid");
		location.href="courseDetail.do?coursewareid="+kjid+"&courseid="+courseid+"&userId="+userId+"&comcode="+comcode+"&channel="+channel;
			     //   	$('#listType_1').trigger("click");
			 }


window.location.href="/agentwap/Skip/index.do?agentCode="+agentcode+"&agentInfo="+data.enagentinfo+"";
