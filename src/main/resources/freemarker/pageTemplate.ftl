<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>苦作舟</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
		body:{font-family:Helvetica, Tahoma, Arial, 'Heiti SC', 'Microsoft YaHei'}
		.item{

		}
		.item ul{
		  background-color:#f8f8f8;
		  text-align:center;
		  list-style:none;
		  min-height:200px;
		  border-radius:10px;
		  margin:0 auto;
		}
		.item ul li{
		  text-align:center;
		  color:#049fd9;
		}
		.pre-btn{
		  display:none;
		}
		.print-btn{
		  display:none;
		}
		.nxt-btn,.tutorial-menu{
		  display:none;
		}
		.active a{
			color:#fff !important;
		}
	</style>
</head>
<body>
<nav class="one-page-header navbar navbar-fixed-top navbar-default" data-role="navigation">
    <div class="container">
        <div class="menu-container page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">	<span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">
                <b style="color:#049fd9"> 苦作舟</b>
            </a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <div class="menu-container">
                <ul class="nav navbar-nav">
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="col-md-12" style="margin-top:51px;">
    <div class="col-md-3" style="margin-top:20px;">
        <ul class="list-group">
            <#list contentList as content>
                <li class="list-group-item <#if title == content.title>active</#if>"><a href="/mongodb/${(content.title)!}.html">${(content.title)!""}</a></li>
            </#list>
        </ul>
    </div>

    <div class="col-md-8">
        ${htmlStr}
    </div>
</div>
</body>
</html>