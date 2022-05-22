package in.co.online.fashion.controller;

public interface OFSView {
	
	public String APP_CONTEXT = "/OnlineFashionStore";

	public String LAYOUT_VIEW = "/BaseLayout.jsp";
	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/Error.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";
	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";
	
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";	
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	
	
	public String CATEGORY_VIEW = PAGE_FOLDER + "/CategoryView.jsp";	
	public String CATEGORY_LIST_VIEW = PAGE_FOLDER + "/CategoryListView.jsp";
	
	public String CLOTHES_VIEW = PAGE_FOLDER + "/ClothesView.jsp";	
	public String CLOTHES_LIST_VIEW = PAGE_FOLDER + "/ClothesListView.jsp";
	
	public String CART_VIEW = PAGE_FOLDER + "/CartView.jsp";	
	public String CART_LIST_VIEW = PAGE_FOLDER + "/CartListView.jsp";
	
	public String FASHION_LIST_VIEW = PAGE_FOLDER + "/FashionListView.jsp";
	
	public String BOOK_CLOTHES_VIEW = PAGE_FOLDER + "/BookClothesView.jsp";	
	public String BOOK_CLOTHES_LIST_VIEW = PAGE_FOLDER + "/BookClothesListView.jsp";
		
	
	public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp";	
	
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";

	
	

	public String ERROR_CTL = "/ctl/ErrorCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	
	
	public String CATEGORY_CTL = APP_CONTEXT + "/ctl/CategoryCtl";
	public String CATEGORY_LIST_CTL = APP_CONTEXT + "/ctl/CategoryListCtl";
	
	public String CART_CTL = APP_CONTEXT + "/ctl/CartCtl";
	public String CART_LIST_CTL = APP_CONTEXT + "/ctl/CartListCtl";
	
	
	public String CLOTHES_CTL = APP_CONTEXT + "/ctl/ClothesCtl";
	public String CLOTHES_LIST_CTL = APP_CONTEXT + "/ctl/ClothesListCtl";
	
	public String FASHION_LIST_CTL = APP_CONTEXT + "/ctl/FashionListCtl";
	
	public String BOOK_CLOTHES_CTL = APP_CONTEXT + "/ctl/BookClothesCtl";
	public String BOOK_CLOTHES_LIST_CTL = APP_CONTEXT + "/ctl/BookClothesListCtl";
	
	
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";



}
