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
</head>

<body>
<header class="ss-header">
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
    <div style="width:100%;padding-top:70px;">
        <div class="ss-title"><i class="fa fa-book"></i>文档</div>
    </div>
    <div class="home-background -no-max-width no-opacity">
        <#--<img src="${re.contextPath}/themes/img/001.svg"/>-->
        <#--<img src="${re.contextPath}/themes/img/blog-banner.svg"/>-->
    </div>
    <div class="ss-layout-container">
        <main class="ss-layout-main">
            <div class="ss-list">
                <h2 class="list-title "><a>技术文档</a></h2>
                <div class="list">
                    <#list documentList as document>
                        <div class="ss-card ss-document-card">
                            <div class="card-content">
                                <div class="ss-document-wrap">
                                    <a href="${re.contextPath}/doc/${document.id}" class="document-detail">
                                        <div class="document-thumb">
                                            <img src="${document.cover}">
                                        </div>
                                        <div class="document-content">
                                            <h4>${document.title}</h4>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </main>
        <aside class="ss-layout-aside">
            <div class="ss-card">
                <h2 class="card-title custom-card-title">
                    最新阅读
                </h2>
                <div class="card-content">
                    <ol class="posts-list list-space-sm list-unstyled">
                        <#list blogLaterList as laterData>
                            <#if laterData_index == 0>
                                <li>
                                    <article
                                            class="post-overlay post-overlay-bottom post-overlay-floorfade post-overlay-xs">
                                        <div class="cover-img"
                                             style="background-image: url(${laterData.mainPicture})"></div>
                                        <div class="post-text inverse-text">
                                            <div class="post-text-wrap">
                                                <div class="post-text-inner">
                                                    <h3 class="post-title typescale-1">
                                                        ${laterData.title}
                                                    </h3>
                                                    <div class="post-meta">
                                                        <span><i class="fa fa-user"> ${laterData.author}</i></span>
                                                        <time class="time published">
                                                            <i class="fa fa-calendar-o"> ${laterData.createTime}</i>
                                                        </time>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="${re.contextPath}/dtails/id/${laterData.id}"
                                               class="link-overlay"></a>
                                        </div>
                                    </article>
                                </li>
                            </#if>
                            <#if laterData_index !=0>
                                <li>
                                    <article class="post post-horizontal post-horizontal-xxs">
                                        <div class="post-thumb min-height-70">
                                            <a href="#">
                                                <img src="${laterData.mainPicture}" alt=""
                                                     style="width: 80px;height: 80px">
                                            </a>
                                        </div>
                                        <div class="post-text">
                                            <h3 class="post-title typescale-0">
                                                <a href="${re.contextPath}/dtails/id/${laterData.id}"> ${laterData.title}</a>
                                            </h3>
                                            <div class="post-meta">
                                                <time class="time published">
                                                    <i class="fa fa-calendar-o"> ${laterData.createTime}</i>
                                                </time>
                                            </div>
                                        </div>
                                    </article>
                                </li>
                            </#if>
                        </#list>
                    </ol>
                </div>
            </div>
            <div class="ss-card">
                <h2 class="card-title custom-card-title">
                    热门文章
                </h2>
                <div class="card-content">
                    <ol class="posts-list list-space-sm list-unstyled">
                        <#list readMoreList as readmore>
                            <li>
                                <article class="post post-horizontal post-horizontal-xxs">
                                    <div class="post-thumb min-height-70">
                                        <a href="#">
                                            <img src="${readmore.mainPicture}"
                                                 alt="" style="width: 80px;height: 80px">
                                        </a>
                                    </div>
                                    <div class="post-text">
                                        <h3 class="post-title typescale-0">
                                            <a href="${re.contextPath}/dtails/id/${readmore.id}">${readmore.title}</a>
                                        </h3>
                                        <div class="post-meta">
                                            <time class="time published">
                                                <i class="fa fa-calendar-o">${readmore.createTime}</i>
                                            </time>
                                        </div>
                                    </div>
                                </article>
                            </li>
                        </#list>
                    </ol>
                </div>
            </div>
        </aside>
    </div>
</div>
<footer class="ss-footer">
    <div class="container">
        <div class="links">
            <div class="cate">
                <h2 class="cate-title">个人链接</h2>
                <a class="link" href="https://gitee.com/yuan625">码云</a>
                <a class="link" href="https://github.com/yuanjs2019">Github</a>
                <a class="link" href="https://www.jianshu.com/u/58ce6f7c9fd0">简书</a>
            </div>

            <div class="cate">
                <h2 class="cate-title">社区</h2>
                <a class="link" href="https://github.com/yuanjs2019">Github</a>
            </div>

            <div class="cate">
                <h2 class="cate-title">友情链接</h2>
                <a class="link" href="https://www.ramostear.com/">谭潮红博客</a>
                <a class="link" href="https://xujin.org/">玹霖志博客</a>
                <a class="link" href="http://springcloud.cn">springcloud社区</a>
                <a class="link" href="http://blog.springcloud.cn">springcloud博客社区</a>
            </div>

            <div class="cate">
                <h2 class="cate-title">工具</h2>
                <a class="link" href="http://www.processon.com/">ProcessOn</a>
                <a class="link" href="http://md.aclickall.com/">微信排版</a>
                <a class="link" href="https://www.gaoding.com">稿定设计</a>
                <a class="link" href="https://www.draw.io/">Draw</a>
            </div>

        </div>
        <div class="qrcode">
            <div>
                <img class="qrcode-img" src="${re.contextPath}/themes/img/qq.jpg"/>
                <p class="qrcode-desc"><i class="fa fa-wechat"></i>625621105</p>
            </div>
            <div>
                <img class="qrcode-img" src="${re.contextPath}/themes/img/weixin.jpg"/>
                <p class="qrcode-desc"><i class="fa fa-qq"></i>yuan782063616</p>
            </div>
        </div>
    </div>
    <div class="copyright">
        <p>
            © 2020 Softbabert
            <a href="#">京ICP备xxx号</a>
            <span id="busuanzi_container_site_pv">
            本站访问量：<span id="busuanzi_value_site_pv"></span>次
        </span>
            &nbsp;
            <span id="busuanzi_container_site_uv">
            您是本站第 <span id="busuanzi_value_site_uv"></span> 位访问者
        </span>
        </p>
    </div>
</footer>
<script src="${re.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    //搜索失去焦点实现
    $(".input").blur(function () {
        let searchvalue = $(".input").val();
        let orgdata = $('#search').attr('href');
        $('#search').attr('href', orgdata + "1/" + searchvalue)
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