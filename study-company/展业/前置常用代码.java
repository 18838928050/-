 Map<String, Object> requestMap = RequestParamsToMap.getParameterMap(request);
 OrdOrder order = ordOrderService.queryByOrderNo(requestMap.get("orderNo") + "").get(0);
 Util.writerResponse(response, JSONUtil.object2json(ResponseVo.setData(order)));

// JSONUtil.object2json(ResponseVo.setData(order)) 把responseVo转换为json

  

 		 JSONObject json = new JSONObject();
        try {
            OuterBlackListExample outerBlackListExample = new OuterBlackListExample();
            outerBlackListExample.createCriteria().andAgentCodeEqualTo(agentCode);
            outerBlackListMapper.deleteByExample(outerBlackListExample);
            json.put("code", "1");
            json.put("msg", "");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", "0");
            json.put("msg", "系统异常");
        }
        Util.writerResponse(response, json.toString());