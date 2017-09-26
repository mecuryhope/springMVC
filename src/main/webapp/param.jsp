<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/24
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/param5.html" method="post">
    员工id:<input name="id" type="text"/><br/>
    员工名：<input name="name" type="text"/><br/>
    <!--级联形式的映射-->
    员工部门id:<input name="dept.id" type="text"/><br/>
    员工部门名：<input name="dept.name" type="text"/><br/>
    <input type="submit" value="提交"/>
</form>
<form action="/param6.html" method="post">
    <input name="ids" value="1" type="checkbox"/>1<br/>
    <input name="ids" value="2" type="checkbox"/>2<br/>
    <input name="ids" value="3" type="checkbox"/>3<br/>
    <input name="ids" value="4" type="checkbox"/>4<br/>
    <input type="submit" value="提交"/>
</form>

<!--对象类型的数组,需要用ajax模拟提交数据-->
<script type="text/javascript" src="jquery-1.10.1.min.js"></script>
<input type="button" onclick="testParam7()" value="测试List<Object>"/>
<script type="text/javascript">
    function testParam7(){
        var nameList = ["张三","李四 "];//String类型的数组
        $.ajax({
            type: "POST",
            url: "/param7.html",
            data: JSON.stringify(nameList),//将对象序列化成JSON字符串
            contentType : "application/json;charset=utf-8",
            success: function(data){
                alert(data);
            }
        });
    }
</script>
<input type="button" onclick="testParam8()" value="测试List<POJO>"/>
<script type="text/javascript">
    function testParam8(){
        var deptList = new Array();//集合中存放的是实体类
        deptList.push({"id":1,"name":"技术部"});
        deptList.push({"id":2,"name":"测试部"});
        $.ajax({
            type: "POST",
            url: "/param8.html",
            data: JSON.stringify(deptList),//将对象序列化成JSON字符串
            contentType : "application/json;charset=utf-8",
            success: function(data){
                alert(data);
            }
        });
    }
</script>
<input type="button" onclick="testParam9()" value="POJO中包含List"/>
<script type="text/javascript">
    function testParam9(){
        var empList = new Array();//集合中存放的是实体类
        empList.push({"id":1,"name":"张三"});
        empList.push({"id":2,"name":"李四"});
        var dept={"id":1,"name":"技术部","employees":empList};
        $.ajax({
            type: "POST",
            url: "/param9.html",
            data: JSON.stringify(dept),//将对象序列化成JSON字符串
            contentType : "application/json;charset=utf-8",
            success: function(data){
                alert(data);
            }
        });
    }
</script>

<input type="button" onclick="testParam10()" value="测试List<Map<String,Object>>"/>
<script type="text/javascript">
    function testParam10(){
        var data = new Array();//
        data.push({"id":1,"name":"技术部"});
        data.push({"id":3,"addr":"三楼"});
        $.ajax({
            type: "POST",
            url: "/param10.html",
            data: JSON.stringify(data),//将对象序列化成JSON字符串
            contentType : "application/json;charset=utf-8",
            success: function(data){
                alert(data);
            }
        });
    }
</script>

</body>
</html>
