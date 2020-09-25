package stunning.programmer.hr.tags;
import stunning.programmer.hr.beans.*;
import stunning.programmer.hr.dl.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class DesignationsTagHandler extends TagSupport{
private List<DesignationBean> designations;
private int index;
public DesignationsTagHandler()
{
reset();
}
private void reset()
{
index=0;
if(designations!=null)
{
designations.clear();
designations = null;
}
}
public int doStartTag()
{
List<DesignationDTO> dldesignations = null;
DesignationDAO designationDAO = new DesignationDAO();
try
{
dldesignations=designationDAO.getAll();
}
catch(DAOException daoException)
{
System.out.println(daoException);
return super.SKIP_BODY;
}
if(dldesignations.size()==0)return super.SKIP_BODY;
designations = new ArrayList<>();
DesignationBean designationBean;
for(DesignationDTO dldesignation:dldesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(dldesignation.getCode());
designationBean.setTitle(dldesignation.getTitle());
designations.add(designationBean);
}

int index = 0;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean", designationBean, PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber", new Integer(index+1));
return super.EVAL_BODY_INCLUDE;
}

public int doAfterBody()
{
index++;
if(designations.size()==index)
{
return super.SKIP_BODY;
}
DesignationBean designationBean;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean", designationBean, PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber", new Integer(index+1));
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}