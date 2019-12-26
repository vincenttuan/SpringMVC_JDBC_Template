<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <%@include file="header.jspf" %>
        <script>
            // Javascript
        </script>
    </head>
    <body>
        <div id="layout">

            <%@include file="menu.jspf" %>

            <div id="main">
                <div class="header">
                    <h1>Item 1</h1>
                    <h2>子頁面 1</h2>
                </div>

                <h2 class="content-subhead">Derby - 資料維護</h2>

            </div>
        </div>
            
    </body>
</html>
