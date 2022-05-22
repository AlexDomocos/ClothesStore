<%@page import="in.co.online.fashion.controller.BookClothesCtl"%>
<%@page import="in.co.online.fashion.controller.CategoryCtl"%>
<%@page import="in.co.online.fashion.util.ServletUtility"%>
<%@page import="in.co.online.fashion.util.DataUtility"%>
<%@page import="in.co.online.fashion.bean.ClothesBean"%>
<%@page import="in.co.online.fashion.model.ClothesModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book</title>
</head>
<body>
<div class="site-wrap">
<%@ include file="Header.jsp" %>
<% Long cloId=(Long)session.getAttribute("coId");
      			ClothesModel cModel=new ClothesModel();
      			ClothesBean clBean= cModel.findByPK(cloId);
      		
      		%>
<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"> <strong class="text-black"><%=clBean.getName()%></strong></div>
        </div>
      </div>
    </div>  
<form action="<%=OFSView.BOOK_CLOTHES_CTL%>" method="post" >
    <div class="site-section">
      <div class="container">
      
      		
        <div class="row">
          <div class="col-md-6">
            <img src="<%=OFSView.APP_CONTEXT%>/images/<%=clBean.getImage()%>" alt="Image" class="img-fluid">
          </div>
          <div class="col-md-6">
          <% String msg=(String)request.getAttribute("msg");%>
             <p><%=(msg!=null)?msg:""%></p>
            <h2 class="text-black"><%=clBean.getName()%></h2>
            <p><%=clBean.getDescription() %></p>
            <p><strong class="text-primary h4"><%=clBean.getPrice()%>Rs</strong></p>
         	<%if(msg==null){ %>
            <div class="mb-1 d-flex">
              <label for="option-sm" class="d-flex mr-3 mb-3">
                <span class="d-inline-block mr-2" style="top:-2px; position: relative;"><input type="radio"  name="cSize" value="Small"></span> <span class="d-inline-block text-black">Small</span>
              </label>
              <label for="option-md" class="d-flex mr-3 mb-3">
                <span class="d-inline-block mr-2" style="top:-2px; position: relative;"><input type="radio"  name="cSize"  value="Medium"></span> <span class="d-inline-block text-black">Medium</span>
              </label>
              <label for="option-lg" class="d-flex mr-3 mb-3">
                <span class="d-inline-block mr-2" style="top:-2px; position: relative;"><input type="radio"  name="cSize"  value="Large"></span> <span class="d-inline-block text-black">Large</span>
              </label>
              <label for="option-xl" class="d-flex mr-3 mb-3">
                <span class="d-inline-block mr-2" style="top:-2px; position: relative;"><input type="radio" name="cSize"   value="Extra Large"></span> <span class="d-inline-block text-black"> Extra Large</span>
              </label>
            </div>
            <div class="mb-5">
              <div class="input-group mb-3" style="max-width: 120px;">
              <div class="input-group-prepend">
                <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
              </div>
              <input type="text" class="form-control text-center" name="quantity" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
              <div class="input-group-append">
                <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
              </div>
            </div>

            </div>
            <p><a href="CartCtl?cIdd=<%=clBean.getId()%>" class="buy-now btn btn-sm btn-primary">Add To Cart</a></p>
          </div>
           <%} %>
        </div>
       
        <%if(msg==null){ %>
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Fill And Book</h2>
            
          </div>
          <div class="col-md-7">
			
            
            
            <jsp:useBean id="bean" class="in.co.online.fashion.bean.BookClothesBean"
			scope="request"></jsp:useBean>
			
			<input type="hidden" name="clothesId" value="<%=cloId%>">
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
                    <label for="c_email" class="text-black">Email Id<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  name="email" placeholder="Enter Email Id" 
                    value="<%=DataUtility.getStringData(bean.getEmailId())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("email", request)%></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">PinCode<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  name="pinCode" placeholder="Enter Pin Code" 
                    value="<%=DataUtility.getStringData(bean.getPinCode())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("pinCode", request)%></font>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">LandMark<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"  name="land" placeholder="Enter Land Mark" 
                    value="<%=DataUtility.getStringData(bean.getLandMark())%>" >
                    <font color="red"> <%=ServletUtility.getErrorMessage("land", request)%></font>
                  </div>
                </div>
               
                 
                
               
				<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Address</label>
                    <textarea name="address"  cols="30" rows="4" class="form-control"><%=DataUtility.getStringData(bean.getAddress())%></textarea>
                 <font color="red"> <%=ServletUtility.getErrorMessage("address", request)%></font>
                  </div>
                </div>

                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=BookClothesCtl.OP_CONFIRM_PAY%>">
                  </div>
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" name="operation" value="<%=BookClothesCtl.OP_CANCEL%>">
                  </div>
                </div>
              </div>
          
          </div>
           <%} %>
 </div>
       
      </div>
    </div>
  </form>
  
  
<div style="margin-top: 20px">
<%@ include file="Footer.jsp" %>
</div>
</div>
</body>
</html>