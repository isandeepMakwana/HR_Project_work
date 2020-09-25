package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try{
DesignationBean designationBean;
designationBean = (DesignationBean)request.getAttribute("designationBean");
String title;
title = designationBean.getTitle();
DesignationDTO designation;
designation = new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO = new DesignationDAO();
try
{
designationDAO.add(designation);
designationBean.setCode(designation.getCode());
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Designation(Add Module)");
messageBean.setMessage("Designation added , add More ? ");
messageBean.setGenerateButton(true);
messageBean.setGenerateTwoButton(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Designations.jsp");

request.setAttribute("messageBean", messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request, response);
}
catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean = new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/DesignationAddForm.jsp");
requestDispatcher.forward(request, response);
}
}
catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
try{
requestDispatcher.forward(request,response);
}
catch(Exception e){
System.out.println(e);
// do nothing 
}
}
}
}
