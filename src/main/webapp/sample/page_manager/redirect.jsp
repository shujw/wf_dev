<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body></body>
</html>
<% System.out.println("=*==*==*==*==*==*==*==*==*==*==*==*==*==*=" + request.getHeader("x-jp-co-intra-mart-ajax-request")); %>
<% jp.co.intra_mart.foundation.page.PageManager.getInstance().redirect("/temp/context/req.jsp", request, response); %>