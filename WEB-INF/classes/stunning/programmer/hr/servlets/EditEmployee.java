package stunning.programmer.hr.servlets;
import stunning.programmer.hr.beans.*;
import stunning.programmer.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditEmployee extends HttpServlet
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
String employeeId=request.getParameter("employeeId");
EmployeeDAO employeeDAO = new EmployeeDAO();
EmployeeDTO employeeDTO=employeeDAO.getByEmployeeId(employeeId);
EmployeeBean employeeBean;
employeeBean= new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setDesignation(employeeDTO.getDesignation());
employeeBean.setDateOfBirth(employeeDTO.getDateOfBirth().toString());
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setPanNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean", employeeBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("EmployeeEditForm.jsp");
try{
requestDispatcher.forward(request, response);
}
catch(Throwable t){
System.out.println(t);}
}
catch(DAOException daoexception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("Employees.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
}
}