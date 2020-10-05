package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
RequestDispatcher requestDispatcher;
try
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
}
catch(Exception exception)
{
//do nothing
}
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
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
//=====================================

try
{
DesignationBean designationBean;
designationBean= (DesignationBean)request.getAttribute("designationBean");
if(designationBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request, response);
}
int code = designationBean.getCode();
DesignationDAO designationDAO = new DesignationDAO();
try{
designationDAO.deleteByCode(code);

MessageBean messageBean ;
messageBean = new MessageBean();
messageBean.setHeading("Designation (Delete Module) ");
messageBean.setMessage("Designation Deleted ");
messageBean.setGenerateButton(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean", messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request, response);

}catch(DAOException daoexception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("Designations.jsp");
requestDispatcher.forward(request, response);
}
}
catch(Exception e)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
try{
requestDispatcher.forward(request, response);
}
catch(Exception exception2){}
}
}
}