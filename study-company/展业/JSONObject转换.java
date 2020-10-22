parseObject和fromObject的区别：
com.alibaba.fastjson.JSONObject.parseObject
net.sf.json.fromObject
用fromObject好一些，比较好用



/**
***java对象转换为JSONObject:
*/
OrdOrder ordOrder = new OrdOrder();
ordOrder.setAccBankCode("bankcode");
ordOrder.setAccBankName("bankname");

//方法一：
String s = JSONUtil.object2json(ordOrder);
System.out.println(s);
//输出结果如下
//{"accBankCode":"bankcode","accBankName":"bankname","acceptStatus":"","accname":"","accno":"","acctype":"","achievementChannel":"","actualAmount":"","agreeMent":"","agreement":"","amount":"","asyncFlag":"","asyncKey":"","audioVideoFlag":"0","bonusGetAge":"","bonusGetFlag":"","bonusGetType":"","cancelStatus":"","disposeOrNot":"","disputesDisposeContent":"","doublePushFlag":"","eMail":"","empNo":"","guardianCode":"","guardianName":"","guardianValue":"","highRiskSign":"","id":"","insuranceCode":"","insureCode":"","insureName":"","insureValue":"","isAutoDeduct":"","isAutoInsurance":"","isAutoLoan":"","isCoreWithhold":"","isNeedSlu":"","isOtherSec":"","lqAccBankCode":"","lqAccBankName":"","lqAccName":"","lqAccno":"","nextAccBankCode":"","nextAccBankName":"","nextAccname":"","nextAccno":"","nextAcctype":"","nextOpenBankCity":"","nextOpenBankProvince":"","note":"","openBankCity":"","openBankProvince":"","orderCreateTime":"","orderNo":"","orderType":"","otherStatus":"","packageNo":"","payNoticeNum":"","payStatus":"","paySuccessTime":"","payTime":"","payeeType":"","policyCode":"","policyCount":"","policyOptions":"","sbLocation":"","sbPrem":"","sbno":"","scanDate":"","scanTime":"","sdate":"","selfInsurancedFlag":"","tdate":"","underWritingStatus":"","uploadStatus":""}

//方法二：好用
JSONObject json = JSONObject.fromObject(ordOrder);
System.out.println(json);
//输出结果如下
//{"nextOpenBankProvince":"","orderType":"","isOtherSec":"","accBankName":"bankname","audioVideoFlag":"0","payTime":"","cancelStatus":"","disposeOrNot":"","scanTime":"","accno":"","lqAccBankCode":"","payeeType":"","selfInsurancedFlag":"","uploadStatus":"","isCoreWithhold":"","eMail":"","nextAccno":"","policyOptions":"","achievementChannel":"","id":0,"insureValue":"","bonusGetFlag":"","nextOpenBankCity":"","nextAcctype":"","underWritingStatus":"","sdate":"","agreement":"","orderNo":"","orderCreateTime":"","lqAccName":"","acceptStatus":"","scanDate":"","agreeMent":"","disputesDisposeContent":"","tdate":"","isAutoDeduct":"","asyncKey":"","asyncFlag":"","isAutoInsurance":"","nextAccBankName":"","insureName":"","note":"","bonusGetAge":"","highRiskSign":"","openBankCity":"","isNeedSlu":"","lqAccno":"","policyCode":"","doublePushFlag":"","packageNo":"","insuranceCode":"","openBankProvince":"","sbPrem":0,"nextAccBankCode":"","guardianName":"","guardianValue":"","insureCode":"","paySuccessTime":"","accname":"","accBankCode":"bankcode","amount":0,"lqAccBankName":"","sbno":"","actualAmount":0,"empNo":"","acctype":"","otherStatus":"","payNoticeNum":"","bonusGetType":"","policyCount":0,"guardianCode":"","isAutoLoan":"","payStatus":"","sbLocation":"","nextAccname":""}
//获取nextOpenBankProvince：
json.getString(nextOpenBankProvince);

//方法三
com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(JSONUtil.bean2json(ordOrder));
System.out.println(json);





/**
***String类型转换为JSONObject
*/
String bb =  "{\"userName\":\"admin\"}";
JSONObject aa = JSONObject.fromObject(bb);
System.out.println(aa);
//输出结果如下
//{"userName":"admin"}


/**
***List类型转换为JSONArray
*/
List<OrdOrder> ordOrders = new ArrayList<>();
ordOrders.add(ordOrder);
ordOrders.add(ordOrder);
JSONArray jsonArray = JSONArray.fromObject(ordOrders);
System.out.println(jsonArray);
        //输出结果如下

