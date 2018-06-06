<%@page isELIgnored="false" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%response.setCharacterEncoding("utf8");%>
<html>
<head>
    <title>首页</title>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<style>
    div.carousel-item img {
        width: 100%;
        height: 300px;
    }

    div#carousel-example-generic {
        width: 80%;
        margin: 0 auto;
    }

    .tab a {
        color: black;
    }

    .tab a:hover {
        text-decoration: none;
        color: darkred;
    }

    .row {
        margin-top: 4px;
        margin-bottom: 4px;
    }
    .row img{
        width:140px; height:140px
    }
</style>

<body>
<%--搜索start--%>
<div class="container">
    <div class="input-group">
        <input type="text" class="form-control col-sm-2" style="float: right" placeholder="请输入搜索内容">
        <span class="input-group-btn">
        <button class="btn btn-primary" type="button">搜索</button>
      </span>
    </div>
</div>
<%--搜索end--%>

<%--轮播图start--%>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
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
            <a href="/FMusic/hotmusic"><img src="images/music/music1.png" class="img-rounded"></a>
        </div>
        <div class="carousel-item">
            <a href="/FMusic/music"><img src="images/music/music2.png" class="img-circle"></a>
        </div>
        <div class="carousel-item">
            <a href="/FMusic/resource"><img src="images/music/music3.png" class="img-thumbnail"></a>
        </div>
        <div class="carousel-item">
            <a href="/FMusic/music"><img src="images/music/music4.png" class="img-rounded"></a>
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
<div>
</div>
<%--轮播图end--%>

<div class="container">
    <%--顶部显示text Div--%>
    <div class="tab border-bottom">
        <h4 style="display: inline-block;"><a href="#">热门推荐</a></h4>
        <a href="#">华语</a>
        <span class="line">|</span>
        <a href="#">流行</a>
        <span class="line">|</span>
        <a href="#">摇滚</a>
        <span class="line">|</span>
        <a href="#">民谣</a>
        <span class="line">|</span>
        <a href="#">电子</a>
    </div>
    <%--显示图片的大div--%>
    <div class="col-xs-12 row">
        <div class="col-xs-3 row">
            <img src="images/music/musicbg1.png">
            <div class="carousel-caption">标题1</div>
        </div>
        <div class="col-xs-3 row">
            <img src="images/music/musicbg2.png">
            <div class="carousel-caption">标题2</div>
        </div>
        <div class="col-xs-3 row">
            <img src="images/music/musicbg3.png">
            <div class="carousel-caption">标题3</div>
        </div>
        <div class="col-xs-3 row">
            <img src="images/music/musicbg3.png">
            <div class="carousel-caption">标题4</div>
        </div>
    </div>
        <div class="col-xs-12 row">
            <div class="col-xs-3 row">
                <img src="images/music/musicbg2.png">
                <div class="carousel-caption">标题5</div>
            </div>
            <div class="col-xs-3 row">
                <img src="images/music/musicbg1.png">
                <div class="carousel-caption">标题6</div>
            </div>
            <div class="col-xs-3 row">
                <img src="images/music/musicbg1.png">
                <div class="carousel-caption">标题7</div>
            </div>
            <div class="col-xs-3 row">
                <img src="images/music/musicbg2.png">
                <div class="carousel-caption">标题8</div>
            </div>
        </div>
</div>

</body>
</html>