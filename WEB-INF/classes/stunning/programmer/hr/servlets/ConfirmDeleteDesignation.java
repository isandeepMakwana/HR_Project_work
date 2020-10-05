package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
HttpSession ss = request.getSession();
if(ss.getAttribute("userName")==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
try{
requestDispatcher.forward(request, response);
}
catch(Exception e){}
}
doPost(request,response);
}
//===============================================
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try
{
String codeString = request.getParameter("code");
int code=Integer.parseInt(codeString);
RequestDispatcher requestDispatcher;
if (codeString==null || code<=0)
{
requestDispatcher = request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request, response);
return;
}
}catch(Exception e)
{
//do nothing
}
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
}catch(Exception e)
{
// do nothing 
}
}

}