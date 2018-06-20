<%@tag description="Layout Template" pageEncoding="UTF-8" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="css" fragment="true" %>
<%@attribute name="js" fragment="true" %>
<%
    String base_url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.flushBuffer();
%>
<!DOCTYPE html>
<!--[if lte IE 9]><html class="old no-js"><![endif]--><!--><html class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="cache-control" content="max-age=0"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="referrer" content="always">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="<%=base_url%>favicon.ico" type="image/x-icon">
    <link rel="icon" href="<%=base_url%>favicon.ico" type="image/x-icon">
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="<%=base_url%>ext/css/outdatedbrowser.css">
    <script src="<%=base_url%>ext/js/cookie.js"></script>
    <script src="<%=base_url%>ext/js/outdatedbrowser.js"></script>
    <script>
        //event listener: DOM ready
        function addLoadEvent(func) {
            var oldonload = window.onload;
            if (typeof window.onload != 'function') {
                window.onload = func;
            } else {
                window.onload = function () {
                    if (oldonload) {
                        oldonload();
                    }
                    func();
                }
            }
        }

        // call plugin function after DOM ready
        addLoadEvent(function () {
            var status = Cookies.get('confirmOldBrowser');
            if (status) {
                return false;
            }
            outdatedBrowser({
                bgColor: '#f25648',
                color: '#ffffff',
                lowerThan: 'boxShadow1',
                languagePath: '<%=base_url%>ext/lang/zh-cn.html'
            });
        });
    </script>
    <![endif]-->
    <jsp:invoke fragment="title"/>
    <jsp:invoke fragment="css"/>
</head>
<body class="relative">
<!--[if lte IE 9]>
<div id="outdated"></div><![endif]-->
<jsp:doBody/>
<jsp:invoke fragment="js"/>
</body>
</html>