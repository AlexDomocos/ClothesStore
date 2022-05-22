package in.co.online.fashion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.online.fashion.bean.BaseBean;
import in.co.online.fashion.bean.BookClothesBean;
import in.co.online.fashion.bean.CartBean;
import in.co.online.fashion.bean.UserBean;
import in.co.online.fashion.exception.ApplicationException;
import in.co.online.fashion.model.BookClothesModel;
import in.co.online.fashion.model.CartModel;
import in.co.online.fashion.util.DataUtility;
import in.co.online.fashion.util.PropertyReader;
import in.co.online.fashion.util.ServletUtility;

/**
 * Servlet implementation class CartListCtl
 */
@WebServlet(name = "CartListCtl", urlPatterns = { "/ctl/CartListCtl" })
public class CartListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = Logger.getLogger(CartListCtl.class);

	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("CartListCtl populateBean method start");
		CartBean bean = new CartBean();
		bean.setClothesId(DataUtility.getLong(request.getParameter("name")));
		log.debug("CartListCtl populateBean method end");
		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("CartListCtl doGet method start");
		List list = null;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		CartModel model = new CartModel();
		CartBean bean = (CartBean) populateBean(request);
		
		long cartId=DataUtility.getLong(request.getParameter("crId"));
		
		try {
			
			if(cartId>0) {
				CartBean cBean=new CartBean();
				cBean.setId(cartId);
				model.delete(cBean);
				ServletUtility.setSuccessMessage("Data Delete Successfully", request);
			}
			
			HttpSession session=request.getSession();
			UserBean uBean=(UserBean)session.getAttribute("user");
			
			bean.setUserId(uBean.getId());
			
			
			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No Record Found", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			e.printStackTrace();
			return;
		}
		log.debug("CartListCtl doGet method end");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("CartListCtl doPost method start");
		List list = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));

		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;

		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		CartBean bean = (CartBean) populateBean(request);

		CartModel model = new CartModel();
		String[] ids = request.getParameterValues("ids");
		String op = DataUtility.getString(request.getParameter("operation"));

		if (OP_SEARCH.equalsIgnoreCase(op) || OP_NEXT.equalsIgnoreCase(op) || OP_PREVIOUS.equalsIgnoreCase(op)) {

			if (OP_SEARCH.equalsIgnoreCase(op)) {

				pageNo = 1;

			} else if (OP_NEXT.equalsIgnoreCase(op)) {

				pageNo++;
			} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {

				pageNo--;
			}
		} else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(OFSView.CART_CTL, request, response);
			return;
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				CartBean deletebean = new CartBean();
				for (String id : ids) {
					deletebean.setId(DataUtility.getInt(id));
					try {
						model.delete(deletebean);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						e.printStackTrace();
						return;
					}
				}
				ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(OFSView.BOOK_CLOTHES_LIST_CTL , request, response);
			return;

		}

		try {
			
			HttpSession session=request.getSession();
			UserBean uBean=(UserBean)session.getAttribute("user");
		
			bean.setUserId(uBean.getId());
			

			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("NO Record Found", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			e.printStackTrace();
			return;
		}

		log.debug("CartListCtl doPost method end");
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return OFSView.CART_LIST_VIEW;
	}

}
