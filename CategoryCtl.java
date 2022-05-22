package in.co.online.fashion.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import in.co.online.fashion.bean.BaseBean;
import in.co.online.fashion.bean.CategoryBean;
import in.co.online.fashion.exception.ApplicationException;
import in.co.online.fashion.exception.DuplicateRecordException;
import in.co.online.fashion.model.CategoryModel;
import in.co.online.fashion.util.DataUtility;
import in.co.online.fashion.util.DataValidator;
import in.co.online.fashion.util.PropertyReader;
import in.co.online.fashion.util.ServletUtility;

/**
 * Servlet implementation class CategoryCtl
 */
@WebServlet(name="CategoryCtl",urlPatterns={"/ctl/CategoryCtl"})
@MultipartConfig(maxFileSize = 16177215)
public class CategoryCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
	private static Logger log=Logger.getLogger(CategoryCtl.class);
	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	@Override
    protected boolean validate(HttpServletRequest request) {
		log.debug("CategoryCtl validate method start");
        boolean pass = true;

        if (DataValidator.isNull(request.getParameter("name"))) {
            request.setAttribute("name",
                    PropertyReader.getValue("error.require", "Name"));
            pass = false;
        }else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name",
					PropertyReader.getValue("error.name", "Name"));
			pass = false;
		}

        if (DataValidator.isNull(request.getParameter("description"))) {
            request.setAttribute("description",
                    PropertyReader.getValue("error.require", "Description"));
            pass = false;
        }

        log.debug("CategoryCtl validate method end");
        return pass;
    }
	
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("CategoryCtl populateBean method start");
		CategoryBean bean=new CategoryBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		populateDTO(bean, request);
		log.debug("CategoryCtl populateBean method end");
		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("CategoryCtl doGet method start"); 
		String op = DataUtility.getString(request.getParameter("operation"));
	        
	       CategoryModel model = new CategoryModel();
	        long id = DataUtility.getLong(request.getParameter("id"));
	        ServletUtility.setOpration("Add", request);
	        if (id > 0 || op != null) {
	            System.out.println("in id > 0  condition");
	            CategoryBean bean;
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
	        log.debug("CategoryCtl doGet method end");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("CategoryCtl doPost method start");
		String op=DataUtility.getString(request.getParameter("operation"));
		CategoryModel model=new CategoryModel();
		long id=DataUtility.getLong(request.getParameter("id"));
		if(OP_SAVE.equalsIgnoreCase(op)){
			
			
			CategoryBean bean=(CategoryBean)populateBean(request);
				try {
					
					String savePath = DataUtility.getString(PropertyReader.getValue("path")); 
					
					File fileSaveDir = new File(savePath);
				       if (!fileSaveDir.exists()) {
				           fileSaveDir.mkdir();
				       }
				       
				       
				       Part part = request.getPart("photo");
				       
				       String fileName = extractFileName(part);
				       part.write(savePath + File.separator + fileName);
				       
				       String filePath = fileName;
					
					
					bean.setImage(filePath);
					if(id>0){
						
					model.update(bean);
					ServletUtility.setOpration("Edit", request);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
	                ServletUtility.setBean(bean, request);

					}else {
						long pk=model.add(bean);
						//bean.setId(id);
						ServletUtility.setSuccessMessage("Data is successfully Saved", request);
						ServletUtility.forward(getView(), request, response);
					}
	              
				} catch (ApplicationException e) {
					e.printStackTrace();
					ServletUtility.forward(OFSView.ERROR_VIEW, request, response);
					return;
				
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(),
						request);
			}
			
		}else if (OP_DELETE.equalsIgnoreCase(op)) {
		CategoryBean bean=	(CategoryBean)populateBean(request);
		try {
			model.delete(bean);
			ServletUtility.redirect(OFSView.CATEGORY_LIST_CTL, request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			e.printStackTrace();
		}
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(OFSView.CATEGORY_LIST_CTL, request, response);
			return;
	}else if (OP_RESET.equalsIgnoreCase(op)) {
		ServletUtility.redirect(OFSView.CATEGORY_CTL, request, response);
		return;
}
				
		
		ServletUtility.forward(getView(), request, response);
		 log.debug("CategoryCtl doPost method end");
	}
	
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return OFSView.CATEGORY_VIEW;
	}

}
