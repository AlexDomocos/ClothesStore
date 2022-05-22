<%@page import="in.co.online.fashion.controller.BookClothesCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<div class="site-wrap">
<%@ include file="Header.jsp" %>
 <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"> <strong class="text-black">Payment</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Payment</h2>
            
          </div>
          <div class="col-md-7">
			
            <form action="<%=OFSView.BOOK_CLOTHES_CTL%>" method="post"  >
            
           
			
			
              
              <div class="p-3 p-lg-5 border">
           
               
               
            
               
               
               
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Card No.<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  placeholder="Enter Card No " > 
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Card Holder Name<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  placeholder="Enter Card Holder Name" > 
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_email" class="text-black">Month<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  placeholder="Enter Month MM" > 
                  </div>
                  <div class="col-md-6">
                    <label for="c_email" class="text-black">Year<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  placeholder="Enter Year yyyy" > 
                  </div>
                </div>
               
                 
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">CVV No.<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  placeholder="Enter CVV" > 
                  </div>
                </div>
               
				

                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=BookClothesCtl.OP_BOOK_PAY%>">
                  </div>
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=BookClothesCtl.OP_CANCEL%>">
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