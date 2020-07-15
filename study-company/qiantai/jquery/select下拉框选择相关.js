检索区域下拉框改变触发的事件'change'
$('select.column_filter').on('change', function() {
    fy = true;
    pagenumber = 1;
    let optionYear = $('#optionYear option:selected').val()
    status = $("#commstatus option:selected").val();
    openstatus = $("#openstatus option:selected").val();
    var cTime = optionYear;
    ddata_manage.init();
});





重置下拉按钮：
<select  class="form-control form-control-sm select2"  name="coursewareType" id="myselect" th:field="*{coursewareType}"> 
<option value="1">视频课件</option>
<option value="2">图文课件</option>
</select>

检测到下拉框变化：
$("#myselect").change(function(){
    var opt=$("#myselect").val();
    if(opt==1){

    }else{

    }
});

编辑时回显下拉框位置：
var coursewareType=$("#myselect").val();
if(coursewareType==1){
    //当前课件视频课件
    $("#myselect").find("option[value = '"+1+"']").attr("selected","selected");
    $("#shipinContent").show();
    $("#tuwenContent").hide();
}else{
    //当前课件是图文课件
    $("#myselect").find("option[value = '"+2+"']").attr("selected","selected");
    $("#shipinContent").hide();
    $("#tuwenContent").show();
}


或者：
$("#myselect").val("1").trigger('change.select2');





后台传来的list，前台下拉框遍历:
@GetMapping("/toCoursewareList")
public String toCoursewareList(ModelMap modelMap) {
    List<ClassroomCourseLabel> courseLabels = classroomCourseLabelService.selectCourseLabelList();
    modelMap.put("courseLabels", courseLabels);
    return prefix + "/coursewareList";
}

<select name="coursewareType">
<option value="">所有</option>
<option th:each="courseLabel : ${courseLabels}" th:text="${courseLabel.labelName}"  th:value="${courseLabel.labelCode}">
</option>
</select>




<div class="form-group">
<select name="channelName">
<option value="">所有</option>
<option th:each="classroomChannel : ${classroomChannels}" th:text="${classroomChannel.channelName}"  th:value="${classroomChannel.id}"></option>
</select>
</div>


<div class="col-sm-8">
<label><input name="status" type="radio" value="1" checked/>内勤
</label> <label><input name="status" type="radio" value="0" />外勤</label>
</div>



select选中前台传过来的值：
课件类型：<select name="coursewareType">
<option value="">所有</option>
<option th:each="courseLabel : ${courseLabels}" th:text="${courseLabel.labelName}" th:selected="${type eq courseLabel.labelCode}"  th:value="${courseLabel.labelCode}"></select>