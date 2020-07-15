后台传json数组给前台

下面是websocket方式
后台：
	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId,@PathParam("courseId") String courseId) {
		this.session = session;
		this.userId = userId;
		if (StringUtil.isNotEmpty(userId)) {
			if (users.get(userId) == null) {
				users.put(userId, session);
			    if (session != null) {
					if (session.isOpen()) {
						try {
							studyService = applicationContext.getBean(IClassroomUserstudyService.class);
							List<Map<String,Object>> list = studyService.getUserStudyCourseWareList(userId, courseId);
							JSONArray array=JSONArray.parseArray(JSON.toJSONString(list));
							
							session.getBasicRemote().sendText(array+"");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					System.out.println("用户:"+userId+",socket出错");
				}

			}
		}
	}
	

前台：
 //接收到消息的回调方法
	        websocket.onmessage = function(event){
	        	var data=JSON.parse(event.data)
				if(event.data==null){
					$("#kjstep").text("0");
					$(".courseList li[kjid='"+coursewareId+"'] .tipsRight").html("继续学习");
		        	$(".courseList li[kjid='"+coursewareId+"'] .tipsLeft").html("待学习");
				}	      			
	        	for(i=0;i<data.length;i++){
	        		var obj=data[i];
	        		var isComplete=obj.IS_COMPLETE;
	        		var coursewareId=obj.COURSEWARE_ID;
	        		var studyCount=obj.STUDYCOUNT;
	        		
	        		var datetime = new Date();
	        	    datetime.setTime(obj.UPDATE_DATE);
	        	    var month = datetime.getMonth() + 1;
	        	    var date = datetime.getDate();
	        	    var updateDate="上次学习"+month+"月"+today+"日";
	        		if(isComplete==0){
		        		//继续学习
		        		$(".courseList li[kjid='"+coursewareId+"'] .tipsRight").html("继续学习");
			        	$(".courseList li[kjid='"+coursewareId+"'] .tipsLeft").html(updateDate);
		        	}else{
		        		//已学完
		        		$(".courseList li[kjid='"+coursewareId+"'] .tipsRight").html("已学完");
			        	$(".courseList li[kjid='"+coursewareId+"'] .tipsLeft").html(updateDate);
		        	} 
	        	}
	        };

