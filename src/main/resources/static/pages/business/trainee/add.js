
layui.use(['form', 'jquery','layer'], function () {
    var form = layui.form,$=layui.jquery,layer=layui.layer;


    $(".cancle").click(function () {
        layer.closeAll("iframe");
    });
    
    form.on('submit(add)',function (data) {
        var user = data.field;
        user.userRole = "102";
        $.ajax({
            url:"/admin/user",
            type:"post",
            data:user,
            success:function (ret) {
                if(ret.code == 0){
                    setTimeout(function(){
                        top.layer.msg("保存成功！");
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    },300);
                }else{
                    top.layer.msg("保存失败！");
                }
            }
        });

        return false;
    });

    $(".cancel").on("click",function () {
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });
});
