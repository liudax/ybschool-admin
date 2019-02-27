layui.extend({
    admin: '{/}../../../static/js/admin'
});
layui.use(['form', 'jquery', 'admin', 'table','layer'], function () {
    var table = layui.table,layer=layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    table.render({
        elem: '#codeList',
        height: 315,
        url: '/admin/typeInfo',
        cellMinWidth: 80,
       // even:true,
        page: true,
        id:"codeTable",
        cols: [[ //表头
            {checkbox: true},
            {field: 'typeName', title: '类型名称'},
            {field: 'typeCode', title: '类型编码'},
            {field: 'smallName', title: '小类名称'},
            {field: 'smallCode', title: '小类编码'},
            {field: 'backup1', title: '标识'},
            {title: '操作', templet:'#codeListBar',fixed:"right",align:"center"}
        ]]
    });

    form.on('submit(search)',function (data) {
        table.reload("codeTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{query:data.field.key}
        });
        console.log(data.field.studentName);
        return false;
    });

    $(".add_btn").on("click",function () {
        addCode();
    });

    function addCode(edit) {
        var index = layer.open({
            title:edit?"添加类型":"修改类型",
            type : 2,
            area:['450px','450px'],
            content : "add.html",
            success : function(layero, index){
                var body = layer.getChildFrame('body', index);
                if(edit){
                    body.find("#id").val(edit.id);
                    body.find("#typeName").val(edit.typeName);
                    body.find("#typeCode").val(edit.typeCode);
                    body.find("#smallCode").val(edit.smallCode);
                    body.find("#smallName").val(edit.smallName);
                    body.find("#backup1").val(edit.backup1);
                    form.render();
                }
            }
        })
    }
    
    function delCode(codeIds) {
        layer.confirm('确定删除选中的类型？', {icon: 3, title: '提示信息'}, function (index) {
            $.ajax({
                url:"/admin/typeInfo/"+codeIds,
                type:"delete",
               // data:{ids:JSON.stringify(codeIds)},
                success:function (ret) {
                    if(ret.code==0){
                        layer.msg("删除成功");
                    }else{
                        layer.msg(ret.msg);
                    }
                }
            });
            table.reload('reloadTable');
            layer.close(index);
        })
    }
    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('codeTable'),
            data = checkStatus.data,
            codeIds = [];
        if(data.length > 0) {
            for (var i in data) {
                codeIds.push(data[i].id);
            }
            delCode(codeIds);
        }else{
            layer.msg("请选择需要删除的类型");
        }
    });

    //列表操作
    table.on('tool(code_table_filter)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            addCode(data);
        } else if(layEvent === 'del'){ //删除
            var codeIds = [];
            codeIds.push(data.id);
            delCode(codeIds);
        }
    });

});
