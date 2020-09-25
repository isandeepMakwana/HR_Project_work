package stunning.programmer.hr.servlets;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class NotifyFormResubmitted extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try
{
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("Forms are not be resubmitted \n Please don't Refresh this page  ");

messageBean.setGenerateButton(true);
messageBean.setGenerateTwoButton(false);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("index.jsp");
request.setAttribute("messageBean",messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request, response);
}
catch (Exception exception){
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request, response);
}
catch(Exception e)
{
// do nothing
}
}
}
}