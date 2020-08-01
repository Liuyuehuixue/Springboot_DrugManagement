
$(function () {


    $("#registerForm").validate({
        errorPlacement: function (error, element) {
            $(element)
                .closest("form")
                .find("div")
                .append(error);
        },
        errorElement: "span",

        rules: {
            username: {

                required: true,

            },
            password: {
                required: true,
                minlength: 6
            },
            confirm_password: {
                required: true,
                equalTo: "#password"
            }
        },


        messages: {
            username: {
                required: "请输入用户名",
                remote: "用户名已被注册"
            },
            password: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 位"
            },
            confirm_password: {
                required: "请输入确认密码",
                equalTo: "两次密码输入不一致"
            }
        }
    });







    $("#loginBtn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();

        if (username == "" || password == "") {
            $("#errorHit").html("用户名或者密码不能为空!");
        } else {
            //发送AJAX请求(异步登陆)
            $.post("admin/login", {username: username, password: password}, function (data) {
                //判断登陆是否成功
                if (data == 1) {
                    //跳转下一个页面
                    window.location = "detail/list";
                } else {
                    $("#errorHit").html("用户名或者密码有误!");
                }
            });
        }
        //清除用户名和密码输入框中的内容,并且选中用户名输入框
        $("#username").val("").select();
        $("#password").val("");
        //当重新开始输入用户名时,清空错误提示
        $("#username").keyup(function () {
            $("#errorHit").html("");
        });
    });



    $("#registerBtn").click(function () {
        window.location = "register";
    });


    $("#returnBtn").click(function () {
        window.location = "/medicine";
    });

});