//[{"nextOpenBankProvince":"","orderType":"","isOtherSec":"","accBankName":"bankname","audioVideoFlag":"0","payTime":"","cancelStatus":"","disposeOrNot":"","scanTime":"","accno":"","lqAccBankCode":"","payeeType":"","selfInsurancedFlag":"","uploadStatus":"","isCoreWithhold":"","eMail":"","nextAccno":"","policyOptions":"","achievementChannel":"","id":0,"insureValue":"","bonusGetFlag":"","nextOpenBankCity":"","nextAcctype":"","underWritingStatus":"","sdate":"","agreement":"","orderNo":"","orderCreateTime":""},
//{"nextOpenBankProvince":"","orderType":"","isOtherSec":"","accBankName":"bankname","audioVideoFlag":"0","payTime":"","cancelStatus":"","disposeOrNot":"","scanTime":"","accno":"","lqAccBankCode":"","payeeType":"","selfInsurancedFlag":"","uploadStatus":"","isCoreWithhold":"","eMail":"","nextAccno":"","policyOptions":"","achievementChannel":"","id":0,"insureValue":"","bonusGetFlag":"","nextOpenBankCity":"","nextAcctype":"","underWritingStatus":"","sdate":"","agreement":"","orderNo":"","orderCreateTime":""}]
//获取第一个json里面的accBankname的值：
String accBankName = (String) jsonArray.getJSONObject(0).get("accBankName");
System.out.println(accBankName);
//获取第一个jsonObject:
JSONObject obj = jsonArray.getJSONObject(0);
System.out.println(obj);
//输出：{"nextOpenBankProvince":"","orderType":"","isOtherSec":"","accBankName":"bankname","audioVideoFlag":"0","payTime":"","cancelStatus":"","disposeOrNot":"","scanTime":"","accno":"","lqAccBankCode":"","payeeType":"","selfInsurancedFlag":"","uploadStatus":"","isCoreWithhold":"","eMail":"","nextAccno":"","policyOptions":"","achievementChannel":"","id":0,"insureValue":"","bonusGetFlag":"","nextOpenBankCity":"","nextAcctype":"","underWritingStatus":"","sdate":"","agreement":"","orderNo":"","orderCreateTime":"","lqAccName":"","acceptStatus":"","scanDate":"","agreeMent":"","disputesDisposeContent":"","tdate":"","isAutoDeduct":"","asyncKey":"","asyncFlag":"","isAutoInsurance":"","nextAccBankName":"","insureName":"","note":"","bonusGetAge":"","highRiskSign":"","openBankCity":"","isNeedSlu":"","lqAccno":"","policyCode":"","doublePushFlag":"","packageNo":"","insuranceCode":"","openBankProvince":"","sbPrem":0,"nextAccBankCode":"","guardianName":"","guardianValue":"","insureCode":"","paySuccessTime":"","accname":"","accBankCode":"bankcode","amount":0,"lqAccBankName":"","sbno":"","actualAmount":0,"empNo":"","acctype":"","otherStatus":"","payNoticeNum":"","bonusGetType":"","policyCount":0,"guardianCode":"","isAutoLoan":"","payStatus":"","sbLocation":"","nextAccname":""}


/**
***JSONObject 转换为String:
*/
JSONObject json = new JSONObject();
json.put("code", "0");
json.put("msg", "节日提醒列表为空");
String json2 = com.alibaba.fastjson.JSONObject.parseObject(String.valueOf(json)).toString();
System.out.println(json2);
//输出：{"msg":"节日提醒列表为空","code":"0"}


// JSON.parseObject的几种用法
一.result格式:
{    
   "success":"true";  
   "returnAddress":"123"
 }

JSONObject jsonObject=JSON.parseObject(result);      //转换成object  
jsonObject.getString("returnAddress")    //获取object中returnAddress字段;      

getString("returnAddress")    //获取object中returnAddress字段;                                                       


二.result格式
{   
      "success":"true";   
      "data":{        
               "shop_uid":"123";  
              };
 }

 JSONObject shop_user =JSON.parseObject(result); 
 JSON.parseObject(shop_user .getString("data")).getString("shop_uid")


 {   
      "success":"true";   
      "data":{        
               "shop_uid":"123";  
                 {         "shop_name":"张三"     }
              };
 }


三.result格式
{     "success":"true";     "data":[{         "shop_uid":"123";     },     {         "shop_name":"张三"     }]}

JSONArray detail = JSON.parseArray(result);
for (int i=0; i<detail.size();i++){  
  if(detail.get(i)!=null||!detail.get(i).equals("")){   
     JSONArray detailChild =detail.getJSONArray(i);        
        if(detailChild.getInteger(1)>Integer.valueOf(ship.get("shiptime").toString())){
            ship.put("shiptime",detailChild.getInteger(1));           
            ship.put("desc",detailChild.getString(0));       
            }     
         }
      }