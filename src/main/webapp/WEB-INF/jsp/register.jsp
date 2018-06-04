<%@page isELIgnored="false" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@include file="header.jsp"%>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>注册用户</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <script>
        /**
         * 刷新验证码
         */
        function changeImg(){
            document.getElementById("validateCodeImg").src="/drawImage?"+Math.random();
        }
    </script>
</head>

<body>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">用户注册</a></li>
    <li role="presentation"><a href="#">用户登录</a></li>
</ul>

<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
        <form method="post" action="" id="myform" class="form-control" >
            <div class="input-group input-group-md">
                <span class="input-group-addon">用户名</span>
                <input type="text" placeholder="请输入用户名" name="username" id="username" required class="form-control"/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">用户密码</span>
                <input type="password" placeholder="请输入您的登陆密码" name="password" id="password" class="form-control" required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">确认密码</span>
                <input type="password" placeholder="请重新输入一遍您的密码" name="password2" id="password2" class="form-control" required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">邮箱</span>
                <input type="text" placeholder="请输入邮箱地址" name="email" id="email" class="form-control" required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">性别</span>
                男<input type="radio" value="男" name="sex"  required>
                女<input type="radio" value="女" name="sex"  required>
            </div>

            <div class="input-group input-group-md">
                <span class="input-group-addon">年龄</span>
                <input type="text" placeholder="请输入您的年龄" name="age" id="age" class="form-control" required />
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">电话</span>
                <input type="text" placeholder="不得多于11个字" name="phone" id="phone"  class="form-control" required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">生日</span>
                <input type="text"  name="birthday" id="birthday" class="form-control" required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">爱好</span>
                <input type="text"  name="hobby" id="hobby" class="form-control"  required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">居住地址</span>
                <input type="text" name="address" id="address" class="form-control"  required/>
            </div>
            <div class="input-group input-group-md">
                <span class="input-group-addon">验证码</span>
                <input type="text" name="validateCode" id="validateCode" class="form-control"  required/>
                <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/drawImage" id="validateCodeImg" onclick="changeImg()">
                <input type="button" onclick="changeImg()" value="看不清，换一张">
            </div>
            <div class="input-group input-group-md">
                <input type="submit" value="注册" id="submit" class="btn btn-success" />
                <input type="button" value="已经有账号啦~去登陆" class="btn btn-info" id="gologin"/>
            </div>
        </form>
    </div>
    </div>
</div>

</body>
</html>

