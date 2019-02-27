layui.extend({
    admin: '{/}../../../static/js/admin'
});
layui.use(['form', 'jquery','laydate', 'admin', 'table','layer'], function () {
    var table = layui.table,layer=layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    // laydate.render({
    //     elem: '#appointmentDate' //指定元素
    // });
    laydate.render({
        elem: '#appointmentDate' //指定元素
    })
    table.render({
        elem: '#appointmentList',
        height: 315,
        url: '/admin/appointments',
        cellMinWidth: 80,
       // even:true,
        page: true,
        where:{backup1:"103"},
        id:"appointmentTable",
        cols: [[ //表头
            {checkbox: true},
            {field: 'coachName', title: '学员'},
            {field: 'licenseTypeDesc', title: '驾驶证类型'},
            {field: 'coachPhone', title: '学员电话'},
            {field: 'traineeName', title: '教练'},
            {field: 'traineePhone', title: '教练电话'},
            {field: 'stageDesc', title: '预约科目'},
            {field: 'timeIntervalDesc', title: '预约时段'},
            {field: 'appointmentDate', title: '预约日期',templet: function(d){
            console.log(d);
                return new Date(d.appointmentDate).toLocaleDateString();
            }},
        ]]
    });

    form.on('submit(search)',function (data) {
        console.log(data.field.appointmentDate)
        table.reload("appointmentTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:data.field
        });
        return false;
    });


    $(".del_btn").on("click",function () {
        var checkStatus = table.checkStatus('appointmentTable');
        var data = checkStatus.data;
        var ids = '';
        if(data.length > 0) {
            for (var i =0;i<data.length;i++) {
                var temp = i==(data.length -1)?data[i].id:data[i].id+",";
                ids+=temp
            }
        }else{
            layer.msg("请选择要"+msg+"的学员");
        }

        console.log(ids);
        delCode(ids);
    });
    function delCode(ids) {
        layer.confirm('确定删除选中的预约信息？', {icon: 3, title: '提示信息'}, function (index) {
            $.ajax({
                url:"/admin/appointment/",
                type:"put",
                data:{ids:ids},
                success:function (ret) {
                    if(ret.code==0){
                        layer.msg("删除成功");
                    }else{
                        layer.msg(ret.msg);
                    }
                }
            });
            table.reload('appointmentTable');
            layer.close(index);
        })
    }

});
