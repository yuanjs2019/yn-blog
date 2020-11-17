<!--suppress ALL-->
<!DOCTYPE html>
<html lang="zh">

<!--head-->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>softbabet配置</title>
    <link rel="shortcut icon" href="${re.contextPath}/upload/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${re.contextPath}/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${re.contextPath}/assets/css/bootstrap-v4.1.3.min.css">
    <style>
        p {
            float:left;
            margin-right: 10px
        }
    </style>
</head>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-dark border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">
    </h5>
    <nav class="my-2 my-md-0 mr-md-3">
    </nav>
    <a class="btn btn-outline-primary" href="#">登 录</a>
</div>
<main role="main" class="container">
    <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
        <img class="mr-3" src="${re.contextPath}/assets/img/logo.png" alt="">
    </div>
    <div class="my-3 p-3 bg-red rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0"><strong>配置页面</strong></h6>
        <div class="media text-muted pt-3">
            <button type="button" class="btn btn-info" id="tags" style="margin-right: 20px;">
                <strong>标签</strong>
            </button>
            <div>
                <#list tagsBo as tagx>
                    <p style="color:${tagx.color};">${tagx.name}</p>
                </#list>
            </div>
        </div>

        <div class="media text-muted pt-3">
            <button th:type="button" class="btn btn-info" id="classify" style="margin-right: 20px;">
                <strong>分类</strong>
            </button>
            <div>
                <#list classifBo as classifx>
                    <p style="color:${classifx.color};">${classifx.name}</p>
                </#list>
            </div>
        </div>

        <div class="media text-muted pt-3">
            <button type="button" class="btn btn-info" id="secrisc" style="margin-right: 20px;">
                <strong>系列</strong>
            </button>
            <div>
                <#list secriscBo as secriscx>
                    <p style="color:${secriscx.color};">${secriscx.name}</p>
                </#list>
            </div>
        </div>

        <div class="media text-muted pt-3">
            <button type="button" class="btn btn-info" id="doc" style="margin-right: 20px;">
                <strong>文档</strong>
            </button>
            <div>
                <#list documentBo as documenx>
                    <p style="color:${documenx.color};">${documenx.name}</p>
                </#list>
            </div>
        </div>
    </div>
</main>
<!-- 模态框 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 id="" class="modal-title"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- 模态框主体 -->
            <div class="modal-body">
                <strong class="modal-body-name"></strong> <input id="mainContent" class="form-control input-group-lg" type="text">
                <strong class="modal-body-key"></strong> <input id="mainCode" class="form-control input-group-lg" type="text">
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" onclick="saveTo()" class="btn btn-success">确定</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<!--script-->
<script src="${re.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script src="${re.contextPath}/assets/js/bootstrap-v4.1.3.min.js"></script>
<script src="${re.contextPath}/assets/js/select.js"></script>
<script type="text/javascript">
    $("#tags").click(function () {
        $('.modal-title').attr('id', 'tags');
        $('.modal-title').html('添加标签');
        $('.modal-body-name').html('名 称:');
        $('.modal-body-key').html('码 值:');
        $('#myModal').modal('show');

    });
    $("#classify").click(function () {
        $('.modal-title').attr('id', 'classify');
        $('.modal-title').html('添加分类');
        $('.modal-body-name').html('名 称:');
        $('.modal-body-key').html('码 值:');
        $('#myModal').modal('show');

    });
    $("#secrisc").click(function () {
        $('.modal-title').attr('id', 'secrisc');
        $('.modal-title').html('添加系列');
        $('.modal-body-name').html('名 称:');
        $('.modal-body-key').html('码 值:');
        $('#myModal').modal('show');
    });

    $("#doc").click(function () {
        $('.modal-title').attr('id', 'doc');
        $('.modal-title').html('添加文档');
        $('.modal-body-name').html('文档名称:');
        $('.modal-body-key').html('文档封面:');
        $('#myModal').modal('show');

    });

    $('#myModal').on('hide.bs.modal', function () {
        $("#mainContent").val("");
        $("#mainCode").val("");
        $('.modal-title').removeAttr('id');
        $('.modal-title').val("");
        $('.modal-body-name').val("");
        $('.modal-body-key').val("");
    });

    function saveTo() {
        let id = $('.modal-title').attr('id');
        let content = $('#mainContent').val();
        let mainCode = $('#mainCode').val();
        var url = "${re.contextPath}/admin/tags/";
        var obj = {type: id, vaule: content, code: mainCode};
        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function (data) {
                if (data.code == 200) {
                    $('#myModal').modal('hide');
                } else {
                    alert(data.message);
                }
            },
            error: function () {
                alert("后台异常，请稍后再试!");
            }
        });
    }


</script>
</body>
</html>