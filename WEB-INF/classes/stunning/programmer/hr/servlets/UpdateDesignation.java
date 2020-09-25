package stunning.programmer.hr.servlets;
import stunning.programmer.hr.beans.*;
import stunning.programmer.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request , HttpServletResponse response)
{
int code = 0;
try{
DesignationBean designationBean;
designationBean = (DesignationBean)request.getAttribute("designationBean");
code = Integer.parseInt(request.getParameter("code"));
DesignationDTO designationDTO = new DesignationDTO();
designationDTO.setCode(code);
String title;
title = designationBean.getTitle();
designationDTO.setTitle(title);
DesignationDAO designation = new DesignationDAO();
try{
designation.update(designationDTO);
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Designation (Edit Modul) ");
messageBean.setMessage("Designation Updated ");
messageBean.setGenerateButton(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean" , messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
catch(DAOException daoException){
ErrorBean errorBean;
errorBean = new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean" , errorBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("DesignationEditForm.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
}
catch(Exception exception){
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