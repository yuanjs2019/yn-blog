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
</head>
<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    .slogan .feature-container {
        width: 32%;
        padding: 60px 32px;
        margin: 12px 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: rgba(255, 255, 255, 0.87);
        box-shadow: 0 4px 16px 0 rgba(190, 197, 203, 0.5);
        border-radius: 16px;
    }

    .home-button.-outline {
        color: rgba(255, 255, 255, 1);
        background-color: #548255;
        border: 1px solid #548255;
        box-shadow: none;
        border-radius: 16px;
    }
    .charpter-description .intro-table .row {
        cursor: pointer;
    }
    .charpter-description .intro-table .row .col-2 {
        text-align: left;
        font-size: 13px;
        border-right: none;
        line-height: 20px;
    }
    .charpter-description .description-container .home-description, .charpter-description .description-container .intro-table .row .col-2, .charpter-description .intro-table .row .description-container .col-2 {
        line-height: 28px;
        margin-bottom: 20px;
    }
    .charpter-description .intro-table .row .col-2 {
        text-align: left;
        font-size: 13px;
        border-right: none;
        line-height: 20px;
    }
    .charpter-description .intro-table .row .col-1, .charpter-description .intro-table .row .col-2 {
        padding: 16px;
        text-align: center;
        border: 1px solid #d9d9d9;
    }
    .charpter-description .intro-table .row:hover {
        background: #a5e4ea;
    }
    .charpter-description .intro-table .row .col-1:hover {
        background: #1FC3CB;
    }
</style>

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


<div style="width:100%;padding-top:70px;"></div>
<div class="home-background -no-max-width no-opacity">
    <#--  <img src="${re.contextPath}/themes/img/banner.svg"/>-->
</div>

<div class="slogan">
    <div class="home-container">
        <h1 class="slogan-title"><img src="${re.contextPath}/themes/img/logo.png" alt="yjs"></h1>
        <p class="slogan-description">
            😈：${ynMain}
        </p>
        <div class="button-groups">
            <a class="home-button -shadow" href="${re.contextPath}/"><i class="fa fa-home"></i>进入博客</a>
            <a class="home-button -outline" style="margin-left:20px;" href="https://github.com/yuanjs2019"
               target="_blank"><i class="fa fa-github-alt"></i> Github</a>
            <a class="home-button" style="color:rgba(255,255,255,1);background-color:rgba(63,81,181,.9);
            border:1px solid rgba(63,81,181,.9);box-shadow:none;" href="https://gitee.com/yuan625"
               target="_blank"><i class="fa fa-git"></i> GitEE</a>
        </div>
        <div class="feature">
            <#list mainProjectsList as mainproject>
            <div class="feature-container">
                <img class="img" src="${mainproject.headPicture}"/>
                <h2 class="feature-title">${mainproject.title}</h2>
                <p class="home-description">
                    ${mainproject.simpleExplain}
                </p>
            </div>
            </#list>
            <#--<div class="feature-container">
                <img class="img" src="${re.contextPath}/themes/img/action.svg"/>
                <h2 class="feature-title">项目实战</h2>
                <p class="home-description">
                    分享主流开发框架的基本原理、使用场景、注意事项、整合方案以及实际项目中的最佳实践等
                </p>
            </div>
            <div class="feature-container">
                <img class="img" src="${re.contextPath}/themes/img/architecture.svg"/>
                <h2 class="feature-title">平台架构</h2>
                <p class="home-description">
                    结合实际项目，分享当下热门软件架构设计的核心思想和实践经验，如常见的分层架构、事件驱动架构、微核架构、微服务架构以及云架构
                </p>
            </div>-->
        </div>
    </div>
</div>

<div class="charpter-description">
    <div class="home-container">
        <div class="container">
            <div class="img-container -hidden-mobile">
                <img src="https://cdn.ramostear.com/hotest.gif" style="width:100%">
            </div>
            <div class="description-container">
                <h3 class="title">阅读榜单</h3>
                <table class="intro-table" style="width:100%">
                    <tbody>
                    <#list readList as redx>
                    <tr class="row">
                        <td class="col-2"><a href="${re.contextPath}/dtails/id/${redx.id}" target="_blank">${redx.title}</a></td>
                        <td class="col-1"><a href="${re.contextPath}/dtails/id/${redx.id}" target="_blank">
                                <i class="fa fa-eye"></i> ${redx.readNums}</a></td>
                    </tr>
                    </#list>
                    <#--<tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/20/xgjoix9a.html" target="_blank">2.
                                架构师必备技能指南：SaaS(软件即服务)架构设计</a></td>
                        <td class="col-1"><a href="/blog/2020/03/20/xgjoix9a.html" target="_blank"><i
                                        class="fa fa-eye"></i> 21,220</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/20/rjld06fe.html" target="_blank">3. JSON Web
                                Token绝非银弹，“蹲坑”需谨慎小心</a></td>
                        <td class="col-1"><a href="/blog/2020/03/20/rjld06fe.html" target="_blank"><i
                                        class="fa fa-eye"></i> 20,934</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/22/m763440m.html" target="_blank">4.
                                尤娜博客系统新的征程(una-boot-1.2.0已上线)</a></td>
                        <td class="col-1"><a href="/blog/2020/03/22/m763440m.html" target="_blank"><i
                                        class="fa fa-eye"></i> 19,729</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/04/08/t029f7tj.html" target="_blank">5.
                                如何部署微服务架构下的应用程序？</a></td>
                        <td class="col-1"><a href="/blog/2020/04/08/t029f7tj.html" target="_blank"><i
                                        class="fa fa-eye"></i> 18,667</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/20/taa0ve0f.html" target="_blank">6.
                                尤娜-极致简洁，为极客创作而生</a></td>
                        <td class="col-1"><a href="/blog/2020/03/20/taa0ve0f.html" target="_blank"><i
                                        class="fa fa-eye"></i> 18,513</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/20/20w5f6n9.html" target="_blank">7. 在生产环境中重启Spring
                                Boot应用</a></td>
                        <td class="col-1"><a href="/blog/2020/03/20/20w5f6n9.html" target="_blank"><i
                                        class="fa fa-eye"></i> 18,018</a></td>
                    </tr>
                    <tr class="row">
                        <td class="col-2"><a href="/blog/2020/03/20/lnx5467y.html" target="_blank">8.
                                鱼与熊掌得兼：Hibernate与Mybatis共存</a></td>
                        <td class="col-1"><a href="/blog/2020/03/20/lnx5467y.html" target="_blank"><i
                                        class="fa fa-eye"></i> 15,403</a></td>
                    </tr>-->
                    </tbody>
                </table>
            </div>
        </div>
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
    })
</script>
</body>
</html>