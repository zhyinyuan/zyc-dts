$(function () {

    var flowdata = "{}";
    if (flag == "edit") {
        $.post(base_url + "/jobprocess/getJob", {pid: pid}, function (data, status) {
            console.log(data);
            if (data.process != undefined && data.process != null) {
                flowdata = data.process.pcontext;
                // var obj = eval("(" + flowdata + ")");
                pid = data.process.pid;
                init();
            } else {
                layer.open({
                    title: I18n.system_tips,
                    btn: [I18n.system_ok],
                    content: (data.msg || I18n.system_load_fail),
                    icon: '2'
                });
            }
        });
    }else{
        init();
    }
    function init() {
        $('#myflow').myflow(
            {
                id: pid,
                basePath: "",
                allowStateMutiLine: true,
                restore: eval("(" + flowdata + ")"),
                tools: {
                    save: function (data) {
                        // console.log("保存",eval("("+data+")"));
                        console.log(data);
                        window.localStorage.setItem("data", data)
                    },
                    publish: function (flowData) {
                        // var base_url = '${request.contextPath}';
                        // var I18n = ${I18nUtil.getMultString()};
                        var flows = eval("(" + flowData + ")");

                        if (isEmptyObject(flows.states)) {
                            layer.open({
                                title: I18n.system_tips,
                                btn: [I18n.system_ok],
                                content: "未获取任何任务信息，无法发布",
                                icon: '1',
                                end: function (layero, index) {

                                }
                            });
                            return;
                        }

                        $.post(base_url + "/jobprocess/saveMyflow", {flows: JSON.stringify(flows), flag:flag}, function (data, status) {
                            if (data.code == "200") {


                                layer.open({
                                    title: I18n.system_tips,
                                    btn: [I18n.system_ok],
                                    content: I18n.system_update_suc,
                                    icon: '1',
                                    end: function (layero, index) {
                                        //window.location.reload();
                                        window.opener = null;
                                        window.open('', '_self');
                                        window.close();
                                    }
                                });
                            } else {
                                layer.open({
                                    title: I18n.system_tips,
                                    btn: [I18n.system_ok],
                                    content: (data.msg || I18n.system_update_fail),
                                    icon: '2'
                                });
                            }
                        });
                    },
                    addPath: function (id, data) {
                        console.log("添加路径", id, eval("(" + data + ")"));
                    },
                    addRect: function (id, data) {
                        console.log("添加状态", id, eval("(" + data + ")"));
                    },
                    clickPath: function (id) {
                        console.log("点击线", id)
                    },
                    clickRect: function (id, data) {
                        console.log("点击状态", id, eval("(" + data + ")"));
                    },
                    deletePath: function (id) {
                        console.log("删除线", id);
                    },
                    deleteRect: function (id, data) {
                        console.log("删除状态", id, eval("(" + data + ")"));
                    },
                    revoke: function (id) {

                    }
                }
            });
    }

});
