<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>softbabet编辑</title>
    <link rel="shortcut icon" href="${re.contextPath}/upload/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${re.contextPath}/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${re.contextPath}/assets/css/bootstrap-v4.1.3.min.css">
    <link rel="stylesheet" href="${re.contextPath}/assets/css/select.css">
    <link rel="stylesheet" href="${re.contextPath}/editor/css/editormd.preview.min.css"/>
    <link rel="stylesheet" href="${re.contextPath}/editor/css/editormd.css"/>
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
        <h6 class="border-bottom border-gray pb-2 mb-0"><strong>编辑文档页面</strong></h6>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px">小节标题</strong>
            <div class="col-md-6">
                <input class="form-control input-group-lg" id="docTitle">
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文档主题</strong>
            <div class="col-md-6">
                <div id="docName" class="selectPickerWrapper">
                    <select class="hidden" multiple="multiple">
                        <#list documents as docname>
                            <option value="${docname.id}">${docname.title}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">一级标签</strong>
            <div class="col-md-6">
                <div id="fristTag" class="selectPickerWrapper">
                    <select id="fristTagselect" class="hidden" multiple="multiple">

                    </select>
                </div>
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">小节等级</strong>
            <div class="col-md-6">
                <div id="tageLevel" class="selectPickerWrapper">
                    <select class="hidden">
                        <option value="1">一级标签</option>
                        <option value="2">二级标签</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="media text-muted pt-3">
        </div>
        <div id="layout">
            <div id="test-editormd">
                <textarea style="display:none;" id="textContent" name="textContent">
          </textarea>
                <textarea id="text" class="editormd-html-textarea" name="text">
                </textarea>
            </div>
        </div>

        <small class="d-block text-left mt-3">
            <button type="button" onclick="queryByTitle()" class="btn btn-outline-primary"><strong>查询</strong></button>
            <button type="button" onclick="saveHtml()" class="btn btn-outline-primary"><strong>提交</strong></button>
        </small>
    </div>
</main>

<script src="${re.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script src="${re.contextPath}/assets/js/bootstrap-v4.1.3.min.js"></script>
<script src="${re.contextPath}/assets/js/select.js"></script>
<script src="${re.contextPath}/editor/lib/marked.min.js"></script>
<script src="${re.contextPath}/editor/lib/prettify.min.js"></script>
<script src="${re.contextPath}/editor/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;
    $(function () {
        $("#docName").mySelect();
        $("#tageLevel").mySelect();
        testEditor = editormd("test-editormd", {
            width: "100%",
            height: 640,
            syncScrolling: "single",
            path: "${re.contextPath}/editor/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "${re.contextPath}/file",
            saveHTMLToTextarea: true,
            previewTheme: "dark"
        });
    });

    function queryByTitle() {
        //文章分类
        var docId = $('#docName .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //查询数据
        var url = "${re.contextPath}/query/queryByDocId";
        var obj = {
            id: docId
        };
        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function (data) {
                if (data.code == 200) {
                    /*  $("#fristTagselect").remove();*/
                    $("#fristTag").empty();
                    var htmlx = '<select id="fristTagselect" class="hidden" multiple="multiple">'
                    if (data.data != null && data.data != undefined && data.data.length > 0) {
                        for (var i = 0; i < data.data.length; i++) {
                            htmlx += ' <option value="' + data.data[i].id + '">' + data.data[i].subhead + '</option>'
                        }
                    }
                    htmlx += '</select>';
                    $("#fristTag").append(htmlx);
                    $("#fristTag").mySelect();
                }
            },
            error: function () {
                alert("后台异常，请稍后再试!");
            }
        });
    }

    function saveHtml() {
        //文章分类
        var docId = $('#docName .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //文章一级标签
        var fristTag = $('#fristTag .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //小节标签
        var tageLevel = $('#tageLevel .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //小节标题
        var docTitle = $("#docTitle").val();
        //文章内容
        var content = $("#text").text();
        //文章内容
        var textContent = $("#textContent").text();
        //查询数据
        var url = "${re.contextPath}/admin/docSave";
        var obj = {
            id: docId,
            fristTag: fristTag,
            tageLevel: tageLevel,
            docTitle: docTitle,
            content: content,
            textContent: textContent
        };
        console.log(obj)

        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function (data) {
                if (data.code == 200) {
                    alert("提交成功!");
                }else{
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