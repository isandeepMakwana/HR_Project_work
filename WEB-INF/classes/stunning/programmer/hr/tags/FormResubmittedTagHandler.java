package stunning.programmer.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
public class FormResubmittedTagHandler extends TagSupport{
public FormResubmittedTagHandler()
{
reset();
}
private void reset()
{
// do nothing
}
public int doStartTag()
{
HttpServletRequest request;
request = (HttpServletRequest)pageContext.getRequest();
String formID= request.getParameter("formID");
if(formID==null)return super.EVAL_BODY_INCLUDE;
String formIDInSession = (String)pageContext.getAttribute(formID, PageContext.SESSION_SCOPE);
if(formIDInSession==null)
{
return super.EVAL_BODY_INCLUDE;
}

pageContext.removeAttribute(formID, PageContext.SESSION_SCOPE);

if(formIDInSession.equals(formID))
{
return super.SKIP_BODY;
}
else
{
return super.EVAL_BODY_INCLUDE;
}
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}