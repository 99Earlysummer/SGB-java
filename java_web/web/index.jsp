<%--
  Created by IntelliJ IDEA.
  User: 沈功波
  Date: 2021/10/3
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>title   $Title$</title>

  </head>
  <script type="text/javascript">
    $("#01");
  </script>
  <body>

  <div id="01" align="center">
    <form action="" method="post">
      <table border="1">
        <tr>
          <td>省份编号：</td>
          <td><input type="text" id="proid">
          <input type="button" value="搜索" onclick="search()">
          </td>
        </tr>
        <tr>
          <td>省份名称：</td>
          <td><input type="text" id="proname" > </td>
        </tr>
        <tr>
          <td>省份简称：</td>
          <td><input type="text" id="projiancheng"> </td>
        </tr>
      </table>
    </form>
  </div>
  <div id="02">

  </div>
  $END$
  </body>
</html>
