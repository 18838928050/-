httpclinet用于在系统之间进行交互，传递参数
HttpClient 是Apache HttpComponents 下的子项目，用来提供高效的、最新的、功能丰富的支持 HTTP 协议的客户端编程工具包，并且它支持 
HTTP 协议最新的版本和建议。HttpClient 不是浏览器，它是一个客户端 HTTP 协议传输类库。HttpClient 被用来发送和接受 HTTP 消息。
HttpClient 不会处理 HTTP 消息的内容，不会进行 javascript 解析，不会关心 content type，如果没有明确设置，HttpClient 
也不会对请求进行格式化、重定向 url，或者其他任何和 HTTP 消息传输相关的功能。


PrintWriter类详解：
https://blog.csdn.net/Dream_Ryoma/article/details/80873718
1.java.io.PrintWriter是java中很常见的一个类，
该类可用来创建一个文件并向文本文件写入数据。可以理解为java中的文件输出，java中的文件输入则是java.io.File。

   try {
            //查询个人详细信息
             rv = CSYBInterfaceUtil.querySbNo(request,orderNo,ordparty);

             if ("1".equals(rv.getResultCode())) {

                WebServiceClientUtil.readXml2RV5(rv, "HEAD", "ERROR", "ERRCODE","ERRMSG", "BODY");
                Object str = rv.getResponseObject();

                if(str != null && !"".equals(str)){
                    net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(str);
                    //查询该订单是否已经保存过个人信息
                    List<CsSbInfo> csSbInfos = csSbInfoService.selectCSInfoByOrderNo(orderNo);
                    CsSbInfo csSbInfo = null;
                    if(csSbInfos.size()>0){
                         csSbInfo = csSbInfos.get(0);
                    }
                    if(!"".equals(obj)) {
                        net.sf.json.JSONObject acoa = obj.getJSONObject("OUT").getJSONObject("AC0A");
                        sbno = acoa.getString("DAC001");
                        responseVo.setResponseObject(sbno);
                        //如果保存过个人信息，更新
                        if(csSbInfo != null){
                            logger.info("开始更新个人信息...........");
                            csSbInfo.setSbno(acoa.getString("DAC001"));//社保编号
                            csSbInfo.setIdno(acoa.getString("AAE135"));//身份证号
                            csSbInfo.setUpdateTime(new Date());
                            csSbInfoService.updateCsSbInfo(csSbInfo,orderNo);
                            logger.info("更新个人信息成功...........");
                        }else{
                            CsSbInfo csSbInfo2 = new CsSbInfo();
                            csSbInfo2.setOrderNo(orderNo);
                            csSbInfo2.setInsuranceCode(insuranceNo);
                            csSbInfo2.setSbno(acoa.getString("DAC001"));
                            csSbInfo2.setIdno(acoa.getString("AAE135"));
                            csSbInfo2.setPayStatus("0");//未支付
                            csSbInfo2.setCreateTime(new Date());
                            csSbInfoMapper.insert(csSbInfo2);
                        }
                     }

                }else{
                    //该身份证号在社保局查不到信息
                    sbno = "";
                    responseVo.setResultCode("0");
                    responseVo.setResponseObject("");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }