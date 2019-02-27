layui.extend({
    admin: '{/}../../../static/js/admin'
});
layui.use(['form', 'jquery', 'admin', 'table','layer'], function () {
    var table = layui.table,layer=layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    table.render({
        elem: '#studentList',
        height: 315,
        url: '/admin/user',
        where:{userRole:"102"},
        cellMinWidth: 80,
       // even:true,
        page: true,
        id:"studentTable",
        cols: [[ //表头
            {checkbox: true},
            {field: 'userName', title: '姓名'},
            {field: 'sexDesc', title: '性别'},
            {field: 'userPhone', title: '电话'},
            {field: 'licenseTypeDesc', title: '驾照类型'},
            {field: 'stageDesc', title: '阶段'},
            {field: 'isEnabledDesc', title: '是否启用'},
            {title: '操作', templet:'#listBar',fixed:"right",align:"center"}
        ]]
    });

    form.on('submit(search)',function (data) {
        table.reload("studentTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:data.field
        });
        return false;
    });

    $(".add_btn").on("click",function () {
        addCode();
    });

    function addCode(edit) {
        var index = layer.open({
            title:edit?"添加教练信息":"修改教练信息",
            type : 2,
            area:['450px','500px'],
            content : "add.html",
            success : function(layero, index){
                var body = layer.getChildFrame('body', index);
                // body.find("#licenseType option[value='101']").attr("selected","selected");
                // body.find("#sex option[value=1]").attr("selected","selected");
                //
                // body.find("#id").val();
                // body.find("#userName").val();
                // body.find("#userPhone").val();
                // body.find("#sex").removeAttr("disabled");
                // body.find("#stage").removeAttr("disabled");
                // body.find("#licenseType").removeAttr("disabled");
                // body.find("#isEnabled").removeAttr("disabled");

                if(edit){
                    if(edit.id)body.find("#id").val(edit.id);
                    if(edit.userName)body.find("#userName").val(edit.userName);
                    if(edit.userPhone)body.find("#userPhone").val(edit.userPhone);
                    if(edit.sex)body.find("#sex option[value='"+edit.sex+"']").attr("selected","selected");
                    if(edit.stage)body.find("#stage option[value='"+edit.stage+"']").attr("selected","selected");
                    if(edit.licenseType)body.find("#licenseType option[value='"+edit.licenseType+"']").attr("selected","selected");
                    if(edit.isEnabled) body.find("#isEnabled option[value="+edit.isEnabled+"]").attr("selected","selected");
                    form.render();
                }
            }
        })
    }
    
    function delCode(codeIds) {
        layer.confirm('确定删除选中的教练信息？', {icon: 3, title: '提示信息'}, function (index) {
            $.ajax({
                url:"/admin/user/"+codeIds,
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
            table.reload('studentTable');
            layer.close(index);
        })
    }

    function updateState(state) {
        var msg = state=="101"?"启用":"禁用";
        var checkStatus = table.checkStatus('studentTable'),
            data = checkStatus.data,
            codeIds = '';
        if(data.length > 0) {
            for (var i =0;i<data.length;i++) {
                var temp = i==(data.length -1)?data[i].id:data[i].id+",";
                codeIds+=temp
            }
        }else{
            layer.msg("请选择要"+msg+"的教练");
        }

        layer.confirm('确定要'+msg+'教练吗？', {icon: 3, title: '提示信息'}, function (index) {
            $.ajax({
                url:"/admin/user",
                type:"put",
                dataType:"json",
                data:{ids:codeIds,state:state},
                success:function (ret) {
                    if(ret.code==0){
                        layer.msg("操作成功");
                    }else{
                        layer.msg(ret.msg);
                    }
                }
            });
            table.reload('studentTable');
            layer.close(index);
        })
    }
    //批量启用
    $(".true_btn").click(function(){
        updateState("101")
    });

    //批量禁用
    $(".false_btn").click(function(){
        updateState("102")
    });



    //列表操作
    table.on('tool(student_table_filter)', function(obj){
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
