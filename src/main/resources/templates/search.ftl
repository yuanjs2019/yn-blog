<!DOCTYPE html>
<html>
<head>
    <title>softbabet博客</title>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${re.contextPath}/upload/favicon.png" rel="shortcut icon" type="image/x-icon">
    <link href="${re.contextPath}/themes/css/base-min.css" rel="stylesheet" />
    <link href="${re.contextPath}/themes/css/main.css" rel="stylesheet" />
    <link href="${re.contextPath}/themes/css/font-awesome.min.css" rel="stylesheet" />
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
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-menu"></use>
                    </svg>
                </a>
                <nav id="mobile-menu">
                    <a class="" href="${re.contextPath}/projects"> <span> 项目 </span>
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-ARROW"></use>
                        </svg>
                    </a>
                    <a class="" href="${re.contextPath}/blog"> <span> 博客 </span>
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-ARROW"></use>
                        </svg>
                    </a>
                    <a class="" href="${re.contextPath}/pigeonhole"> <span> 归档 </span>
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-ARROW"></use>
                        </svg>
                    </a>
                    <a class="" href="${re.contextPath}/about"> <span> 关于我 </span>
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-ARROW"></use>
                        </svg>
                    </a>
                </nav>
            </div>
        </div>
        <div class="navbar-menu -hidden-mobile">
            <div class="navbar-start">
                <a class="navbar-item " href="${re.contextPath}/projects">项目</a>
                <a class="navbar-item " href="${re.contextPath}/blog">博客</a>
                <a class="navbar-item " href="${re.contextPath}/pigeonhole">归档</a>
                <a class="navbar-item " href="${re.contextPath}/about">关于我</a>
            </div>


            <div class="navbar-end">
                <div class="navbar-item">
                    <div id="una-menu-search" class="navbar-search">
                        <input id="search-input" class="input" placeholder="请输入要搜索的关键词">
                        <a id="search" href="${re.contextPath}/search/">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>


<div style="width:100%;padding-top:70px;"> <div class="ss-title custom-ss-title">全文检索</div></div>
<div class="home-background -no-max-width no-opacity">
    <img src="${re.contextPath}/themes/img/banner.svg" />
</div>
<div class="ss-layout-container">
    <main class="ss-layout-main -card -noaside">
        <div class="ss-search">
            <div class="input-wrapper">
                <div class="search-icon">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-search">
                            <svg id="icon-search" viewBox="0 0 1024 1024">
                                <path d="M927.104 866.816l-195.626667-208.768C780.629333 601.770667 810.666667 528.426667 810.666667 448 810.666667 271.530667 667.136 128 490.666667 128S170.666667 271.530667 170.666667 448 314.197333 768 490.666667 768c65.322667 0 126.08-19.754667 176.768-53.461333l197.461333 210.688L927.104 866.816zM256 448C256 318.592 361.258667 213.333333 490.666667 213.333333S725.333333 318.592 725.333333 448 620.074667 682.666667 490.666667 682.666667 256 577.408 256 448z">
                                </path>
                            </svg>
                        </use>
                    </svg>
                </div>
                <input id="js-search-input" class="input" type="text" value="${keywords}" placeholder="${keywords}">
                <a id="js-search-button" onclick="newsearch()" class="button">搜索</a>
            </div>
            <div id="js-result-container" class="search-container">
                <#if pageInfo.total==0>
                    <div class="not-found">暂无搜索结果</div>
                   </#if>
                   <#if pageInfo.total!=0>
                   <#list pageInfo.list as pagex>
                   <div class="ss-summary">
                    <div class="title">
                        <a href="${re.contextPath}/dtails/id/${pagex.id}">${pagex.title}</a>
                    </div>
                    <div class="summary">${pagex.description}
                    </div>
                </div>
                </#list>
                </#if>
                <nav class="ss-pagination" data-total="${pageInfo.total}" data-current="${pageInfo.pageNum}">
                    <ul id="ul-list" class="list">
                        <a href="/1"> <li class="item -active">1</li></a>
                        <a href="/2"><li class="item"> 2 </li></a>
                    </ul>
                </nav>
            </div>
        </div>
    </main>
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
    //进入加载
    $(function () {
        $("#ul-list").remove();
        var html = '<ul id="ul-list" class="list">';
        var pageNum = ${pageInfo.pageNum};
        var pages = ${pageInfo.pages};
        if(pages < 1){
        } else if(0 < pages &&  pages < 4){
            for(let i = 1, len = pages+1; i < len; i++) {
                if(i == pageNum){
                    html+='<a href="${re.contextPath}/search/'+i+'/${keywords}"> <li class="item -active">'+i+'</li></a>'
                }else{
                    html+='<a href="${re.contextPath}/search/'+i+'/${keywords}"><li class="item ">'+i+'</li></a>';
                }
            }
        }else{
            if( pageNum ==1) {
                html += '<a href="${re.contextPath}/search/1/${keywords}"><li class="item -active">1</li></a>'
                    + '<a href="${re.contextPath}/search/2/${keywords}"><li class="item ">2</li></a>'
                    + '<a href="${re.contextPath}/search/3/${keywords}"><li class="item ">3</li></a>'
            }else if(pageNum == pages){
                html +='<a href="${re.contextPath}/search/'+(pages-2)+'/${keywords}"><li class="item ">'+(pages-2)+'</li></a>'
                    +'<a href="${re.contextPath}/search/'+(pages-1)+'/${keywords}"><li class="item ">'+(pages-1)+'</li></a>'
                    +'<a href="${re.contextPath}/search/'+pages+'/${keywords}"><li class="item -active">'+pages+'</li></a>';
            }else{
                html +='<a href="${re.contextPath}/search/'+(pageNum-1)+'/${keywords}"><li class="item ">'+(pageNum-1)+'</li></a>'
                    +'<a href="${re.contextPath}/search/'+pageNum+'/${keywords}"><li class="item -active">'+pageNum+'</li></a>'
                    +'<a href="${re.contextPath}/search/'+(pageNum+1)+'/${keywords}"><li class="item ">'+(pageNum+1)+'</li></a>';
            }
        }
        html += '</ul>';
        $(".ss-pagination").append(html);
    });

    //搜索失去焦点实现
    $("#search-input").blur(function () {
        let searchvalue = $("#search-input").val();
        let orgdata = $('#search').attr('href');
        $('#search').attr('href', orgdata +"1/"+searchvalue)
    })


    function newsearch() {
        let searchvalue = $("#js-search-input").val();
         window.location.href='${re.contextPath}/search/1/'+searchvalue;
    }
</script>
</body>
</html>