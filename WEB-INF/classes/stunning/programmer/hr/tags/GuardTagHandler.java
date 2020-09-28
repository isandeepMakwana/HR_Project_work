package stunning.programmer.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class GuardTagHandler extends TagSupport{
public GuardTagHandler()
{
reset();
}
private void reset()
{
// do nothing
}
public int doStartTag()
{
String userName=(String)pageContext.getAttribute("userName", PageContext.SESSION_SCOPE);
if(userName==null)
{
return super.EVAL_BODY_INCLUDE;
}
return super.SKIP_BODY;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}