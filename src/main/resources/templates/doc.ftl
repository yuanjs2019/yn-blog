<!DOCTYPE html>
<html>
<head>
    <title>softbabet博客</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${re.contextPath}/upload/favicon.png" rel="shortcut icon" type="image/x-icon">
    <link href="${re.contextPath}/themes/css/base-min.css" rel="stylesheet"/>
    <link href="${re.contextPath}/themes/css/main.css" rel="stylesheet"/>
    <link href="${re.contextPath}/themes/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${re.contextPath}/themes/css/extends.css" rel="stylesheet"/>
    <link href="${re.contextPath}/themes/css/md-preview.css" rel="stylesheet"/>
</head>

<body style="overflow-x: hidden;">
<header style="position: fixed;width: 100%;z-index: 999" class="ss-header">
    <nav class="navbar" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a class="logo-link" href="${re.contextPath}/">
                <img class="logo" src="${re.contextPath}/themes/img/logo.png">
            </a>
            <div class="-show-mobile">
                <a id="mobile-menu-icon">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </a>
                <nav id="mobile-menu">
                    <div id="una-menu-search-mobile" class="navbar-search-mobile">
                        <input class="input2" placeholder="请输入要搜索的关键词">
                        <a id="search2" href="${re.contextPath}/search/">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </a>
                    </div>
                    <a class="" href="${re.contextPath}/projects"> <span> 项目 </span></a>
                    <a class="" href="${re.contextPath}/blog"> <span> 博客 </span></a>
                    <a class="" href="${re.contextPath}/documents"> <span> 文档 </span></a>
                    <a class="" href="${re.contextPath}/pigeonhole"> <span> 归档 </span></a>
                    <a class="" href="${re.contextPath}/uselink"> <span> 友情连接 </span></a>
                    <a class="" href="${re.contextPath}/about"> <span> 关于我 </span></a>
                </nav>
            </div>
        </div>
        <div class="navbar-menu -hidden-mobile">
            <div class="navbar-start">
                <a class="navbar-item " href="${re.contextPath}/projects">项目</a>
                <a class="navbar-item " href="${re.contextPath}/blog">博客</a>
                <a class="navbar-item " href="${re.contextPath}/documents">文档</a>
                <a class="navbar-item " href="${re.contextPath}/pigeonhole">归档</a>
                <a class="navbar-item " href="${re.contextPath}/uselink">友情连接</a>
                <a class="navbar-item " href="${re.contextPath}/about">关于我</a>
            </div>

            <div class="navbar-end">
                <div class="navbar-item">
                    <div id="una-menu-search" class="navbar-search">
                        <input class="input" placeholder="请输入要搜索的关键词">
                        <a id="search" href="${re.contextPath}/search/">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<div class="main-data">
    <div class="ss-document-container">
        <div class="document-body with-sidebar">
            <div class="sidebar">
                <div class="sidebar-header">
                    <div class="search-form" style="text-align:center;">
                        文档目录
                    </div>
                </div>
                <div class="sidebar-body">
                    <div class="catalog-body">
                        <ul>
                            <#list docCatalogs as docatax>
                                <#if docatax_index == 0>
                                    <li class="active">
                                        <div class="wholerow"></div>
                                        <i class="custom-icon"></i>
                                        <a href="${re.contextPath}/doc/${docatax.docId}/${docatax.id}"
                                           class="text">${docatax.title}</a>
                                    </li>
                                </#if>
                                <#if docatax_index != 0>
                                    <li class="${docatax.type}">
                                        <div class="wholerow"></div>
                                        <i class="custom-icon caret fa fa-caret-right"></i>
                                        <a href="${re.contextPath}/doc/${docatax.docId}/${docatax.id}"
                                           class="text">${docatax.title}</a>
                                        <#if (docatax.docCatalogs?exists) >
                                            <#if (docatax.docCatalogs?size>0) >
                                                <ul>
                                                    <#list docatax.docCatalogs as docatal>
                                                        <li class="${docatal.type}">
                                                            <div class="wholerow"></div>
                                                            <i class="custom-icon"></i>
                                                            <a href="${re.contextPath}/doc/${docatal.docId}/${docatal.id}"
                                                               class="text">${docatal.title}</a>
                                                        </li>
                                                    </#list>
                                                </ul>
                                            </#if>
                                        </#if>
                                    </li>
                                </#if>
                            </#list>
                        </ul>
                    </div>
                </div>
                <div class="sidebar-copyright">
                    ©2020-softbabet
                </div>
            </div>
            <div class="workspace">
                <div class="article">
                    <div class="article-head">
                        <div class="tools">
                            <a class="item toggle-show-sidebar">
                                <i class="fa fa-align-justify"></i>
                            </a>
                        </div>
                        <h1>
                            <#if detailsContent?exists>
                                ${detailsContent.subhead}
                            </#if>
                        </h1>
                    </div>
                    <div class="article-body typo custom-typo editormd-html-preview editormd-preview-theme-dark">
                        <#if detailsContent?exists>
                            ${detailsContent.content}
                        </#if>
                    </div>
                    <div class="article-foot">
                        <div class="article-comment">
                            <div id="gitalk-container"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${re.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    //搜索失去焦点实现
    $(".input").blur(function () {
        let searchvalue = $(".input").val();
        let orgdata = $('#search').attr('href');
        $('#search').attr('href', orgdata + "1/" + searchvalue)
    })
    $(".toggle-show-sidebar").on("click", function () {
        $(".document-body").toggleClass("with-sidebar");
    });
    $(".document-body .sidebar .sidebar-body .catalog-body ul li").hover(function () {
        $(this).toggleClass("hover");
    });
    $(".caret").on("click", function () {
        var that = $(this);
        $(that).parent("li").toggleClass("open");
        if ($(that).hasClass("fa-caret-down")) {
            $(that).removeClass("fa-caret-down");
            $(that).addClass("fa-caret-right");
        } else {
            $(that).removeClass("fa-caret-right");
            $(that).addClass("fa-caret-down");
        }
    });
    $("#mobile-menu-icon").click(function () {
        $("#mobile-menu").addClass("-active")
    });

    $(".main-data").mouseup(function () {
        $("#mobile-menu").removeClass()
    });
    $(".input2").blur(function () {
        let searchvalue = $(".input2").val();
        let orgdata = $('#search2').attr('href');
        $('#search2').attr('href', orgdata + "1/" + searchvalue)
    })
</script>


</body>
</html>