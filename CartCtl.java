package in.co.online.fashion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.online.fashion.bean.BookClothesBean;
import in.co.online.fashion.bean.CartBean;
import in.co.online.fashion.bean.UserBean;
import in.co.online.fashion.exception.ApplicationException;
import in.co.online.fashion.exception.DuplicateRecordException;
import in.co.online.fashion.model.BookClothesModel;
import in.co.online.fashion.model.CartModel;
import in.co.online.fashion.util.DataUtility;
import in.co.online.fashion.util.ServletUtility;

/**
 * Servlet implementation class CartCtl
 */
@WebServlet(name="CartCtl",urlPatterns={"/ctl/CartCtl"})
public class CartCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	
	
	private static Logger log=Logger.getLogger(CartCtl.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("BookClothesCtl doGet method start"); 
		String op = DataUtility.getString(request.getParameter("operation"));
	        
		HttpSession session=request.getSession();
		long clId=DataUtility.getLong(request.getParameter("cIdd"));
		UserBean uBean=(UserBean)session.getAttribute("user");
		CartBean bean=new CartBean();
		CartModel model=new CartModel();
		if(clId>0) {
			bean.setClothesId(clId);
			bean.setUserId(uBean.getId());
			try {
				model.add(bean);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				e.printStackTrace();
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	        ServletUtility.forward("BookClothesCtl?cId="+clId, request, response);
	        log.debug("BookClothesCtl doGet method end");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return null;
	}

}
