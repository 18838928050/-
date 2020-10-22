OrdNoticeExample exp1 = new OrdNoticeExample();
exp1.or().andOrderNoEqualTo(orderNo).andImpartGroupNoEqualTo("A01").andImpartCodeLike("%A0107%");
exp1.or().andOrderNoEqualTo(orderNo).andImpartGroupNoEqualTo("A01").andImpartCodeLike("%A0108%");
exp1.or().andOrderNoEqualTo(orderNo).andImpartGroupNoEqualTo("A01").andImpartCodeLike("%A0109%");
List<OrdNotice>  notices=ordNoticeMapper.selectByExample(exp1);
return notices;
相当于：oracle like多条件查询：
select * from LI_ORD_NOTICE where ORDER_no ='2020072909233203724' and IMPART_GROUP_NO='A01'
and  REGEXP_LIKE(IMPART_CODE, '(A0108|A0107|A0109)');



logFilePathExample example=new logFilePathExample();
logFilePathExample.Criteria criteria1=example.createCriteria();
criteria1.andRemarksLike("%"+fileName+"%");
logFilePathExample.Criteria criteria2=example.createCriteria();
criteria2.andExplainLike("%"+fileName+"%");
example.or(criteria1);
example.or(criteria2);
example.setOrderByClause("CREATE_DATE DESC");
List<logFilePath> logs=logFilesMapper.selectByExample(example);
相当于：select * from logFilePath where andRemarksLike("%"+fileName+"%") or andExplainLike("%"+fileName+"%") 
orderby CREATE_DATE desc


PmProductAchievementExample productAchievementExample = new PmProductAchievementExample();
productAchievementExample.createCriteria().andAgentcodeEqualTo(om.getAgentCode())
.andAchieveChannelEqualTo(orders.get(0).getAchievementChannel())
.andStartDateLessThanOrEqualTo(new Date())
.andEndDateGreaterThanOrEqualTo(new Date());
List<PmProductAchievement> productAchievements = productAchievementMapper
.selectByExample(productAchievementExample);。

//工号登陆，当日00：00：00至23：59：59之间，登陆错误的数据
DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String benginDateStr=Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DATE)+" 00:00:00";
String endDateStr=Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DATE)+" 23:59:59";
LoginRecordExample loginRecordExample = new LoginRecordExample();
loginRecordExample.createCriteria().andAgentcodeEqualTo(outManagerList.get(0).getAgentCode())
.andLoginResultEqualTo("0")
.andCreateDateBetween(format.parse(benginDateStr), format.parse(endDateStr));

// OrderBy
String benginDateStr=Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DATE)+" 00:00:00";
String endDateStr=Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DATE)+" 23:59:59";


LoginRecordExample loginRecordExample = new LoginRecordExample();
loginRecordExample.createCriteria().andAgentcodeEqualTo(outManagerList.get(0).getAgentCode())
.andCreateDateBetween(format.parse(benginDateStr), format.parse(endDateStr));
loginRecordExample.setOrderByClause("CREATE_DATE DESC");