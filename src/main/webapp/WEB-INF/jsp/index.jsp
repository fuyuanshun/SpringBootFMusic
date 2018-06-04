<%@page isELIgnored="false"%>
<%@   page   contentType="text/html;charset=utf-8"%>
<%@ page   pageEncoding="utf-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%response.setCharacterEncoding("utf8");%>
<html>
<head>
    <title>首页</title>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<style>
    div.carousel-item img{
        width:100%;
        height:300px;
    }

    div#carousel-example-generic{
        width:80%;
        margin:0 auto;
    }

</style>

<body>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- ol标签是图片轮播的控制点 -->
    <ol class="carousel-indicators">
        <!--
          每一个li就是一个单独的控制点
            data-target属性就是指定当前控制点控制的是哪一个轮播图，其目的是如果界面上有多个轮播图，便于区分到底控制哪一个
            data-slide-to属性是指当前的li元素绑定的是第几个轮播项
          注意，默认必须给其中某个li加上active，展示的时候就是焦点项目
        -->
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <!-- ...更多的 -->
    </ol>
    <!--
      .carousel-inner是所有轮播项的容器盒子，
      注意role="listbox"代表当前div是一个列表盒子，作用就是给当前div添加一个语义
    -->
    <div class="carousel-inner" role="listbox">
        <!-- 每一个.item就是单个轮播项目，注意默认要给第一个轮播项目加上active，表示为焦点 -->
        <div class="carousel-item active">
            <a href="/hotmusic"><img src="images/music/music1.png"></a>
        </div>
        <div class="carousel-item">
            <a href="/hotmusic"><img src="images/music/music2.png"></a>
        </div>
        <div class="carousel-item">
            <a href="/music"><img src="images/music/music3.png"></a>
        </div>
        <div class="carousel-item">
            <a href="/music"><img src="images/music/music4.png"></a>
        </div>
    </div>
    <!-- 图片轮播上左右两个控制按钮，分别点击可以滚动到上一张和下一张 -->
    <!-- 此处需要注意的是 该a链接的href属性必须指向需要控制的轮播图ID -->
    <!-- 另外a链接中的data-slide="prev"代表点击该链接会滚到上一张，如果设置为next的话则相反 -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">上一张</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">下一张</span>
    </a>
</div>
<div >

</div>
</body>
</html>