<%@page import="in.co.online.fashion.controller.CategoryCtl"%>
<%@page import="in.co.online.fashion.util.ServletUtility"%>
<%@page import="in.co.online.fashion.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<div class="site-wrap">
<%@ include file="Header.jsp" %>
 <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"> <strong class="text-black">Add Category</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Add Category</h2>
            
          </div>
          <div class="col-md-7">
			
            <form action="<%=OFSView.CATEGORY_CTL%>" method="post" enctype="multipart/form-data" >
            
            <jsp:useBean id="bean" class="in.co.online.fashion.bean.CategoryBean"
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
                    <label for="c_email" class="text-black">Name<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  name="name" placeholder="Enter Category Name" 
                    value="<%=DataUtility.getStringData(bean.getName())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font>
                  </div>
                </div>
               
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Image<span class="text-danger">*</span></label>
                    <input type="file" class="form-control"  name="photo" placeholder="Enter Image"
                    value="<%=DataUtility.getStringData(bean.getImage())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("photo", request)%></font>
                  </div>
                </div>
                
               
				<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Description</label>
                    <textarea name="description"  cols="30" rows="4" class="form-control"><%=DataUtility.getStringData(bean.getDescription())%></textarea>
                 <font color="red"> <%=ServletUtility.getErrorMessage("description", request)%></font>
                  </div>
                </div>

                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=CategoryCtl.OP_SAVE%>">
                  </div>
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=CategoryCtl.OP_RESET%>">
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