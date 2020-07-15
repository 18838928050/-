package com.allianity.common.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.allianity.entity.BaseBody;
import com.allianity.entity.ESB;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JSONUtil {
  private static Log log = LogFactory.getLog(JSONUtil.class);
  public static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, // 输出空置字段
      SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
      SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
      SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
      SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
      };
  
  /**
   * CSQ+CUS+PUB请求报文拼接
   * 
   * @param esb节点
   * @param 实际业务场景的 requestBody节点
   * @return 直接返回JSON格式字符串
   */
  public static String CCPRequest(ESB esb, BaseBody requestBody) {
      com.alibaba.fastjson.JSONObject ccpRequest = new com.alibaba.fastjson.JSONObject();
      // 根节点
      LinkedHashMap<String, Object> root = new LinkedHashMap<String, Object>();
      // TXLife是父节点
      LinkedHashMap<String, Object> TXLife = new LinkedHashMap<String, Object>();
      // TXLifeRequest是TXLife的子节点
      LinkedHashMap<String, Object> TXLifeRequest = new LinkedHashMap<String, Object>();
      // ESB和RequestBody是平行节点,都是TXLifeRequest的子节点
      TXLifeRequest.put("ESB", esb);
      TXLifeRequest.put("Conditions", requestBody);
      TXLife.put("TXLifeRequest", TXLifeRequest);
      root.put("TXLife", TXLife);
      ccpRequest.putAll(root);
      return com.alibaba.fastjson.JSON.toJSONString(ccpRequest,SerializerFeature.DisableCircularReferenceDetect); 
  }
  
  /**
   * 判断CSQ+CUS+PUB返回报文是否成功
   * 
   * @param response 返回报文
   * @return
   */
  public static boolean CCPIsSuccess(String response) {
      boolean fla = false;
      com.alibaba.fastjson.JSONObject result = com.alibaba.fastjson.JSON.parseObject(response);
      try {
          // 获取各个子节点
    	  com.alibaba.fastjson.JSONObject TXLife = (com.alibaba.fastjson.JSONObject) result.get("TXLife");
    	  com.alibaba.fastjson.JSONObject TXLifeResponse = (com.alibaba.fastjson.JSONObject) TXLife.get("TXLifeResponse");
    	  com.alibaba.fastjson.JSONObject TransResult = (com.alibaba.fastjson.JSONObject) TXLifeResponse.get("TransResult");
          // CSQ+CUS+PUB的成功标志1为成功 2为失败
          String res = TransResult.getString("ResultCode");
          if ("1".equals(res)) {
              fla = true;
          } else {
              fla = false;
          }
      } catch (Exception e) {
//          logger.error(Utils.getDetailException(e));
      }

      return fla;
  }


  private static ObjectMapper mapper = new ObjectMapper();

