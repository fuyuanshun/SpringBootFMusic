<%@page isELIgnored="false" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@include file="header.jsp" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>注册用户</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jq22.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    <script>
        /**
         * 刷新验证码
         */
        function changeImg() {
            document.getElementById("validateCodeImg").src = "/drawImage?" + Math.random();
        }
    </script>
</head>

<body>
<div style="max-width:800px;margin:50px auto;">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="#login" data-toggle="tab">登陆</a>
        </li>
        <li>
            <a class="nav-link" href="#register" data-toggle="tab">注册</a>
        </li>
    </ul>
    <%--Tab panes--%>
    <div class="tab-content">
        <%--登陆DIV--%>
        <div id="login" class="tab-pane active container">
            <div class="wrapper">
                <div class="login">
                    <form action="#" method="post" class="container offset1 loginform" id="loginform">
                        <div id="owl-login">
                            <div class="hand"></div>
                            <div class="hand hand-r"></div>
                            <div class="arms">
                                <div class="arm"></div>
                                <div class="arm arm-r"></div>
                            </div>
                        </div>
                        <div class="pad">
                            <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk="/>
                            <div class="control-group">
                                <div class="controls">
                                    <label for="username" class="control-label fa fa-envelope"></label>
                                    <input type="text" name="username" placeholder="请输入您的用户名" tabindex="1"
                                           autofocus="autofocus" class="form-control input-medium glyphicon-user"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <label for="password" class="control-label fa fa-asterisk"></label>
                                    <input type="password" name="password" placeholder="请输入密码" tabindex="2"
                                           class="form-control input-medium" id="login_password"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions"><a href="${pageContext.request.contextPath}/forgetPassword"
                                                     tabindex="5" class="btn pull-left btn-link text-muted">忘记密码?</a><a
                                href="${pageContext.request.contextPath}/register" tabindex="6"
                                class="btn btn-link text-muted">注册</a>
                            <input type="submit" tabindex="4" class="btn btn-primary" value="登陆"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- end -->
        <script type="text/javascript">
            $("#login #login_password").focus(function () {
                $("#owl-login").addClass("password");
            }).blur(function () {
                $("#owl-login").removeClass("password");
            });
        </script>

        <%--注册DIV--%>
        <div class="tab-pane container" id="register">
            <form method="post" action="" id="myform" class="form-control">
                <div class="col-sm-10">
                    <input type="text" placeholder="请输入用户名" name="username" id="username" class="form-control"
                           required/>
                    <label for="username" style="color: red;"></label>
                </div>

                <div class="col-sm-10">
                    <input type="password" placeholder="请输入您的登陆密码" name="password" id="password" class="form-control"
                           required/>
                    <label for="password" style="color: red;"></label>
                </div>

                <div class="col-sm-10">
                    <input type="password" placeholder="请重新输入一遍您的密码" name="password2" id="password2"
                           class="form-control" required/>
                    <label for="password2" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    <input type="text" placeholder="请输入邮箱地址" name="email" id="email" class="form-control" required/>
                    <label for="email" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    男<input type="radio" value="男" name="sex" required>
                    女<input type="radio" value="女" name="sex" required>
                </div>
                <div class="col-sm-10">
                    <input type="text" placeholder="请输入您的年龄" name="age" id="age" class="form-control" required/>
                    <label for="age" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    <input type="text" placeholder="不得多于11个字" name="phone" id="phone" class="form-control" required/>
                    <label for="phone" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    <input type="text" name="birthday" id="birthday" class="form-control" placeholder="请输入生日" required/>
                    <label for="birthday" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    <input type="text" name="hobby" id="hobby" class="form-control" placeholder="请输入您的爱好" required/>
                    <label for="hobby" style="color: red;"></label>
                </div>
                <div class="col-sm-10">
                    <input type="text" name="address" id="address" class="form-control" placeholder="请输入您的居住地址"
                           required/>
                    <label for="address" style="color: red;"></label>
                </div>
                <div class="input-group input-group-md">
                    <div class="col-sm-5">
                        <input type="text" name="validateCode" id="validateCode" class="form-control"
                               placeholder="请输入您看到的验证码" required/>
                        <label for="validateCode" style="color: red;"></label>
                    </div>
                    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/drawImage" id="validateCodeImg"
                         onclick="changeImg()">
                    <input type="button" onclick="changeImg()" value="看不清，换一张" class="btn-info">
                </div>
                <div class="input-group input-group-md">
                    <input type="submit" value="注册" id="submit" class="btn btn-block btn-success"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

