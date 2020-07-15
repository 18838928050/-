Map<String,Object> requestMap = RequestParamsToMap.getParameterMap(request);
requestMap.put("agentCode", json.getString("agentCode"));
rv = HttpClientUtil.HttpRequest(RequestURL.API_PRODUCT_LIST, requestMap);



@RequestMapping("/productList.do")
public void productList(HttpServletRequest request,HttpServletResponse response) throws Exception{
	Map<String,Object> requestMap = RequestParamsToMap.getParameterMap(request);
	List<PmProductVo> rs = pmProductService.queryPmProductByChannel(requestMap.get("agentCode")+"");
	Util.writerResponse(response, JSONUtil.object2json(ResponseVo.setData(rs)));
}



将string对象转换为jsonObject,{'a':'a','b','b'}
JSONObject json = JSON.parseObject(AESUtil.decrypt(agentinfo));



String responseMessage = HttpClientUtil.HttpRequest传来的是string类型的数组或对象

	JSONObject json = JSONObject.parseObject(responseMessage);
	或：
	JSONObject json = JSONObject.fromObject(responseMessage);