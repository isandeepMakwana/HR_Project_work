package stunning.programmer.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class FormIDTagHandler extends TagSupport{
public FormIDTagHandler()
{
reset();
}
private void reset()
{
//do nothing 
}
public int doStartTag()
{
String formID = UUID.randomUUID().toString();
pageContext.setAttribute(formID, formID, PageContext.SESSION_SCOPE);
JspWriter jw = pageContext.getOut();
try
{
jw.print("<input type='hidden' name ='formID' id ='formID' value ='"+formID+"'>");
}
catch(IOException ioe){
// do nothing 
}
return super.SKIP_BODY;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}