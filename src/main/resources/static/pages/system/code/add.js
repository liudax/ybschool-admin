
layui.use(['form', 'jquery','layer'], function () {
    var form = layui.form,$=layui.jquery,layer=layui.layer;

    
    form.on('submit(add)',function (data) {
        console.log(data.field);
        $.ajax({
            url:"/admin/typeInfo",
            type:"post",
            data:data.field,
            success:function (ret) {
                if(ret.code == 0){
                    setTimeout(function(){
                        top.layer.msg("类型添加成功！");
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    },300);
                }else{
                    top.layer.msg("类型添加失败！");
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