//将Java对象转换成json
  public static String object2json(Object obj) {
    StringBuilder json = new StringBuilder();
    try {
      if (obj == null) {
        json.append("\"\"");
      } else if (obj instanceof String || obj instanceof Integer || obj instanceof Float
          || obj instanceof Boolean || obj instanceof Short || obj instanceof Double
          || obj instanceof Long || obj instanceof BigDecimal || obj instanceof BigInteger
          || obj instanceof Byte || obj instanceof Date) {
        json.append("\"").append(string2json(obj.toString())).append("\"");
      } else if (obj instanceof Object[]) {
        json.append(array2json((Object[]) obj));
      } else if (obj instanceof List) {
        json.append(list2json((List<?>) obj));
      } else if (obj instanceof Map) {
        json.append(map2json((Map<?, ?>) obj));
      } else if (obj instanceof Set) {
        json.append(set2json((Set<?>) obj));
      } else {
        json.append(bean2json(obj));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return json.toString();
  }

  public static String bean2json(Object bean) {
    StringBuilder json = new StringBuilder();
    json.append("{");
    PropertyDescriptor[] props = null;
    try {
      props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
    } catch (IntrospectionException e) {}
    if (props != null) {
      for (int i = 0; i < props.length; i++) {
        try {
          String name = object2json(props[i].getName());
          String value = object2json(props[i].getReadMethod().invoke(bean));
          json.append(name);
          json.append(":");
          json.append(value);
          json.append(",");
        } catch (Exception e) {}
      }
      json.setCharAt(json.length() - 1, '}');
    } else {
      json.append("}");
    }
    return json.toString();
  }

  public static String list2json(List<?> list) {
    StringBuilder json = new StringBuilder();
    json.append("[");
    if (list != null && list.size() > 0) {
      for (Object obj : list) {
        json.append(object2json(obj));
        json.append(",");
      }
      json.setCharAt(json.length() - 1, ']');
    } else {
      json.append("]");
    }
    return json.toString();
  }

  public static String array2json(Object[] array) {
    StringBuilder json = new StringBuilder();
    json.append("[");
    if (array != null && array.length > 0) {
      for (Object obj : array) {
        json.append(object2json(obj));
        json.append(",");
      }
      json.setCharAt(json.length() - 1, ']');
    } else {
      json.append("]");
    }
    return json.toString();
  }

  public static String map2json(Map<?, ?> map) {
    StringBuilder json = new StringBuilder();
    json.append("{");
    if (map != null && map.size() > 0) {
      for (Object key : map.keySet()) {
        json.append(object2json(key));
        json.append(":");
        json.append(object2json(map.get(key)));
        json.append(",");
      }
      json.setCharAt(json.length() - 1, '}');
    } else {
      json.append("}");
    }
    return json.toString();
  }

  public static String set2json(Set<?> set) {
    StringBuilder json = new StringBuilder();
    json.append("[");
    if (set != null && set.size() > 0) {
      for (Object obj : set) {
        json.append(object2json(obj));
        json.append(",");
      }
      json.setCharAt(json.length() - 1, ']');
    } else {
      json.append("]");
    }
    return json.toString();
  }

  public static String string2json(String s) {
    if (s == null) return "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      switch (ch) {
        case '\'':
          sb.append("\\\'");
          break;
        case '"':
          sb.append("\\\"");
          break;
        case '\\':
          sb.append("\\\\");
          break;
        case '\b':
          sb.append("\\b");
          break;
        case '\f':
          sb.append("\\f");
          break;
        case '\n':
          sb.append("\\n");
          break;
        case '\r':
          sb.append("\\r");
          break;
        case '\t':
          sb.append("\\t");
          break;
        case '/':
          sb.append("\\/");
          break;
        default:
          if (ch >= '\u0000' && ch <= '\u001F') {
            String ss = Integer.toHexString(ch);
            sb.append("\\u");
            for (int k = 0; k < 4 - ss.length(); k++) {
              sb.append('0');
            }
            sb.append(ss.toUpperCase());
          } else {
            sb.append(ch);
          }
      }
    }
    return sb.toString();
  }

  public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    try {
      JSONArray jsonArr = JSONArray.fromObject(jsonStr);
      Iterator<JSONObject> it = jsonArr.iterator();
      while (it.hasNext()) {
        JSONObject json2 = it.next();
        list.add(parseJSON2Map(json2.toString()));
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public static Map<String, Object> parseJSON2Map(String jsonStr) {
    Map<String, Object> map = new HashMap<String, Object>();
    // 最外层解析
    try {
      JSONObject json = JSONObject.fromObject(jsonStr);
      for (Object k : json.keySet()) {
        Object v = json.get(k);
        // 如果内层还是数组的话，继续解析
        if (v instanceof JSONArray) {
          List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
          Iterator<JSONObject> it = ((JSONArray) v).iterator();
          while (it.hasNext()) {
            JSONObject json2 = it.next();
            list.add(parseJSON2Map(json2.toString()));
          }
          map.put(k.toString(), list);
        } else {
          map.put(k.toString(), v);
        }
      }
      return map;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<NameValuePair> parseJSON2NvpList(String jsonStr) {
	  List<NameValuePair> list = new ArrayList<NameValuePair>();
	  // 最外层解析
	  try {
		  JSONObject json = JSONObject.fromObject(jsonStr);
		  NameValuePair nvp = null;
		  for (Object k : json.keySet()) {
			  Object v = json.get(k);
			  // 如果内层还是数组的话，继续解析
			  if (v instanceof JSONArray) {
				  throw new Exception("转换失败，暂不支持JSON数组转换");
			  } else {
				  nvp = new NameValuePair(k.toString(),v.toString());
				  list.add(nvp);
			  }
		  }
		  return list;
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return null;
  }

  public static List<org.apache.http.NameValuePair> parseJSON2NvpList2(String jsonStr) {
	  List<org.apache.http.NameValuePair> list = new ArrayList<org.apache.http.NameValuePair>();
	  // 最外层解析
	  try {
		  JSONObject json = JSONObject.fromObject(jsonStr);
		  org.apache.http.NameValuePair nvp = null;
		  for (Object k : json.keySet()) {
			  Object v = json.get(k);
			  // 如果内层还是数组的话，继续解析
			  if (v instanceof JSONArray) {
				  throw new Exception("转换失败，暂不支持JSON数组转换");
			  } else {
				  nvp = new BasicNameValuePair(k.toString(),v.toString());
				  list.add(nvp);
			  }
		  }
		  return list;
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return null;
  }

  public static Object jsonToObject(String json, Class clazz) {
    JSONObject obj = JSONObject.fromObject(json);
    return JSONObject.toBean(obj, clazz);
  }

  public static Object jsonToObject(String json, Class clazz, Map map) {
    JSONObject obj = JSONObject.fromObject(json);
    if (map == null || map.isEmpty()) {
      return JSONObject.toBean(obj, clazz);
    }
    return JSONObject.toBean(obj, clazz, map);
  }

  public static String beanToJson(Object obj, JsonConfig config) {
    JSONObject jsonArray = null;
    if (config == null) {
      return beanToJson(obj);
    } else {
      jsonArray = JSONObject.fromObject(obj, config);
    }
    return jsonArray.toString();
  }

  public static String beanToJson(Object obj) {
    JSONObject jsonObject = JSONObject.fromObject(obj);
    return jsonObject.toString();
  }

  public static boolean isGoodJson(String json) {
    if (StringUtils.isBlank(json)) {
      return false;
    }
    try {
      new JsonParser().parse(json);
      return true;
    } catch (JsonParseException e) {
      System.out.println("bad json: " + json);
      return false;
    }
  }

  /**
   * 把Java对象转换为JSON数据格式
   * 
   * @param object
   * @return
   */
  public static String getJson(Object object) {
    try {
      Writer strWriter = new StringWriter();
      mapper.writeValue(strWriter, object);
      String dataJson = strWriter.toString();
      return dataJson;
    } catch (Exception e) {
      // logger.error("[JsonUtils]Fail to getjson", e);
    }

    return null;
  }

  /**
   * 将content转为java object
   * 
   * @param <T> 参数
   * @param pContent 参数
   * @param pObj 参数
   * @throws JsonParseException 异常
   * @throws JsonMappingException 异常
   * @throws IOException 异常
   * @return Object
   */
  @SuppressWarnings("unchecked")
  public static <T> Object readValue1(String pContent, Object pObj) throws JsonParseException,
      JsonMappingException, IOException {
    return JSONUtil.mapper.readValue(pContent, (Class<T>) pObj);
  }

  /**
   * 把JSON数据格式转换为JAVA对象
   * 
   * @param <T>
   * @param jsonData
   * @param clz
   * @return
   */
  public static <T> T readValue(String jsonData, Class<T> clz) {
    try {
      return mapper.readValue(jsonData, (Class<T>) clz);
    } catch (Exception e) {
      log.error("[JsonUtils]Fail to convert json to object: " + jsonData, e);
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 将object转为json字符串
   * 
   * @param pObj 参数
   * @throws IOException 异常
   * @throws JsonMappingException 异常
   * @throws JsonGenerationException 异常
   * @return String
   */
  public static String writeValue(Object pObj) throws JsonGenerationException,
      JsonMappingException, IOException {
	  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  mapper.getSerializationConfig();
    return  mapper.writeValueAsString(pObj);
  }

  public static void main(String[] args) {

    String str = "{dayRange:5,changeRateGt:'20',changeRateLt:'-20'}";
    if (isGoodJson(str)) {
      System.out.println(str + " is good json");
    } else {
      System.out.println(str + " is bad json");
    }
  }

}
