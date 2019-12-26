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
            $(document).ready(function () {
                $(".delete").click(function () {
                    var href = $(this).attr("href");
                    $("#_method").val("DELETE")
                    $("#myform").attr("action", href).submit();
                    return  false;
                })
            })
        </script>
    </head>
    <body>
        <div id="layout">

            <%@include file="menu.jspf" %>

            <div id="main">
                <div class="header">
                    <h1>Discount Code</h1>
                    <h2>優惠券設定</h2>
                </div>

                <table>
                    <td valign="top">
                        <div class="content">
                            <form id="myform" class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/discount_code/">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">Discount Code - 資料維護</h2>
                                    </legend>
                                    <input type="text" placeholder="優惠碼" id="discount_code" name="discount_code" value="${map.DISCOUNT_CODE}"><p/>
                                    <input type="text" placeholder="折扣" id="rate" name="rate" value="${map.RATE}"><p/>
                                    <input type="hidden" id="_method" name="_method" value="${_method}">
                                    <button type="submit" class="pure-button pure-button-primary">${_method}</button>
                                </fieldset>
                            </form>
                        </div>
                    </td>
                    <td valign="top">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend>
                                        <h2 class="content-subhead">Discount Code - 資料查詢</h2>
                                    </legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Discount Code</th>
                                                <th>Rate</th>
                                                <th>Update</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td>${item.DISCOUNT_CODE}</td>
                                                    <td>${item.RATE}</td>
                                                    <td><a href="${pageContext.request.contextPath}/mvc/discount_code/${item.DISCOUNT_CODE}">修改</td>
                                                    <td><a href="${pageContext.request.contextPath}/mvc/discount_code/${item.DISCOUNT_CODE}" class="delete">刪除</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>
                    </td>
                </table>

            </div>
        </div>



    </body>
</html>
