package stunning.programmer.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RestrictTagHandler extends TagSupport{
public RestrictTagHandler()
{
reset();
}
private void reset()
{
// do nothing
}
public int doStartTag()
{
try
{
HttpServletRequest request;
request =(HttpServletRequest)pageContext.getRequest(); 
HttpServletResponse response;
response =(HttpServletResponse)pageContext.getResponse(); 
HttpSession session = request.getSession();
String userName=(String)session.getAttribute("userName");
if(userName==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return super.SKIP_BODY;
}
return super.SKIP_BODY;
}catch (Exception exception)
{
return super.SKIP_BODY;
}
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}