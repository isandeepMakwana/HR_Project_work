package stunning.programmer.hr.tags;
import stunning.programmer.hr.beans.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class UserNameTagHandler extends TagSupport{
public UserNameTagHandler()
{
reset();
}
private void reset()
{
//do nothing 
}
public int doStartTag()
{
HttpServletRequest request;
request = (HttpServletRequest)pageContext.getRequest();
HttpSession ss= request.getSession();
String userName=(String)ss.getAttribute("userName");
if(userName==null)
{
userName="";
}
pageContext.setAttribute("username",userName, PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}