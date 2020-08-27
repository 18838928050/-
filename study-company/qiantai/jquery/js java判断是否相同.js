js:
if("00".equals(obj.getString("relateInsuredCode")) &&"1".equals(obj.getString("partyType"))){
}else if(!"00".equals(obj.getString("relateInsuredCode"))){
}





////////////////////////////////////////////////////////////////////
=====================================================================
////////////////////////////////////////////////////////////////////
java :

java的String这样写，注意前后,String类型equals和==没什么区别，写一个就行：
("306050A").equals(packageNo)
或:
packageNo == null
参考：
if("".equals(dwManageInfo.getUpComCode())||dwManageInfo.getUpComCode()==null)
this.orderNo = orderNo == null ? null : orderNo.trim();
 if("0".equals(vo.getResultCode())) {
 	 if("1".equals(flag)) {
("BQ019".equals(subType)){


java的List判断是不是为空：
List<premMonthPlan> premMonthPlan = premMonthPlanMapper.selectByExample(planExample);
if (premMonthPlan == null || premMonthPlan.isEmpty() || premMonthPlan.size()<1)
