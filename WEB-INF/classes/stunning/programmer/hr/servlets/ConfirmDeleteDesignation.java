package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
try
{
int code = 0;
try
{
code = Integer.parseInt(request.getParameter("code"));
}
catch (NumberFormatException nfe)
{
//nfe
}
DesignationDAO designationDAO = new DesignationDAO();
DesignationDTO designationDTO;
try{
designationDTO  = designationDAO.getByCode(code);
String title ;
title = designationDTO.getTitle();

DesignationBean designationBean = new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(title);
request.setAttribute("designationBean", designationBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request, response);

}catch(DAOException daoexception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("Designations.jsp");
requestDispatcher.forward(request, response);
}
}catch(Exception e){}
}

}