表：


SELECT * FROM LI_PM_PRODUCT_ACHIEVEMENT where  RISK_CODE = '201A10' ;
SELECT * FROM LI_PM_PRODUCT_ORG WHERE PRODUCT_CODE='201A10';
SELECT * FROM LI_PM_PRODUCT_ATTR WHERE PRODUCT_CODE='201A10' ;
SELECT * FROM LI_PM_PRODUCT_SALE WHERE RISKCODE='201A10';
li_ord_payinfo：支付流水，支付状态，mqid是business_no

DW_OUTER_MANAGE :AGENT_COM:中介机构代码  MANAGE_COM:管理机构
LI_CONFIG_INFO：掌上宝相关配置

DW_RENEWAL -- 续期信息表  CONTNO：保单号（相当于insurance_no）  ORDERNO：流水号
--select * from dw_renewal where cont_no ='0000318668211888'
DW_RENEWAL_SHARE  --回执回销表  CONTNO：保单号（相当于policy_code） AGENTCODE:工号  DEAL_TYPE =1 代表已经回执回销了

--select * from DW_RENEWAL_SHARE where cont_no ='0000318668211888'

DW_LOG_FILEPATH --报文记录表 EXPLAIN：报文相关功能 REMARKS ：保单号或流水号 paystatus：支付状态
--select * from DW_LOG_FILEPATH where remarks like '%2021010411100147987%'

li_pm_bankinfo：银行限额

LI_ORD_RISK -- 保单险种表  投保之后，主险和选择过的附加险信息

LI_PM_TIPS --投保提示书配置表

LI_ORD_SIGNDATA --保单签名数据表

DW_OUTERBLACKLIST --黑名单表

LI_ORD_PARTY  --客户人员信息表

DW_MANAGECOM_INFO --机构信息同步表 ， REGION_NAME:所属地区  COM_CODE:机构代码
--查询工号是哪个地区的
select * from DW_MANAGECOM_INFO where com_code like ('8604%') --861010

PM_SIGN_INFO:建议书pdf签名

DW_LACOM_INFO  --代理机构信息同步表
--select * from DW_LACOM_INFO where agent_com in('10002','10047','88000');

DW_PRODUCT_EFFECTIVEDATE --指定生效日期，生效日期表，如果产品需要生效日期，就插入一条

LI_ORD_ORDER --保单表


CS_SB_INFO --常熟医保保单社保信息表

LI_ORD_ATTACH --保单影像表

LI_PM_PRODUCT_DOC ----产品文档配置表（这个表有多少附加险，就要配置多少条doc_type=9的条款，投保提示书直接复制，都一样，doc_type=1）


LI_PM_RISK  --险种配置表

LI_PM_PRODUCT_RISK  --产品险种关系表 PRODUCT_CODE:产品编码  risk_code:附加险编码或主险编码

LI_PM_PRODUCT_ACHIEVEMEN--配置产品到个人

LI_PM_INPUT_HOSTORY --录入项历史表，保单录入过的信息保存到这个表里面

li_pm_product --产品表

--投保相关录入项表
LI_PM_COLUMN_CONF --产品录入项配置，栏目配置表
LI_PM_INPUT_ITEM  --栏目元素录入项表
LI_PM_INPUT_ITEM_RULE --栏目元素录入项规则表

 
LI_PM_RISK_INPUT_ITEM --险种录入项


LI_PM_PRODUCT_SALE ----产品套餐表：这个表要利用工具agentMITools结合给的excel表生成sql语句，再插入到excel表中
LI_PB_BXZR_OUTPUT_ITEM --建议书保险责任输出项表
select * from DW_RENEWAL_SHARE where id='2020062819415263131'

--建议书相关录入项表：
LI_PB_INPUT_ITEM --建议书产品录入项表（可在后台设置）
LI_PB_OUTPUT_ITEM --建议书产品输出项表（可在后台设置）

DW_APP_VERSION --app升级记录表
DW_LOGIN_RECORD --登陆记录表
DW_SMS_RECORD --短信表
select * from DW_SMS_RECORD where agentcode ='00105515'
IP_RISK_FACTOR_SEX 费率表
LI_CONFIG_INFO --字典表；配置表
DW_CONFIG_BANNER  --轮播图表
LI_ORD_CONTINUE  --回执回销人脸识别
DW_CUST_INFO  --客户信息表
LI_PM_BANKINFO  --银行表
DW_ATTENDANCE --签到表
LI_PM_TAXCONTENT --税收说明书保存表
DW_ATTENDANCE_SET --设置签到考勤地点表
IP_RISK_DIVIDEND  如果有红利的话，导入到IP_RISK_DIVIDEND这个表，左边右边字段都要导入，如果没有红利的话，导入到IP_RISK_CV表，只需要导入左边部分字段

select * from DW_MANAGECOM_INFO where REGION_NAME='江苏'-- 8610
--查询工号下面的achievement配置
SELECT * FROM LI_PM_PRODUCT_ACHIEVEMENT where RISK_CODE in(SELECT risk_code FROM LI_PM_PRODUCT_RISK WHERE PRODUCT_CODE='206A80'
)  and AGENTCODE='65092332' and ACHIEVE_CHANNEL='01'

查询续期支付请求失败的保单号和总保费：
select contno,sumprem from dw_renewal where orderno in (
SELECT SUBSTR(dlf.REMARKS,0,INSTR(dlf.REMARKS, ',')-1) from  DW_LOG_FILEPATH   dlf WHERE
 dlf.EXPLAIN ='续期支付请求'  and paystatus!='1'
  AND dlf.RESPONSE_DATE between to_date('2011-10-22 10:50:00','yyyy-mm-dd hh24:mi:ss') and  to_date('2020-10-22 13:00:00','yyyy-mm-dd hh24:mi:ss'))
  