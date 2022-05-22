<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.online.fashion.bean.CategoryBean"%>
<%@page import="in.co.online.fashion.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<div class="site-wrap">
<%@ include file="Header.jsp" %>

 
    
      <div class="site-section site-blocks-2">
      <div class="container">
        <div class="row">
        
         <%
                    int pageNo = ServletUtility.getPageNo(request);
                    int pageSize = ServletUtility.getPageSize(request);
                    int index = ((pageNo - 1) * pageSize) + 1;
                    CategoryBean bean=null;
                    List list = ServletUtility.getList(request);
                    Iterator<CategoryBean> it = list.iterator();

                    while (it.hasNext()) {

                         bean = it.next();
                %>
          <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="">
            <a class="block-2-item" href="<%=OFSView.CLOTHES_LIST_CTL%>?catg=<%=bean.getId()%>">
              <figure class="image">
                <img src="<%=OFSView.APP_CONTEXT%>/images/<%=bean.getImage()%>" alt="" class="img-fluid">
              </figure>
              <div class="text">
                <span class="text-uppercase">Collections</span>
                <h3><%=bean.getName()%></h3>
              </div>
            </a>
          </div>
         <%} %>
         
        </div>
      </div>
    </div>

<%@ include file="Footer.jsp" %>
</div>
</body>
</html>