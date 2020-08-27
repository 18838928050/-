ctrl+alt+v 生成返回值对象快捷键
idea内存溢出：
-Xms1024m -Xmx2048m -XX:MaxNewSize=512m -XX:MaxPermSize=512m

查看类的所有方法：
Alt+7


Idea中搜索范围去掉某些目录：
在项目的配置界面Project Structure中，找到Modules-项目名字-sources把不想包括的目录比如out选择为Excluded，就可以了。


热部署：
On 'Update' actions:
执行更新操作时所做的事情，一般选择'Update classes and resources'，即更新类和资源文件。
On frame deactivation：
在IDEA窗口失去焦点时触发，即一般你从idea切换到浏览器的时候，idea会自动帮你做的事情，
一般可以设置Do nothing，频繁切换会比较消耗资源的


idea默认展开所有节点：Ctrl + 9
idea默认展开当前节点：Ctrl + =
file-》setting->keymap->搜索folding
idea默认关闭所有节点：Ctrl + 8
idea关闭当前节点：Ctrl + -


快捷键：

在keymap中搜dupicate,就能看到快捷键：复制一行：ctrl+B
自动补全：alt+/
自动生成set get方法：alt+insert
补全结尾：比如System.out.println("ddf"     ctrl+shift+回车
for循环：fori
foreach :
 List<JSONUtil> jsonUtils = new ArrayList<>();
 jsonUtils.for即可
 或者iter

 格式化代码：选中ctrl+alt+L，全部格式化就不用选中
 显示最近修改了哪些代码：ctrl + e
把选中的代码放入if，tryCatch等里面： 判断：ctrl + alt +t

转换大小写：CTRL+shift+u
写一个string不等于null,string.notnull

翻译：transport shift+q:翻译  ctrl+shift+s ：切换翻译源