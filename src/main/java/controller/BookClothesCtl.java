package in.co.online.fashion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.online.fashion.bean.BaseBean;
import in.co.online.fashion.bean.BookClothesBean;
import in.co.online.fashion.bean.ClothesBean;
import in.co.online.fashion.bean.UserBean;
import in.co.online.fashion.exception.ApplicationException;
import in.co.online.fashion.exception.DuplicateRecordException;
import in.co.online.fashion.model.BookClothesModel;
import in.co.online.fashion.model.ClothesModel;
import in.co.online.fashion.util.DataUtility;
import in.co.online.fashion.util.DataValidator;
import in.co.online.fashion.util.PropertyReader;
import in.co.online.fashion.util.ServletUtility;

/**
 * Servlet implementation class BookClothesCtl
 */
@WebServlet(name="BookClothesCtl",urlPatterns={"/ctl/BookClothesCtl"})
public class BookClothesCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	
	private static Logger log=Logger.getLogger(BookClothesCtl.class);
       
	@Override
    protected boolean validate(HttpServletRequest request) {
		log.debug("BookClothesCtl validate method start");
        boolean pass = true;
        
        String op=DataUtility.getString(request.getParameter("operation"));

        if (DataValidator.isNull(request.getParameter("email"))) {
            request.setAttribute("email",
                    PropertyReader.getValue("error.require", "EmailId"));
            pass = false;
        }

        if (DataValidator.isNull(request.getParameter("pinCode"))) {
            request.setAttribute("pinCode",
                    PropertyReader.getValue("error.require", "PinCode"));
            pass = false;
        }
        
        if (DataValidator.isNull(request.getParameter("land"))) {
            request.setAttribute("land",
                    PropertyReader.getValue("error.require", "land"));
            pass = false;
        }
        
        if (DataValidator.isNull(request.getParameter("address"))) {
            request.setAttribute("address",
                    PropertyReader.getValue("error.require", "Address"));
            pass = false;
        }
        
        System.out.println("Validate book Clothes Before"+pass);
        
        if(OP_BOOK_PAY.equalsIgnoreCase(op)) {
        	pass=true;
        }
        
        System.out.println("Validate book Clothes"+pass);
        
        log.debug("BookClothesCtl validate method end");
        return pass;
    }

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("BookClothesCtl populateBean method start");
		BookClothesBean bean=new BookClothesBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setClothesId(DataUtility.getLong(request.getParameter("clothesId")));
		bean.setEmailId(DataUtility.getString(request.getParameter("email")));
		bean.setPinCode(DataUtility.getString(request.getParameter("pinCode")));
		bean.setLandMark(DataUtility.getString(request.getParameter("land")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));
		bean.setQuantity(DataUtility.getLong(request.getParameter("quantity")));
		bean.setClothesSize(DataUtility.getString(request.getParameter("cSize")));
		populateDTO(bean, request);
		log.debug("BookClothesCtl populateBean method end");
		return bean;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("BookClothesCtl doGet method start"); 
		String op = DataUtility.getString(request.getParameter("operation"));
	        
		HttpSession session=request.getSession();
		
		long clId=DataUtility.getLong(request.getParameter("cId"));
		session.setAttribute("coId",clId);
	       BookClothesModel model = new BookClothesModel();
	        long id = DataUtility.getLong(request.getParameter("id"));
	        ServletUtility.setOpration("Add", request);
	        if (id > 0 || op != null) {
	            System.out.println("in id > 0  condition");
	            BookClothesBean bean;
	            try {
	                bean = model.findByPK(id);
	                ServletUtility.setOpration("Edit", request);
	                ServletUtility.setBean(bean, request);
	            } catch (ApplicationException e) {
	                ServletUtility.handleException(e, request, response);
	                return;
	            }
	        }

	        ServletUtility.forward(getView(), request, response);
	        log.debug("BookClothesCtl doGet method end");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("BookCtl doPost method start");
		String op = DataUtility.getString(request.getParameter("operation"));
		BookClothesModel model = new BookClothesModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		HttpSession session=request.getSession();
		
		System.out.println("Operation in Do Post---------------"+op);
		System.out.println("BaseCtl----------------OP----"+OP_CONFIRM_PAY);
		if (OP_CONFIRM_PAY.equalsIgnoreCase(op)) {
			
			System.out.println("Operation in Do Post After---------------"+op);
			BookClothesBean bean = (BookClothesBean) populateBean(request);	
		
			ClothesModel  fModel=new ClothesModel();
			ClothesBean fBean;
			try {
				fBean = fModel.findByPK(bean.getClothesId());
				bean.setFinalPrice(fBean.getPrice()*bean.getQuantity());
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("BookB", bean);
			
			System.out.println("confirm And Payment do do Post");
			
			ServletUtility.forward(OFSView.PAYMENT_VIEW, request, response);
		
		
		}else if(OP_BOOK_PAY.equalsIgnoreCase(op)) {
			long pk=0;
			BookClothesBean bBean=(BookClothesBean)session.getAttribute("BookB");
			UserBean uBean=(UserBean)session.getAttribute("user");
			bBean.setName(uBean.getFirstName()+" "+uBean.getLastName());
			bBean.setMobileNo(uBean.getMobileNo());
			try {
				 pk=model.add(bBean);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("msg","Yours Order Is Successfully Booked");
			ServletUtility.forward(OFSView.BOOK_CLOTHES_VIEW, request, response);
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(OFSView.CLOTHES_LIST_CTL, request, response);
			return;
	} 
		System.out.println("Before Get View Method");
		ServletUtility.forward(getView(), request, response);
		log.debug("BookCtl doPost method end");
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return OFSView.BOOK_CLOTHES_VIEW;
	}

}
