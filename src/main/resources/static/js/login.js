$(function () {
    $.validator.setDefaults({
        submitHandler: function() {
            var json = $("#loginform").serialize();

            $.ajax({
                url : "/loginDeal",
                type : "post",
                async : true,
                data : json,
                success : function (data, textStatus) {
                    if(data == "loginError") {
                        alert("用户名密码不匹配!")
                    } else if (data == "loginSuccess") {
                        $(window).attr('location', "/");
                    } else if (data == "userIsNotActive") {
                        alert("用户名未激活!");
                    }
                },
                error : function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求出错。。请重试");
                }
            });
        }
    });

    $("#loginform").validate({
        rules : {
            username : {
                required : true
            },
            password : {
                required : true
            }
        },
        messages : {
            username : "",
            password : ""
        }
    })
})