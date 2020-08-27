	
第一种：
allkchtml+='<li onclick="courseDetail(this);" courseid="'+allCourse[i].courseId+'" labelId="'+allCourse[i].labelId+'" kjid="'+allCourse[i].ourseWareList[0].coursewareId+'">'+

function courseDetail(obj){
		var courseid=$(obj).attr("courseid");
		var kjid=$(obj).attr("kjid");
		location.href="courseDetail.do?coursewareid="+kjid+"&courseid="+courseid+"&userId="+userId+"&comcode="+comcode+"&channel="+channel;
			     //   	$('#listType_1').trigger("click");
			 }


window.location.href="/agentwap/Skip/index.do?agentCode="+agentcode+"&agentInfo="+data.enagentinfo+"";



第二种：
<a href="javascript:toPreproductInfo('/images/banner_index_206A20.jpg','东吴蜀乐保重大疾病保险','1','206A20');">
	<img src="./ShowPictures.do?imageurl=/app/ydzy_appqz_dat/banner/banner_index_206A20.jpg">
</a>

    
    function toPreproductInfo(img, name, type, code) {
        var clerkInfor = {
            "agentId": $("#agentCode").val(),
            "agentName": $("#agentName").val(),
            "agentPhone": $("#agentPhone").val()
        };
        clerkInfor = btoa(encodeURIComponent(JSON.stringify(clerkInfor)));
        if (type.indexOf("2") > -1) {
            window.location.href = $("#JYS_URL").val() + "/html/product_detail.html?productCode=" + code + "&channel=" + ${ channel } +"&clerkInfor=" + clerkInfor;
        } else if (1 == type) {
            var agentCode = '${agentCode}';
            if(code=='301020'){
                post("/product/jiyeprodetail.do",{productCode:code,"agentCode":agentCode});
            }else{
                window.location.href = "/agentwap/product/prodetail.do?productCode=" + code + "&agentCode=" + agentCode;
            }

        } else if (3 == type) {
            var agentCode = '${agentCode}';
            window.location.href = "/agentwap/Skip/lottery.do?agentCode=" + agentCode;
        }

        else {
            window.location.href = "topreproductinfo.do?img=" + img + "&riskname=" + name;
        }
    });