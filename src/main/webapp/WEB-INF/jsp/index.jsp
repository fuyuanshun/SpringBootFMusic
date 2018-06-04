<%@page isELIgnored="false"%>
<%@   page   contentType="text/html;charset=utf-8"%>
<%@ page   pageEncoding="utf-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%response.setCharacterEncoding("utf8");%>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:400,700" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/demo.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/audioplayer.css" />
</head>
<body>
<div class="new0">

    <a href="${pageContext.request.contextPath}/music">更多音乐1</a><br><br>
    <a href="${pageContext.request.contextPath}/hotmusic">更多音乐2</a><br><br>
    <a href="${pageContext.request.contextPath}/resource?currentPage=1">福利</a>
    <div id="wrapper">
        <span>登陆才可以听音乐哦~~</span>
        <audio preload="auto" controls>
            <source src="${pageContext.request.contextPath}/auto/we.mp3">
        </audio>
        <script src="${pageContext.request.contextPath}/js/musicdemo/audioplayer.min.js"></script>
        <script>$( function() { $( 'audio' ).audioPlayer(); } );</script>
    </div>

</div>
</body>
</html>
