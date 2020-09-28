package stunning.programmer.hr.servlets;
import stunning.programmer.hr.beans.*;
import stunning.programmer.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request , HttpServletResponse response)
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

try
{
int code =0;
try
{
code = Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException e)
{
System.out.println(e);
}
DesignationDAO designationDAO = new DesignationDAO();
DesignationDTO designationDTO;
designationDTO=designationDAO.getByCode(code);
DesignationBean designationBean;
designationBean = new DesignationBean();
designationBean.setTitle(designationDTO.getTitle());
designationBean.setCode(code);
request.setAttribute("designationBean", designationBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("DesignationEditForm.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
catch(DAOException daoexception)
{
ErrorBean errorBean;
errorBean = new ErrorBean();
errorBean.setError(daoexception.getMessage());
request.setAttribute("errorBean" , errorBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("DesignationEditForm.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
}
}