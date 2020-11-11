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
        <!-- <div class="lh-100">
           <h6 class="mb-0 text-white lh-100">Bootstrap</h6>
          <small>Since 2011</small>
        </div>-->
    </div>
    <div class="my-3 p-3 bg-red rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0"><strong>编辑页面</strong></h6>
        <div id="onlyId" style="display: none"><#if orgBlog?exists> ${orgBlog.id}</#if></div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px">文章标题</strong>
            <div class="col-md-6">
                <input class="form-control input-group-lg" id="artcleTitle"
                       value="<#if orgBlog?exists> ${orgBlog.title}</#if>" type="text">
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px">文章作者</strong>
            <div class="col-md-6">
                <input class="form-control input-group-lg" id="artcleAutor"
                       value="<#if orgBlog?exists>${orgBlog.author}</#if>" type="text">
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px">头文图片</strong>
            <div class="col-md-6">
                <input class="form-control input-group-lg" id="artclePicture"
                       value="<#if orgBlog?exists>${orgBlog.mainPicture}</#if>" type="text">
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">内容简介</strong>
            <div class="col-md-9">
                <textarea class="form-control input-group-lg" id="artcleIntro">
                    <#if orgBlog?exists>
                        ${orgBlog.description}
                    </#if>
                </textarea>
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文章标签</strong>
            <div class="col-md-6">
                <div id="tagxid" class="selectPickerWrapper">
                    <select class="hidden" multiple="multiple">
                        <#list tagList as tagx>
                            <option value="${tagx.tagCode}">${tagx.tagName}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文章分类</strong>
            <div class="col-md-6">
                <div id="classifxid" class="selectPickerWrapper">
                    <select class="hidden" multiple="multiple">
                        <#list classifList as classifx>
                            <option value="${classifx.classifyCode}">${classifx.classifyName}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>

        <div class="media text-muted pt-3">
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文章系列</strong>
            <div class="col-md-6">
                <div id="seriesxid" class="selectPickerWrapper">
                    <select class="hidden">
                        <#list seriesList as seriesx>
                            <option value="${seriesx.sericsCode}">${seriesx.sericsName}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>

        <div class="media text-muted pt-3">
            <#--<strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文章类型</strong>
            <div class="col-md-6">
                <label class="radio-inline">
                    <input type="radio" name="" id="radio2">原创
                </label>
                <label class="radio-inline">
                    <input type="radio" name="" id="radio1"> 转载
                </label>
            </div>-->
            <strong class="d-block text-gray-dark" style="float: left;margin-right: 20px;">文章类型</strong>
            <div class="col-md-6">
                <div id="typexid" class="selectPickerWrapper">
                    <select class="hidden">
                        <option value="2">原创</option>
                        <option value="1">转载</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="media text-muted pt-3">
        </div>
        <div id="layout">
            <div id="test-editormd">
                <textarea style="display:none;" id="textContent" name="textContent">
                    <#if orgBlog?exists>
                        ${orgBlog.textContent}
                    </#if>
          </textarea>
                <textarea id="text" class="editormd-html-textarea" name="text">
                    <#if orgBlog?exists>
                        ${orgBlog.content}
                    </#if>
                </textarea>
            </div>
        </div>

        <small class="d-block text-left mt-3">
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
        $("#tagxid").mySelect();
        $("#classifxid").mySelect();
        $("#seriesxid").mySelect();
        $("#typexid").mySelect();
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

    function saveHtml() {
        var id = $("#onlyId").text();
        //文章内容
        var content = $("#text").text();
        //文章内容
        var textContent = $("#textContent").text();
        //文章标题
        var artcleTitle = $("#artcleTitle").val();
        //文章作者
        var artcleAutor = $("#artcleAutor").val();
        //文章头文图片地址
        var artclePicture = $("#artclePicture").val();
        //文章简介
        var artcleIntro = $("#artcleIntro").val();
        //文章标签
        var tagsStr = $('#tagxid .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //文章分类
        var classifStr = $('#classifxid .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //文章标签
        var seriesxStr = $('#seriesxid .duihao-checked').map(function () {
            return this.id
        }).get().join();
        //文章标签
        var typexStr = $('#typexid .duihao-checked').map(function () {
            return this.id
        }).get().join();

        //提交数据
        var url = "${re.contextPath}/admin/save";
        var obj = {
            id: id,
            content: content,
            author: artcleAutor,
            textContent: textContent,
            artcleTitle: artcleTitle,
            artclePicture: artclePicture,
            artcleIntro: artcleIntro,
            tagsStr: tagsStr,
            classifStr: classifStr,
            seriesxStr: seriesxStr,
            type: typexStr
        };
        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function (data) {
                if (data.code == 200) {
                    alert("提交成功!");

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