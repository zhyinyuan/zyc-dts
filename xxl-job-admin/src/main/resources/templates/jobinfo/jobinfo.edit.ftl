<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link type="text/css" href="${request.contextPath}/static/myflow/css/jquery-ui-1.8.4.custom.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/myflow/css/index.css">


    <script type="text/javascript" src="${request.contextPath}/static/myflow/js/raphael-min.js"></script>
    <#--<script type="text/javascript" src="${request.contextPath}/static/myflow/js/jquery.min.js"></script>-->
    <!-- jQuery 2.1.4 -->
    <script src="${request.contextPath}/static/adminlte/bower_components/jquery/jquery.min.js"></script>
    <script src="${request.contextPath}/static/myflow/js/jquery-ui.min.js"></script>



    <script type="text/javascript" src="${request.contextPath}/static/myflow/js/myflow.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/myflow/js/myflow.jpdl4.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/myflow/js/myflow.editors.js"></script>

    <#-- layer -->
    <script src="${request.contextPath}/static/plugins/layer/layer.js"></script>

    <title>任务调度中心</title>
</head>
<body>
<div id="myflow_tools" class="ui-widget-content">
    <div id="myflow_tools_handle" style="text-align: center;"
         class="ui-widget-header"> 工具集 </div>

    <div class="node" id="myflow_revoke"><img src="${request.contextPath}/static/myflow/img/save.gif" />&nbsp;&nbsp;撤销</div>
    <div class="node" id="myflow_redraw"><img src="${request.contextPath}/static/myflow/img/save.gif" />&nbsp;&nbsp;重绘</div>
    <div class="node" id="myflow_save"><img src="${request.contextPath}/static/myflow/img/save.gif" />&nbsp;&nbsp;保存</div>
    <div class="node" id="myflow_publish"><img src="${request.contextPath}/static/myflow/img/save.gif" />&nbsp;&nbsp;发布</div>
    <div>

        <hr />
    </div>
    <div class="node selectable selected" id="pointer"><img
            src="${request.contextPath}/static/myflow/img/select16.gif" />&nbsp;&nbsp;选择</div>
    <div class="node selectable" id="path"><img
            src="${request.contextPath}/static/myflow/img/16/flow_sequence.png" />&nbsp;&nbsp;转换</div>
    <div>
        <hr />
    </div>
    <div class="node state" id="start" type="start"><img
            src="${request.contextPath}/static/myflow/img/16/start_event_empty.png" />&nbsp;&nbsp;开始</div>
    <div class="node state" id="state" type="state"><img
            src="${request.contextPath}/static/myflow/img/16/task_empty.png" />&nbsp;&nbsp;状态</div>
    <div class="node state" id="task" type="task"><img
            src="${request.contextPath}/static/myflow/img/16/task_empty.png" />&nbsp;&nbsp;任务</div>
    <div class="node state" id="fork" type="fork"><img
            src="${request.contextPath}/static/myflow/img/16/gateway_parallel.png" />&nbsp;&nbsp;分支</div>
    <div class="node state" id="join" type="join"><img
            src="${request.contextPath}/static/myflow/img/16/gateway_parallel.png" />&nbsp;&nbsp;合并</div>
    <div class="node state" id="end" type="end"><img
            src="${request.contextPath}/static/myflow/img/16/end_event_terminate.png" />&nbsp;&nbsp;结束</div>
    <div class="node state" id="end-cancel" type="end-cancel"><img
            src="${request.contextPath}/static/myflow/img/16/end_event_cancel.png" />&nbsp;&nbsp;取消</div>
    <div class="node state" id="end-error" type="end-error"><img
            src="${request.contextPath}/static/myflow/img/16/end_event_error.png" />&nbsp;&nbsp;错误</div>
</div>

<div id="myflow_props" class="ui-widget-content">
    <div id="myflow_props_handle" class="ui-widget-header">属性</div>
    <table border="1" width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td>aaa</td>
        </tr>
        <tr>
            <td>aaa</td>
        </tr>
    </table>
    <div>&nbsp;</div>
</div>

<div id="myflow"></div>
<script>
    var base_url = '${request.contextPath}';
    var I18n = ${I18nUtil.getMultString()};
    // 参数
    var flag = '${operFlag}';

    function isEmptyObject(e) {
        var t;
        for (t in e)
            return !1;
        return !0
    }
    <#--var handleCode = '${handleCode}';-->
    <#--var executorAddress = '${executorAddress!}';-->
    <#--var triggerTime = '${triggerTime?c}';-->
    <#--var logId = '${logId}';-->
</script>
<script type="text/javascript" src="${request.contextPath}/static/js/jobinfo.edit.1.js"></script>
</body>
</html>