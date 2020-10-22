kibana常用命令：
1.查看索引库的数据
GET /my_index/my_type/_search
GET /索引名/表名/_search


2.查看索引库的数据结构
GET /my_index/my_type/_mapping
GET /索引名/表名/_mapping

3.es中创建后的mapping不可修改，但是可以添加新字段
PUT /my_index/_mapping/my_type
{
  "properties": {
       "new_field_name": {
           "type":  "keyword"
       }
   }
}

4.删除索引库
DELETE my_index

5. 分页查询，默认情况下查询一页十条数据

POST /_search
{
    "size": 2,
    "from": 10, 
    "query": {
        "match_all": {}
    }
}
size:表示每页显示多少条记录，form：表示从第几页开始显示记录

6.使用ik分词器分词
POST _analyze
{
  "analyzer": "ik_max_word",
  "text":     "中国银行"
}


7.更新索引库中某个字段的值、

POST my_index/_update_by_query
{
  "script": {
    "lang": "painless",
    "inline": "if(ctx._source.title== '李四'){ctx._source.title= '张三'}"
  }
}

注释：将索引库my_index里面字段title值为李四的改为张三


8.直接向索引库添加数据

PUT /my_index/my_type/5
{
  "title": "中国",
  "content": "中国银行"
}


9.获取 - ①指定ID的文档
	GET test/user/1
	②获取指定ID文档的部分字段

	GET test/user/1?_source=name

	③只返回文档内容，不要元数据
	GET test/user/1/_source

	10.删除

	DELETE test/user/1

	11.修改 - ①更新整个文档(即先删除后再添加)

	PUT test/user/1
	{
	  "id":1,
	  "name":"郑清"
	}


	E:\mallsoft\MnogoDB3.2.21\bin\mongod.exe --config "E:\mallsoft\MnogoDB3.2.21\mongod.cfg" --install