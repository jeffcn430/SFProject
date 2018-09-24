layui.use(['laydate', 'table'], function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#startTime' //指定元素
        , value: '2018-09-01'
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#endTime' //指定元素
        , value: '2018-09-30'
    });

    var table = layui.table;
    table.render({
        id: 'memberTable'
        , elem: '#membertable'
        , url: 'member'
        , parseData: parseData// 返回结果解析
        , cols: [
            [
                {field: 'id', title: 'ID', width: 50}
                , {field: 'account', title: '账号'}
                , {field: 'nick', title: '昵称'}
                , {field: 'type', title: '账号状态'}
                , {field: 'type', title: '账号类型'}
                , {field: 'nick', title: '总资产'}
                , {field: 'nick', title: '下级人数'}
                , {field: 'nick', title: '团队余额'}
                , {field: 'nick', title: '上级账号'}
                , {field: 'nick', title: '用户等级'}
                , {field: 'loginNum', title: '登陆次数'}
                , {field: 'nick', title: '操作'}
            ]
        ]
        , limit: 15
        , page: true
        , limits: [15, 50, 100]
    });

    // 重载表格
    $('.layui-btn').on("click", function () {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var account = $("#account").val();
        table.reload('memberTable', {
            where: { //设定异步数据接口的额外参数，任意设
                startTime: startTime,
                endTime: endTime,
                account: account
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    // 排序事件监听器
    table.on('sort(membertable)', function (obj) {
        table.reload('membertable', {
            initSort: obj //记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field //排序字段
                , order: obj.type //排序方式
            }
        });
    });
});

/*用户-停用*/
function member_stop(obj, id) {
    layer.confirm('确认要停用吗？', function (index) {
        if ($(obj).attr('title') == '启用') {
            //发异步把用户状态进行更改
            $(obj).attr('title', '停用')
            $(obj).find('i').html('&#xe62f;');
            $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
            layer.msg('已停用!', {icon: 5, time: 1000});
        } else {
            $(obj).attr('title', '启用')
            $(obj).find('i').html('&#xe601;');
            $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
            layer.msg('已启用!', {icon: 5, time: 1000});
        }

    });
}