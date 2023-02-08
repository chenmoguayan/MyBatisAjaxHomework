<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/7
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加界面</title>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
              $("#btn").click(function (){
                        $.ajax({
                            url: "<%=request.getContextPath()%>/user?m=insert",
                            data: $("#f").serialize(),
                            type: "post",
                            dataType: "json",
                            success:function (resp){
                                if (resp){
                                    location = "<%=request.getContextPath()%>/user?m=query";
                                }
                            }
                        })
              })
        })
    </script>
</head>
<body>
  <form id="f">
      <table>
          <tr>
            <td>用户名</td>
            <td>
              <input type="hidden" name="id" id="id">
              <input type="text" name="username" id="username">
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <input type="text" name="password" id="password">
            </td>
          </tr>
          <tr>
            <td>性别</td>
            <td>
              <input type="radio" class="sex" name="sex" value="男">男
              <input type="radio" class="sex" name="sex" value="女">女
            </td>
          </tr>
          <tr>
            <td>生日</td>
            <td>
              <input type="text" name="birthday" id="birthday">
            </td>
          </tr>
          <tr>
            <td>地址</td>
            <td>
              <input type="text" name="address" id="address">
            </td>
          </tr>
          <tr>
            <td>爱好</td>
            <td>
              <input type="text" name="hobby" id="hobby">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="button" value="添加" id="btn">
            </td>
          </tr>
      </table>
  </form>
</body>
</html>
