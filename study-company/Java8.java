    Collect:
    List<String> riskCodes = liPmProductRisks.stream().map(LiPmProductRisk::getRiskCode).collect(Collectors.toList());

    filter:
                List<LiPmClause> inliPmClauses = liPmClauses.stream().filter(liPmClause -> liPmClause.getRiskCode().equals(e.getRiskCode())).collect(Collectors.toList());
1、把list集合 其中的一个字段去重，组成数组 

String[] names = userList.stream().map(x->x.getName())).distinct().toArray(String[]::new);

2、把list集合过滤取出符合条件的第一个对象，如果没有返回null

User user = userList.stream().filter(x->x.getName().equals("张三")).findFirst().orElse(null);

3、把list集合过滤符合条件的重新组成一个list集合

List<User> users = userList.stream().filter(x->x.getClass().equals("一班")).collect(Collectors.toList());

4、根据list集合中的一个字段组成map集合

Map<String, List<User>> map = userList.stream().collect(Collectors.groupingBy(x->((User)x).getClass()));
  按班级组成map集合

  或

Map<String, List<User>> map = userList.stream().collect(Collectors.groupingBy(User::getClass));

5、把list集合中的一个字段组成string“，”隔开，并拆成数组

String names= userList.stream().map(x->x.getClass).collect(Collectors.joining(","));
String[] name= Arrays.asList(names.split(",")).stream().map(String::new).distinct().toArray(String[]::new);

6、List以某一字段排序

List<User> userList =userLists.stream().sorted(Comparator.comparing(User::getClass) ).collect(Collectors.toList());

或

List<User> userList = userLists.stream().sorted(Comparator.comparing(x -> x.getClass())).collect(Collectors.toList());

排序并去重
//        pbOutputItems = pbOutputItems.stream().sorted(Comparator.comparing(PbOutputItem::getDisplayorder)).filter(distinctByKey(outputItem -> outputItem.getOutputEnglshName())).collect(Collectors.toList());
