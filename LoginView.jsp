<%@page import="in.co.online.fashion.controller.LoginCtl"%>
<%@page import="in.co.online.fashion.util.ServletUtility"%>
<%@page import="in.co.online.fashion.util.DataUtility"%>
<%@page import="in.co.online.fashion.controller.OFSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="site-wrap">
<%@ include file="Header.jsp" %>
 <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><strong class="text-black">Login</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Login</h2>
            
          </div>
          <div class="col-md-7">
			
            <form action="<%=OFSView.LOGIN_CTL%>" method="post">
            
            <jsp:useBean id="bean" class="in.co.online.fashion.bean.UserBean"
			scope="request"></jsp:useBean>
			
			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
              
              <div class="p-3 p-lg-5 border">
               <center><b><font color="red"> <%=ServletUtility.getErrorMessage(request)%></font></b>
               <b><font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font></b>
               </center>
               
               
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Login Id <span class="text-danger">*</span></label>
                    <input type="email" class="form-control"  name="login" placeholder="Enter Login Id" 
                    value="<%=DataUtility.getStringData(bean.getLogin())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Password<span class="text-danger">*</span></label>
                    <input type="password" class="form-control" name="password" placeholder="Enter Password"
                    value="<%=DataUtility.getStringData(bean.getPassword())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font>
                  </div>
                </div>
                
              
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=LoginCtl.OP_SIGN_IN%>">
                  </div>
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
                  </div>
                </div>
                 
              </div>
            </form>
          </div>
 </div>
      </div>
    </div>

<%@ include file="Footer.jsp" %>
</div>
</body>
</html>