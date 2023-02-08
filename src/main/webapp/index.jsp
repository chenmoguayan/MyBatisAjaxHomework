<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/7
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询界面</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $.ajax({
                url:"<%=request.getContextPath()%>/user",
                data:{m:"query"},
                type:"post",
                dataType:"json",
                success:function (resp){
                    for (const x of resp) {
                        $("#table").append("<tr><td>"+x.id+"</td><td>"+x.username+"</td><td>"+x.sex+"</td><td>"+x.birthday+"</td><td>"+x.address+"</td><td>"+x.hobby+"</td><td>"+
                            "<input type=button class=update value=修改>" +
                            "<input type=hidden value="+x.id+">" +
                            "<input type=button class=delete value=删除>"+"</td></tr>")
                    }
                }
            })

            $("body").on("click",".update",function (){
                let id = $(this).next().val();
                location = "user/update.jsp?id="+id;
            })
            $("#insert").click(function (){
                location = "user/insert.jsp";
            })
            $("body").on("click",".delete",function (){
                let id = $(this).prev().val();
                $.ajax({
                    url: "<%=request.getContextPath()%>/user",
                    data: {m:"delete",id:id},
                    type: "post",
                    dataType: "json",
                    success:function (resp){
                        if (resp){
                            location.reload();
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <table id="table">
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>性别</td>
            <td>生日</td>
            <td>地址</td>
            <td>爱好</td>
            <td>操作|
                <input type="button" id="insert" value="添加">
            </td>
        </tr>

    </table>
</body>
</html>
