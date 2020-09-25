package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try
{
AdministrationBean administrationBean;
administrationBean = (AdministrationBean)request.getAttribute("administrationBean");

if(administrationBean==null){
ErrorBean errorBean= new ErrorBean();
errorBean.setError("Invalid username / password ");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request, response);
return;
}
String userName= administrationBean.getUserName();
String password= administrationBean.getPassword();

AdministrationDTO administrationDTO;
administrationDTO = new AdministrationDTO();
try
{
administrationDTO = new AdministrationDAO().getByUserName(userName);
}
catch(DAOException daoException)
{
ErrorBean errorBean= new ErrorBean();
errorBean.setError("Invalid username / password ");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request, response);
}
String dlpassword=administrationDTO.getPassword();
if(dlpassword.equals(password)==false)
{
ErrorBean errorBean= new ErrorBean();
errorBean.setError("wrong password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request, response);
return;
}
HttpSession session= request.getSession();
session.setAttribute("userName", userName);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request, response);
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
}
}